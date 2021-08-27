package com.tc43.authandlog.auxiliary;

/**
 * 统一接口返回值状态
 * return Response.ok(Status.ok);
 */
public enum Status {

    ok(1, "ok"),
    fail(0, "fail"),
    unAuthenticated(405, "unAuthenticated");

    private int code;

    private String msg;

    Status(int code, String msg) {
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
}
