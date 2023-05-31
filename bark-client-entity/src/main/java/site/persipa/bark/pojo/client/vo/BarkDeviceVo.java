package site.persipa.bark.pojo.client.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author persipa
 */
@Data
public class BarkDeviceVo implements Serializable {

    private String id;

    private String deviceName;

    private String remark;
}