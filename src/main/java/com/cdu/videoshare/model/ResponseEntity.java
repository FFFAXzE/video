package com.cdu.videoshare.model;


import lombok.Data;

import java.util.List;

@Data
public class ResponseEntity<T> {
    private int code;   //响应码
    private String message; //消息
    private T data; //数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
