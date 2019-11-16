package com.store.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.store.system.constant.CookieConstant;
import com.store.system.data.BaseResponse;
import com.store.system.entity.User;
import com.store.system.service.UserService;
import com.store.system.utils.CookieUtil;
import com.store.system.utils.JsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    public BaseResponse create(HttpServletRequest request) {
        try {
            User user = JSONObject.parseObject(JsonRequest.getPayload(request), User.class);

            User userInfo = userService.getUser(user.getName(), user.getPassword());
            if (userInfo != null) return BaseResponse.responseError("该用户已经注册过了");
            userService.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.responseError(e.getMessage());
        }
        return BaseResponse.responseSuccess(null, "success");
    }

    @PostMapping("login")
    public BaseResponse login(HttpServletRequest request, HttpServletResponse response) {
        User user = JSONObject.parseObject(JsonRequest.getPayload(request), User.class);

        User userInfo = userService.getUser(user.getName(), user.getPassword());
        if (userInfo == null) {
            return BaseResponse.responseError("不存在该用户");
        }

        // 设置token 到 cookie
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.EXPIRE;
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return BaseResponse.responseSuccess(userInfo, "登录成功");
    }

    @GetMapping("logout")
    public BaseResponse logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie != null) {
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
            return BaseResponse.responseSuccess(null, "退出登录");
        } else {
            return BaseResponse.responseError("当前是为登录状态");
        }
    }

    @PostMapping("get")
    public BaseResponse getUserInfo(HttpServletRequest request) {
        User user = JSONObject.parseObject(JsonRequest.getPayload(request), User.class);

        User userInfo = userService.getUser(user.getName(), user.getPassword());
        return BaseResponse.responseSuccess(userInfo, "查询用户信息成功");
    }

    @PostMapping("update")
    public BaseResponse update(HttpServletRequest request) {
        User user = JSONObject.parseObject(JsonRequest.getPayload(request), User.class);

        if (user.getName() == null | user.getPassword() == null) {
            return BaseResponse.responseError("用户名和密码必填");
        }

        User userInfo = userService.getUser(user.getName(), user.getPassword());

        if (userInfo != null) {
            return BaseResponse.responseError("已存在该用户");
        }

        userService.update(user);
        return BaseResponse.responseSuccess(user, "更新成功");
    }

    @PostMapping("delete")
    public BaseResponse delete(HttpServletRequest request) {
        User user = JSONObject.parseObject(JsonRequest.getPayload(request), User.class);

        if (user.getId() == 0) {
            return BaseResponse.responseError("填写用户ID");
        }

        User findUser = userService.getUserById(user.getId());
        if(findUser==null) {
            return BaseResponse.responseError("该用户不存在");
        }

        userService.delete(user.getId());
        return BaseResponse.responseSuccess(null, "删除用户成功");
    }
}
