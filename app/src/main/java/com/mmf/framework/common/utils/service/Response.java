package com.mmf.framework.common.utils.service;
import com.mmf.framework.common.utils.Constant;

public class Response<T> {

    public String error_code;
    public String reason;
    public T result;


    public boolean isSuccess() {
        return error_code.equals(Constant.OK);
    }
}
