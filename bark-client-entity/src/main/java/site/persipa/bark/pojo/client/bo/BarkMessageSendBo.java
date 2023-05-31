package site.persipa.bark.pojo.client.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import site.persipa.bark.enums.BarkMessageLevelEnum;

/**
 * @author persipa
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BarkMessageSendBo extends BarkMessageSendBaseBo{

    @JsonIgnore
    private String category;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BarkMessageLevelEnum level;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer badge;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer automaticallyCopy;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String copy;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sound;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String icon;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String group;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String isArchive;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String url;

}
