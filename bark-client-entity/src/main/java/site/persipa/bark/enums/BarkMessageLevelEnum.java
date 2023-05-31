package site.persipa.bark.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BarkMessageLevelEnum {
    /**
     * 不设置时的默认值，系统会立即亮屏显示通知
     */
    ACTIVE("active"),

    /**
     * 时效性通知，可在专注状态下显示通知。
     */
    TIME_SENSITIVE("timeSensitive"),

    /**
     * 仅将通知添加到通知列表，不会亮屏提醒
     */
    PASSIVE("passive"),

    ;

    @JsonValue
    @EnumValue
    private final String value;
}
