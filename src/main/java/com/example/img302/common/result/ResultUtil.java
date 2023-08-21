package com.example.img302.common.result;


/**
 * @author liushidai
 */
public class ResultUtil<T> {

    private final Result<T> result;

    public ResultUtil() {
        result = new Result<>();
        result.setSuccess(true);
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setCode(ResultCode.SUCCESS.getCode());
    }

    /**
     * 成功返回结果
     */
    public static <T> Result<T> success() {
        return new ResultUtil<T>().setSuccessMsg();
    }

    /**
     * 成功返回结果
     *
     * @param msg 提示信息
     */
    public static <T> Result<T> success(String msg) {
        return new ResultUtil<T>().setSuccessMsg(msg);
    }

    /**
     * 成功返回结果
     *
     * @param t 返回的数据
     */
    public static <T> Result<T> data(T t) {
        return new ResultUtil<T>().setData(t);
    }

    /**
     * 成功返回结果
     *
     * @param t   返回的数据
     * @param msg 提示信息
     */
    public static <T> Result<T> data(T t, String msg) {
        return new ResultUtil<T>().setData(t, msg);
    }

    /**
     * 失败返回结果
     */
    public static <T> Result<T> failed() {
        return new ResultUtil<T>().setFailedMsg();
    }

    /**
     * 失败返回结果
     *
     * @param message 错误信息
     */
    public static <T> Result<T> failed(String message) {
        return new ResultUtil<T>().setFailedMsg(message);
    }

    /**
     * 成功返回结果
     *
     * @param t       返回的数据
     * @param message 错误信息
     */
    public static <T> Result<T> failed(T t, String message) {
        return new ResultUtil<T>().setFailedMsg(t, message);
    }

    /**
     * 失败返回结果
     *
     * @param code    错误码
     * @param message 提示信息
     */
    public static <T> Result<T> failed(ResultCode code, String message) {
        return new ResultUtil<T>().setFailedMsg(code, message);
    }

    /**
     * 业务服务异常返回结果
     */
    public static <T> Result<T> error() {
        return new ResultUtil<T>().setErrorMsg();
    }

    /**
     * 业务服务异常返回结果
     *
     * @param msg 提示信息
     */
    public static <T> Result<T> error(String msg) {
        return new ResultUtil<T>().setErrorMsg(msg);
    }

    /**
     * 业务服务异常返回结果
     *
     * @param code 错误码
     * @param msg  提示信息
     */
    public static <T> Result<T> error(ResultCode code, String msg) {
        return new ResultUtil<T>().setErrorMsg(code, msg);
    }

    /**
     * 业务服务异常返回结果
     *
     * @param code 错误码
     * @param msg  提示信息
     */
    public static <T> Result<T> error(Integer code, String msg) {
        return new ResultUtil<T>().setErrorMsg(code, msg);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized() {
        return new ResultUtil<T>().setUnauthorizedMsg();
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden() {
        return new ResultUtil<T>().setForbiddenMsg();
    }


    public Result<T> setSuccessMsg() {
        this.result.setSuccess(true);
        this.result.setMessage(ResultCode.SUCCESS.getMessage());
        this.result.setCode(ResultCode.SUCCESS.getCode());
        this.result.setResult(null);
        return this.result;
    }

    public Result<T> setSuccessMsg(String msg) {
        this.result.setSuccess(true);
        this.result.setMessage(msg);
        this.result.setCode(ResultCode.SUCCESS.getCode());
        this.result.setResult(null);
        return this.result;
    }

    public Result<T> setData(T t) {
        this.result.setSuccess(true);
        this.result.setResult(t);
        this.result.setCode(ResultCode.SUCCESS.getCode());
        this.result.setMessage(ResultCode.SUCCESS.getMessage());
        return this.result;
    }

    public Result<T> setData(T t, String msg) {
        this.result.setSuccess(true);
        this.result.setResult(t);
        this.result.setCode(ResultCode.SUCCESS.getCode());
        this.result.setMessage(msg);
        return this.result;
    }

    public Result<T> setFailedMsg() {
        this.result.setSuccess(false);
        this.result.setMessage(ResultCode.FAILED.getMessage());
        this.result.setCode(ResultCode.FAILED.getCode());
        return this.result;
    }

    public Result<T> setFailedMsg(String msg) {
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(ResultCode.FAILED.getCode());
        return this.result;
    }

    public Result<T> setFailedMsg(T t, String msg) {
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(ResultCode.FAILED.getCode());
        this.result.setResult(t);
        return this.result;
    }


    public Result<T> setFailedMsg(ResultCode code, String msg) {
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code.getCode());
        return this.result;
    }

    public Result<T> setUnauthorizedMsg() {
        this.result.setSuccess(false);
        this.result.setMessage(ResultCode.UNAUTHORIZED.getMessage());
        this.result.setCode(ResultCode.UNAUTHORIZED.getCode());
        return this.result;
    }

    public Result<T> setForbiddenMsg() {
        this.result.setSuccess(false);
        this.result.setMessage(ResultCode.FORBIDDEN.getMessage());
        this.result.setCode(ResultCode.FORBIDDEN.getCode());
        return this.result;
    }

    public Result<T> setErrorMsg() {
        this.result.setSuccess(false);
        this.result.setMessage(ResultCode.ERROR.getMessage());
        this.result.setCode(ResultCode.ERROR.getCode());
        return this.result;
    }

    public Result<T> setErrorMsg(String msg) {
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(ResultCode.ERROR.getCode());
        return this.result;
    }

    public Result<T> setErrorMsg(ResultCode code, String msg) {
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code.getCode());
        return this.result;
    }

    public Result<T> setErrorMsg(Integer code, String msg) {
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code);
        return this.result;
    }
}
