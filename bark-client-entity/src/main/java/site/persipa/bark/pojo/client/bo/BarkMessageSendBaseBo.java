package site.persipa.bark.pojo.client.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author persipa
 */
@Data
public class BarkMessageSendBaseBo {

    private String title;

    private String body;

    @JsonProperty(value = "device_key", required = true)
    private String deviceKey;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String group;

}
