package com.pd.enums;

import lombok.Getter;

@Getter
public enum Status {

    DOWNLOADING("%"), DOWNLOADED("100%"), FAILED("0%");

    private final String value;

    Status(String value) {
        this.value = value;
    }

}
