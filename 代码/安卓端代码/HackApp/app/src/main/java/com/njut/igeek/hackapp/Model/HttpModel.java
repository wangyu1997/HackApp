package com.njut.igeek.hackapp.Model;


/**
 * Created by wangyu on 06/05/2017.
 */

public class HttpModel<T> {

    /**
     * code : 200
     * data :
     * error :
     */

    private int code;
    private T data;
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
