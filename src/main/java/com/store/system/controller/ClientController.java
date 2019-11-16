package com.store.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.store.system.data.BaseResponse;
import com.store.system.entity.Client;
import com.store.system.service.ClientService;
import com.store.system.utils.JsonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("create")
    public BaseResponse create(HttpServletRequest request) {
        Client client;
        try {
            String requestString = JsonRequest.getPayload(request);
            client = JSONObject.parseObject(requestString, Client.class);
            clientService.insertClient(client);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.responseError(e.getMessage());
        }
        return BaseResponse.responseSuccess(null, "success");
    }
}
