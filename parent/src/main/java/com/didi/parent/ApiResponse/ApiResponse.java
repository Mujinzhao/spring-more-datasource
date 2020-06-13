package com.didi.parent.ApiResponse;/*
 * @Author zhangxinkun
 */

import com.didi.parent.Util.TraceId;
import lombok.Data;

/**
 * @ClassName ApiResponse
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/18  4:54 PM
 * @Version 1.0
 */
@Data
public class ApiResponse<T> {
    int code;
    String traceId;
    String msg;
    T data;

    public static final String OKMS = "success";

    public static final String ERROE = "error";

    public static <T> ApiResponse<T> success(T result){
        ApiResponse response = new ApiResponse();
        response.setCode(0);
        response.setMsg(OKMS);
        response.setData(result);
        response.setTraceId(TraceId.generateTraceId());
        return response;
    }

    public static <T> ApiResponse<T> error(T result){
        if(result instanceof MoreExceprionCode){
            ApiResponse response = new ApiResponse(((MoreExceprionCode) result).getCode(),((MoreExceprionCode) result).getName(),result);
            return response;
        }
        ApiResponse response = new ApiResponse();
        response.setCode(0);
        response.setMsg(ERROE);
        response.setData(result);
        return response;
    }

    public ApiResponse(){
        this(0,"",null);
    }

    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
