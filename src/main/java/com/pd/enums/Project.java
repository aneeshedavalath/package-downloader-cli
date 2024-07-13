package com.pd.enums;

import lombok.Getter;

@Getter
public enum Project {

    MRY("Mercury"), VNS("Venus"), MRS("Mars");

    private final String value;

    Project(String value) {
        this.value = value;
    }
}
