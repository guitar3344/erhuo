package com.jita.erhuo.common.enums;

/**
 * Created by guitar on 15/1/17.
 */
public enum UserStatus implements GenericEnum {

    ONLINE(1, "online"),
    OFFLINE(2, "offline"),
    NOT_VALID(10, "notValid");

    private int code;
    private String name;

    private UserStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static UserStatus valueOfEnum(int code) {
        UserStatus[] iss = values();
        for (UserStatus cs : iss) {
            if (cs.getCode() == code) {
                return cs;
            }
        }
        return null;
    }
}
