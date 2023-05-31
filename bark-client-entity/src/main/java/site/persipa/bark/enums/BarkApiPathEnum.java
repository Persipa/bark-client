package site.persipa.bark.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BarkApiPathEnum {

    /**
     * 推送
     */
    PUSH("push"),

    /**
     * 健康检查
     */
    HEALTHY_CHECK("healthz"),

    /**
     * 获取信息
     */
    INFO("info"),

    /**
     * 检查连通性
     */
    PING("ping"),

    ;

    private final String path;
}
