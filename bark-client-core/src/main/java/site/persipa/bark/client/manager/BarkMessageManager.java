package site.persipa.bark.client.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import site.persipa.bark.client.service.BarkMessageService;
import site.persipa.bark.constant.BarkApiConstant;
import site.persipa.bark.enums.exception.BarkMessageExceptionEnum;
import site.persipa.bark.mapstruct.MapBarkMessageMapper;
import site.persipa.bark.pojo.client.BarkMessage;
import site.persipa.bark.pojo.client.BarkServerInfo;
import site.persipa.bark.pojo.client.bo.BarkMessageSendBaseBo;
import site.persipa.bark.pojo.client.bo.BarkMessageSendBo;
import site.persipa.bark.pojo.client.bo.BarkResultBo;
import site.persipa.bark.pojo.client.dto.BarkMessageSendDto;
import site.persipa.cloud.exception.PersipaRuntimeException;

/**
 * @author persipa
 */
@Component
@RequiredArgsConstructor
public class BarkMessageManager {

    private final BarkMessageService barkMessageService;

    private final RestTemplate restTemplate;

    private final MapBarkMessageMapper mapBarkMessageMapper;

    public boolean healthCheck() {
        String s = restTemplate.getForObject(BarkApiConstant.BARK_URL_TEMPLATE, String.class, BarkApiConstant.HEALTH_CHECK);
        return "ok".equals(s);
    }

    public boolean ping() {
        BarkResultBo resultBo = restTemplate.getForObject(BarkApiConstant.BARK_URL_TEMPLATE, BarkResultBo.class, BarkApiConstant.PING);
        return resultBo != null && "pong".equals(resultBo.getMessage());
    }


    public BarkServerInfo info() {
        return restTemplate.getForObject(BarkApiConstant.BARK_URL_TEMPLATE, BarkServerInfo.class, BarkApiConstant.INFO);
    }

    public boolean push(BarkMessageSendDto messageSendDto) {
        BarkMessage barkMessage = mapBarkMessageMapper.fromSendDto(messageSendDto);
        barkMessageService.save(barkMessage);

        BarkMessageSendBo sendBo = mapBarkMessageMapper.sendDtoToSendBo(messageSendDto);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(sendBo);
        } catch (JsonProcessingException e) {
            throw new PersipaRuntimeException(BarkMessageExceptionEnum.JSON_SERIALIZE_EXCEPTION);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        BarkResultBo resultBo = restTemplate.postForObject(BarkApiConstant.BARK_URL_TEMPLATE,
                new HttpEntity<>(jsonString, headers), BarkResultBo.class, BarkApiConstant.PUSH);

        return barkMessageService.saveSendResult(resultBo, barkMessage.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean push(BarkMessageSendBaseBo sendBaseBo) {
        BarkMessage barkMessage = mapBarkMessageMapper.fromSendBseBo(sendBaseBo);
        barkMessageService.save(barkMessage);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(sendBaseBo);
        } catch (JsonProcessingException e) {
            throw new PersipaRuntimeException(BarkMessageExceptionEnum.JSON_SERIALIZE_EXCEPTION);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        BarkResultBo resultBo = restTemplate.postForObject(BarkApiConstant.BARK_URL_TEMPLATE,
                new HttpEntity<>(jsonString, headers), BarkResultBo.class, BarkApiConstant.PUSH);

        return barkMessageService.saveSendResult(resultBo, barkMessage.getId());
    }

}
