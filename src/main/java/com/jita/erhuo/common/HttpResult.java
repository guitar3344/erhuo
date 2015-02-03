package com.jita.erhuo.common;

/**
 * Created by guitar on 15/2/2.
 */
public class HttpResult<T> {

    private final static String OK = "success";
    private final static String ERROR = "failure";

    private String status;
    private String msg;
    private T value;

    private HttpResult(String status,String msg,T value){
        this.status = status;
        this.msg = msg;
        this.value = value;
    }

    public static <T> HttpResult OK(T value){
        return new HttpResult(OK,"",value);
    }

    public static <T> HttpResult ERROR(String msg,T value){
        return new HttpResult(ERROR,msg,value);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
