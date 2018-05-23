package com.malasong.server.Model;

import lombok.Data;

@Data
public class JsonResult<T> {
    public final static Integer OK = 200;
    public final static Integer ERROR = 500;

    private Integer code;
    private String message;
    private T data;

    public JsonResult() {
        code = OK;
    }

    public JsonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
