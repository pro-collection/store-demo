package com.store.system.enums;

import lombok.Getter;

@Getter
public enum Type implements Enums {
    Level1(1, "个人"),
    Level2(2, "工作室"),
    Level3(3, "小型公司"),
    Level4(4, "中型公司"),
    Level5(5, "大公司");

    private Integer code;
    private String message;

    private Type(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
