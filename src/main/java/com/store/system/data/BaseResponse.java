package com.store.system.data;


import lombok.Data;

@Data
public class BaseResponse {
    private String message;
    private boolean success;
    private Object data;

    public static BaseResponse responseError(String message) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    public static BaseResponse responseSuccess(Object data, String message) {
        BaseResponse response = new BaseResponse();
        response.setData(data);
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }
}
