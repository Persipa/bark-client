package site.persipa.bark.pojo.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author persipa
 */
@Data
public class BarkMessageSendSimpleDto implements Serializable {

    private String title;

    private String body;

    private String deviceId;

}
