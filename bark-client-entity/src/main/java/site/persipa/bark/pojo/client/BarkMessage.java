package site.persipa.bark.pojo.client;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import site.persipa.bark.enums.BarkMessageLevelEnum;
import site.persipa.bark.enums.BarkSendStatusEnum;

import java.time.LocalDateTime;

@Data
@TableName("bark_message")
public class BarkMessage {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String title;

    private String body;

    @JsonIgnore
    private String category;

    private String deviceKey;

    private BarkMessageLevelEnum level;

    private Integer badge;

    private Integer automaticallyCopy;

    private String copy;

    private String sound;

    private String icon;

    private String messageGroup;

    private String isArchive;

    private String url;

    private BarkSendStatusEnum sendStatus;

    private String resultMessage;

    private LocalDateTime sendTime;

    private Boolean readReceipt;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Boolean deleted;

}
