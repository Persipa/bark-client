package site.persipa.bark.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import site.persipa.cloud.helper.enums.EnumFindHelper;

@Getter
@AllArgsConstructor
public enum BarkSendStatusEnum {


    UNSENT(10, "未发送"),

    PENDING_RETRY(11, "待重试"),

    SENDING(20, "发送中"),

    SENT(30, "已发送"),

    SEND_FAIL(99, "发送失败"),


    ;


    @EnumValue
    private final int code;

    @JsonValue
    private final String value;

    public final static EnumFindHelper<BarkSendStatusEnum, Integer> CODE_HELPER =
            new EnumFindHelper<>(BarkSendStatusEnum.class, BarkSendStatusEnum::getCode);
}
