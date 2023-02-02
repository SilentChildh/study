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

    public ResponseResult(T data, String comment, Integer statusCode) {
        this.data = data;
        this.comment = comment;
        this.statusCode = statusCode;
    }

    /**
     * 用于响应客户端查询用户数据的请求
     * @param data 对应的DTO数据
     * @return ResponseResult 返回包含data数据，以及其他附带信息。
     * @param <E> 对应DTO的数据类型
     */
    public <E> ResponseResult<E> operateData(E data) {
        return new ResponseResult<>(data, null, code.Success);
    }


    public <E> ResponseResult<E> operateOthers(boolean success) {
        return new ResponseResult<>(null, null, success ? code.Success : code.Fail);
    }

    static class code{
        private static final Integer Success = 1;
        private static final Integer Fail = 0;
    }
}
