package site.persipa.bark.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import site.persipa.bark.pojo.client.BarkMessage;
import site.persipa.bark.pojo.client.bo.BarkMessageSendBaseBo;
import site.persipa.bark.pojo.client.bo.BarkMessageSendBo;
import site.persipa.bark.pojo.client.dto.BarkMessageSendDto;
import site.persipa.bark.pojo.client.dto.BarkMessageSendSimpleDto;

/**
 * @author persipa
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapBarkMessageMapper {

    @Mapping(target = "category", ignore = true)
    BarkMessageSendBo sendDtoToSendBo(BarkMessageSendDto messageSendDto);

    @Mapping(target = "deviceKey", ignore = true)
    BarkMessageSendBaseBo sendDtoToSendBaseBo(BarkMessageSendSimpleDto sendSimpleDto);

    @Mappings({
            @Mapping(target = "messageGroup", source = "group")
    })
    BarkMessage fromSendDto(BarkMessageSendDto messageSendDto);

    BarkMessage fromSendBseBo(BarkMessageSendBaseBo sendBaseBo);
}
