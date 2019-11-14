package com.store.system.service.impl;

import com.store.system.entity.Client;
import com.store.system.mapper.ClientMapper;
import com.store.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public void insertClient(Client client) {
        clientMapper.insertClient(client);
    }
}
