package site.persipa.bark.enums.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import site.persipa.cloud.enums.ExceptionLevelEnum;
import site.persipa.cloud.enums.PersipaExceptionDef;

/**
 * @author persipa
 */
@Getter
@AllArgsConstructor
public enum BarkMessageExceptionEnum implements PersipaExceptionDef {

    // region 发送异常

    /**
     * JSON 序列化异常
     */
    JSON_SERIALIZE_EXCEPTION(999, "JSON 序列化异常", ExceptionLevelEnum.ERROR),

    MESSAGE_SEND_FAILED(999, "设备消息推送失败", ExceptionLevelEnum.EXCEPTION),

    ;

    private final int code;

    private final String msg;

    private final ExceptionLevelEnum level;

}