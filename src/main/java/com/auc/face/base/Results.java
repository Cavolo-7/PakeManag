package com.auc.face.base;


import com.auc.face.enums.ErrorCodeEnum;

/**
 * @author Jerry
 */
public class Results {

    public static <T> com.auc.face.base.Result<T> newSuccessResult(T data) {
        return new com.auc.face.base.Result(data, "success", true,0);
    }

    public static <T> com.auc.face.base.Result<T> newFailedResult(String message) {
        return new com.auc.face.base.Result(null, message, false,-10000);
    }

    public static <T> com.auc.face.base.Result<T> newFailedResult(Integer code, String message) {
        return new com.auc.face.base.Result(null, message, false, code);
    }

    public static <T> com.auc.face.base.Result<T> newFailedResult(ErrorCodeEnum errorCodeEnum) {
        return new com.auc.face.base.Result(null, errorCodeEnum.getDescription(), false, errorCodeEnum.getCode());
    }

    public static <T> com.auc.face.base.Result<T> newResult(T data, String message, boolean success, Integer code) {
        com.auc.face.base.Result result = new com.auc.face.base.Result();
        result.setData(data);
        result.setCode(code);
        result.setSuccess(success);
        result.setMessage(message);
        return result;
    }

}
