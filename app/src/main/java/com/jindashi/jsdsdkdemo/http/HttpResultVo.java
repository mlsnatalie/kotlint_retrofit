package com.jindashi.jsdsdkdemo.http;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 自定义标准接口json返回格式类
 * 该类需要根据每个公司具体的接口规范文档而定
 *
 * @author zhang.zheng
 * @version 2017-11-22
 */
public class HttpResultVo<T> implements Serializable {

    // 返回码
    @SerializedName(value = "code", alternate = "Code")
    private int code;
    // 提示信息
    @SerializedName(value = "message", alternate = "Msg")
    private String message;
    // 数据
    @SerializedName(value = "result", alternate = {"Data", "data"})
    private T result;

    //private T data; // 2.5.2新增  数据

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getData() {
        //return data;
        return result;
    }

    /*public void setData(T data) {
        this.data = data;
    }*/
}
