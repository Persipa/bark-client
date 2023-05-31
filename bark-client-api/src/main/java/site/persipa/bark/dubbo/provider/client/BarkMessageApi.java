package site.persipa.bark.dubbo.provider.client;

import site.persipa.bark.pojo.client.dto.BarkMessageSendSimpleDto;

/**
 * @author persipa
 */
public interface BarkMessageApi {

    Boolean push(BarkMessageSendSimpleDto sendSimpleDto);

}
