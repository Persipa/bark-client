package site.persipa.bark.client.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.persipa.bark.client.mapper.BarkMessageMapper;
import site.persipa.bark.client.service.BarkMessageService;
import site.persipa.bark.enums.BarkSendStatusEnum;
import site.persipa.bark.enums.ResultCodeEnum;
import site.persipa.bark.pojo.client.BarkMessage;
import site.persipa.bark.pojo.client.bo.BarkResultBo;

import java.time.LocalDateTime;

/**
 * @author persipa
 */
@Service
public class BarkMessageServiceImpl extends ServiceImpl<BarkMessageMapper, BarkMessage>
        implements BarkMessageService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveSendResult(BarkResultBo resultBo, String id) {

        ResultCodeEnum resultCodeEnum = ResultCodeEnum.CODE_HELPER.find(resultBo.getCode(), null);
        BarkSendStatusEnum sendStatus = null;
        if (resultCodeEnum != null) {
            sendStatus = resultCodeEnum.getSendStatus();
        }
        LocalDateTime sendTime = resultBo.getTimestamp();
        if (sendStatus == null || BarkSendStatusEnum.SEND_FAIL.equals(sendStatus)) {
            sendTime = null;
        }

        return this.update(Wrappers.lambdaUpdate(BarkMessage.class)
                .set(sendStatus != null, BarkMessage::getSendStatus, sendStatus)
                .set(sendTime != null, BarkMessage::getSendTime, sendTime)
                .eq(BarkMessage::getId, id));

    }
}
