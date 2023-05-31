package site.persipa.bark.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import site.persipa.cloud.helper.enums.EnumFindHelper;

@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS(200, "success", BarkSendStatusEnum.SENT),

    REFUSE(403, "refuse",BarkSendStatusEnum.SEND_FAIL),

    ERROR(500, "error", BarkSendStatusEnum.SEND_FAIL),

    ;

    private final int code;

    private final String message;

    private final BarkSendStatusEnum sendStatus;

    public static final EnumFindHelper<ResultCodeEnum, Integer> CODE_HELPER =
            new EnumFindHelper<>(ResultCodeEnum.class, ResultCodeEnum::getCode);
}
