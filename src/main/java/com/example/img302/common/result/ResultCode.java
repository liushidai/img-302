package com.example.img302.common.result;

import lombok.Getter;

/**
 * @author liushidai
 */

@Getter
public enum ResultCode {
    /**
     * 业务请求成功统一编码
     */
    SUCCESS(200, "success"),
    /**
     * 业务请求失败统一编码
     */
    FAILED(400, "操作失败"),
    /**
     * 请求非法统一编码
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 权限不足统一编码
     */
    FORBIDDEN(403, "没有相关权限"),
    /**
     * 资源不存在统一编码
     */
    NOT_FOUND(404, "请求资源不存在"),
    /**
     * 业务服务异常统一编码
     */
    ERROR(500, "服务发生异常");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
