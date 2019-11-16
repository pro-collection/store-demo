package com.store.system.exception;

import com.store.system.data.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class AuthExceptionHandler {

    // 异常拦截
    @ExceptionHandler(value = AuthorizeException.class)
    public BaseResponse handlerAuthorizeException() {
        return BaseResponse.responseError("没有权限");
    }
}
