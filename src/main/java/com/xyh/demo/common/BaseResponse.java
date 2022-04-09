package com.xyh.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Slf4j
public class BaseResponse<T> {

    private static final int CODE_SUCCESS = 0;
    private static final int CODE_FAIL = -1;

    private int code;
    private String errorCode;
    private String errorMsg;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(CODE_SUCCESS);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    public static <T> BaseResponse<T> fail(String errorCode, String errorMsg, T data) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(CODE_FAIL);
        baseResponse.setErrorCode(errorCode);
        baseResponse.setErrorMsg(errorMsg);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static <T> BaseResponse<T> fail(String errorCode, String errorMsg) {
        return fail(errorCode, errorMsg, null);
    }

}
