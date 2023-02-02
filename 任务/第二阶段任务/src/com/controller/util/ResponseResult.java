package com.controller.util;

/**
 * 封装服务传输数据的工具<br/>
 * 用于将服务端的响应返回给客户端。
 * <p/>
 * 响应所反馈的数据可包括传输对象数据DTO、业务逻辑反馈...
 * @author silent_child
 * @version 1.0
 **/

public class ResponseResult<T> {
    private T data;
    private String comment;
    private Integer statusCode;

    public ResponseResult() {
    }

    public ResponseResult(T data, String comment, Integer statusCode) {
        this.data = data;
        this.comment = comment;
        this.statusCode = statusCode;
    }

    /**
     * 用于传输对象数据给前端。<br/>
     * 作为一个工具，故设为static随时调用。
     * @param data 对应的DTO数据
     * @return ResponseResult<E> 返回包含data数据，以及其他附带信息。
     * @param <E> 对应DTO的数据类型
     */
    public static <E> ResponseResult<E> operateData(E data) {
        return new ResponseResult<>(data, null, code.Success);
    }

    /**
     * 用于反馈业务逻辑给前端，如是否成功操作...
     * @param flag 是否成功的标志
     * @return ResponseResult<E> 返回状态、备注...等信息。
     * @param <E> 根据调用者决定类型
     */
    public static <E> ResponseResult<E> operateOthers(boolean flag) {
        return new ResponseResult<>(null, null, flag ? code.Success : code.Fail);
    }

    static class code{
        private static final Integer Success = 1;
        private static final Integer Fail = 0;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
