package com.pd.enums;

import lombok.Getter;

@Getter
public enum Version {

    JDK_21_LTS("21.0.3+9-LTS"), MONGO_DB_SERVER_7("7.0.12"), POSTMAN_11("11.3.0");

    private final String value;

    Version(String value) {
        this.value = value;
    }

}
