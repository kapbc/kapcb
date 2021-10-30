package com.kapcb.ccc.common.result;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <a>Title: Result </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:42
 */
@Data
public class CommonResult<T> {

    private int code;

    private String msg;

    private T date;

    private LocalDateTime timeStamp;

    protected CommonResult() {
        timeStamp = LocalDateTime.now();
    }

    protected CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.date = data;
        this.timeStamp = LocalDateTime.now();
    }

    protected CommonResult(IErrorCode errorCode) {
        this.code = errorCode.code();
        this.msg = errorCode.msg();
        this.date = null;
        this.timeStamp = LocalDateTime.now();
    }

    protected CommonResult(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.msg = resultCode.msg();
        this.date = data;
        this.timeStamp = LocalDateTime.now();
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS, data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.code(), message, data);
    }

    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.FAILED);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.code(), message, null);
    }

    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode);
    }

    public static <T> CommonResult<T> failed(Throwable throwable) {
        return new CommonResult<T>(ResultCode.FAILED.code(), throwable.getMessage(), null);
    }

    public static <T> CommonResult<T> failed(IErrorCode errorCode, Throwable throwable) {
        return new CommonResult<T>(errorCode.code(), throwable.getMessage(), null);
    }

    public static <T> CommonResult<T> failed(IErrorCode errorCode, Throwable throwable, T data) {
        return new CommonResult<T>(errorCode.code(), throwable.getMessage(), data);
    }

    public static <T> CommonResult<T> validateFailed() {
        return new CommonResult<T>(ResultCode.VALIDATE_PARAM_FAIL);
    }

    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_PARAM_FAIL.code(), message, null);
    }

    public static <T> CommonResult<T> unauthorized() {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED);
    }

    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED, data);
    }

    public static <T> CommonResult<T> forbidden() {
        return new CommonResult<T>(ResultCode.FORBIDDEN);
    }

    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN, data);
    }
}
