package site.persipa.bark.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import site.persipa.bark.pojo.client.BarkDevice;
import site.persipa.bark.pojo.client.dto.BarkDeviceDto;
import site.persipa.bark.pojo.client.vo.BarkDeviceVo;

/**
 * @author persipa
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapBarkDeviceMapper {

    @Mappings({
            @Mapping(target = "deleted", ignore = true),
            @Mapping(target = "enabled", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    BarkDevice fromDto(BarkDeviceDto dto);

    BarkDeviceVo toVo(BarkDevice entity);
}
