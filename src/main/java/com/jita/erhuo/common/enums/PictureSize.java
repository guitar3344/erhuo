package com.jita.erhuo.common.enums;

/**
 * Created by guitar on 15/2/3.
 */
public enum PictureSize{
    S("s",100,100),
    M("m",200,200),
    L("l",400,400);

    private String code;
    private int width;
    private int height;

    private PictureSize(String code, int width, int height) {
        this.code = code;
        this.width = width;
        this.height = height;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
