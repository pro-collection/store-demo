package com.store.system.mapper;

import com.store.system.entity.Client;
import org.springframework.stereotype.Component;

@Component(value = "clientMapper")
public interface ClientMapper {
    void insertClient(Client client);
}
