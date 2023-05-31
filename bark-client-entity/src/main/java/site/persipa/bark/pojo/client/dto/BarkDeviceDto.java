package site.persipa.bark.pojo.client.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author persipa
 */
@Data
public class BarkDeviceDto {

    @NotBlank
    private String deviceName;

    @NotBlank
    private String deviceKey;

    private String remark;

}
