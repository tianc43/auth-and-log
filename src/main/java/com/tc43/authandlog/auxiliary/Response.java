package com.tc43.authandlog.auxiliary;

import java.util.LinkedList;

/**
 * 统一接口返回值
 * return Response.ok();
 */
public class Response {

    private int code;
    private long total;
    private Object msg;

    private Object data;

    private Response(int code, Object msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Response(int code, Object msg, Object data, long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

    private Response(int code, Object msg) {
        this(code, msg, null);
    }

    private Response() {

    }

    public static Response unAuthenticated(String msg) {
        return ok(Status.unAuthenticated, msg);
    }

    public static Response fail() {
        return ok(Status.fail);
    }

    public static Response fail(String msg) {
        return ok(Status.fail, msg);
    }

    public static Response ok() {
        return new Response(Status.ok.getCode(), Status.ok.getMsg());
    }

    public static Response ok(Object data) {
        return ok(Status.ok, data);
    }

    public static Response ok(Status status) {
        return new Response(status.getCode(), status.getMsg());
    }

    public static Response ok(Status status, String msg) {
        return new Response(status.getCode(), msg);
    }

    public static Response ok(Status status, Object data) {
        return new Response(status.getCode(), status.getMsg(), data);
    }

    public static Response ok(Status status, Object data, long total) {
        return new Response(status.getCode(), status.getMsg(), data, total);
    }

    public Object getData() {
        return data != null ? data : new LinkedList<>();
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
