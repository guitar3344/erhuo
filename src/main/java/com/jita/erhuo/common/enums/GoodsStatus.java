package com.jita.erhuo.common.enums;

/**
 * Created by guitar on 15/1/25.
 */
public enum GoodsStatus implements GenericEnum {
    VALID(1,"有效"),
    UNDER_FRAME(2,"下架"),
    SOLD_OUT(3,"已售出");

    private int code;
    private String name;

    private GoodsStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
