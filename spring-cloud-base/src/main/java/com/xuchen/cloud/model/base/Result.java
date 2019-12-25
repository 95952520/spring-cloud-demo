package com.xuchen.cloud.model.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private boolean success;

    private int code;

    private String msg;

    private int count;

    private T data;


    public static <T> Result success(T data) {
        return new Result(data);
    }

    public static <T> Result success(int count, T data) {
        return new Result(count,data);
    }

    public static Result success() {
        return new Result(null);
    }

    public static Result fail(String msg) {
        return new Result(false, 1, msg, null);
    }

    public static Result fail() {
        return new Result(false, 1, "操作失败", null);
    }

    public Result(){

    }


    private Result(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(boolean success, int code) {
        this.success = success;
        this.code = code;
    }

    private Result(T data) {
        this.success = true;
        this.code = 0;
        this.data = data;
        this.msg = "操作成功";
    }

    private Result(int count, T data) {
        this.code = 0;
        this.success = true;
        this.count = count;
        this.data = data;
        this.msg = "操作成功";
    }

}
