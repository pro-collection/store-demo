package com.store.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.store.system.data.BaseResponse;
import com.store.system.entity.User;
import com.store.system.service.UserService;
import com.store.system.utils.JsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    public BaseResponse create(HttpServletRequest request) {
        User user = null;
        try {
            String requestString = JsonRequest.getPayload(request);
            user = JSONObject.parseObject(requestString, User.class);
            userService.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.responseError(e.getMessage());
        }
        return BaseResponse.responseSuccess(null, "success");
    }
}
