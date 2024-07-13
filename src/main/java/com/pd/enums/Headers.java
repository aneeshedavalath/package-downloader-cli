package com.pd.enums;

import lombok.Getter;

@Getter
public enum Headers {

    NAME("NAME"),
    VERSION("VERSION"),
    SIZE("SIZE (MB)"),
    APPLICATION("APPLICATION"),
    STATUS("STATUS"),
    PERCENTAGE("PERCENTAGE");

    private final String value;

    Headers(String value) {
        this.value = value;
    }

}
