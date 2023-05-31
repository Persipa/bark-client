package site.persipa.bark.client.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.persipa.bark.pojo.client.BarkMessage;
import site.persipa.bark.pojo.client.bo.BarkResultBo;

/**
 * @author persipa
 */
public interface BarkMessageService extends IService<BarkMessage> {

    boolean saveSendResult(BarkResultBo resultBo, String id);
}
