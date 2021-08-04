package com.param.check.entity;

import org.springframework.http.HttpStatus;

public class Resp<T> {
    /**
     * @see org.springframework.http.HttpStatus
     */
    private int code ;

    private String msg ;

    private T data ;

    public static <T> Resp<T> ok (T data) {
        Resp<T> result = new Resp<>(HttpStatus.OK);
        result.setData(data);
        return result ;
    }

    public Resp (HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.msg = httpStatus.getReasonPhrase();
    }

    public Resp(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Resp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
