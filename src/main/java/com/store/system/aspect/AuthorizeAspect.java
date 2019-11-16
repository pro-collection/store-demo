package com.store.system.aspect;

import com.store.system.constant.CookieConstant;
import com.store.system.exception.AuthorizeException;
import com.store.system.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class AuthorizeAspect {
    @Pointcut("execution(public * com.store.system.controller.*.*(..))" +
            "&& !execution(public * com.store.system.controller.UserController.*(..))")
    public void auth() {
    }

    @Before("auth()")
    public void doAuth() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new AuthorizeException();
        }
    }
}