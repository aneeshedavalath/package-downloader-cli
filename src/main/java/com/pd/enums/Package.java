package com.pd.enums;

import lombok.Getter;

@Getter
public enum Package {

    TEMURIN_JDK("Temurin JDK"), MONGO_DB_COMMUNITY_SERVER("MongoDB Community Server"), POSTMAN("Postman");

    private final String value;

    Package(String value) {
        this.value = value;
    }

}
