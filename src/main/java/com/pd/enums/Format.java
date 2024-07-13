package com.pd.enums;

import lombok.Getter;

@Getter
public enum Format {

    MSI(".msi"), EXE(".exe");

    private final String value;

    Format(String value) {
        this.value = value;
    }

}
