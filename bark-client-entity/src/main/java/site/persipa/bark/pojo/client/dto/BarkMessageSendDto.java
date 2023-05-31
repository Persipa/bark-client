package site.persipa.bark.pojo.client.dto;

import lombok.Data;
import site.persipa.bark.enums.BarkMessageLevelEnum;

/**
 * @author persipa
 */
@Data
public class BarkMessageSendDto {

    private String title;

    private String body;

    private String deviceKey;

    private BarkMessageLevelEnum level;

    private Integer badge;

    private Integer automaticallyCopy;

    private String copy;

    private String sound;

    private String icon;

    private String group;

    private String isArchive;

    private String url;
}
