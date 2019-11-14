package com.store.system.mapper;

import org.springframework.stereotype.Component;

@Component(value = "clientMapper")
public interface ClientMapper {
    void insertClient();
}
