package site.persipa.bark.dubbo.provider.client.impl;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import site.persipa.bark.client.manager.BarkMessageManager;
import site.persipa.bark.client.service.BarkDeviceService;
import site.persipa.bark.dubbo.provider.client.BarkMessageApi;
import site.persipa.bark.mapstruct.MapBarkMessageMapper;
import site.persipa.bark.pojo.client.BarkDevice;
import site.persipa.bark.pojo.client.bo.BarkMessageSendBaseBo;
import site.persipa.bark.pojo.client.dto.BarkMessageSendSimpleDto;

/**
 * @author persipa
 */
@DubboService
@RequiredArgsConstructor
public class BarkMessageApiImpl implements BarkMessageApi {

    private final BarkMessageManager barkMessageManager;

    private final BarkDeviceService barkDeviceService;

    private final MapBarkMessageMapper mapBarkMessageMapper;

    @Override
    public Boolean push(BarkMessageSendSimpleDto sendSimpleDto){
        BarkDevice barkDevice = barkDeviceService.getById(sendSimpleDto.getDeviceId());
        if (barkDevice == null) {
            return false;
        }

        BarkMessageSendBaseBo sendBaseBo = mapBarkMessageMapper.sendDtoToSendBaseBo(sendSimpleDto);
        sendBaseBo.setDeviceKey(barkDevice.getDeviceKey());

        return barkMessageManager.push(sendBaseBo);
    }

}
