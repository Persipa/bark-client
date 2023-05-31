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
public enum BarkDeviceExceptionEnum implements PersipaExceptionDef {

    DEVICE_ALREADY_EXIST(999, "设备已存在", ExceptionLevelEnum.WARNING),


    DEVICE_NOT_FOUND(999, "设备不存在", ExceptionLevelEnum.EXCEPTION),


    ;

    private final int code;

    private final String msg;

    private final ExceptionLevelEnum level;

}