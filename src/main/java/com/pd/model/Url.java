package com.pd.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Url {

    private Url() {
    }

    private static Map<String, Map<String, String>> urls = new HashMap<>(Map.of("Temurin JDK", Map.of("21.0.3+9-LTS",
                    "https://github.com/adoptium/temurin21-binaries/releases/download/jdk-21.0.3%2B9/OpenJDK21U-jdk_x64_windows_hotspot_21.0.3_9.msi"),
            "MongoDB Community Server",
            Map.of("7.0.12", "https://fastdl.mongodb.org/windows/mongodb-windows-x86_64-7.0.12-signed.msi"), "Postman",
            Map.of("11.3.0", "https://dl.pstmn.io/download/latest/win64")));

    public static String getUrl(String applicationName, String version) {
        return urls.get(applicationName).get(version);
    }

}
