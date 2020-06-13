package com.didi.parent.ApiResponse;

/**
 * @ClassName MoreExceprionCode
 * @Author zhangxinkun
 * @Date 2020/1/19  3:29 PM
 * @Version 1.0
 */
public enum  MoreExceprionCode {
    PARAMS_ERROR("参数错误",10010)
    ;
    private String name;
    int code;

    MoreExceprionCode(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
