package com.pd.model;

import com.pd.enums.Format;
import com.pd.enums.Package;
import com.pd.enums.Project;
import com.pd.enums.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    private String name;

    private String version;

    private Double size;

    private String format;

    private boolean isForDeveloper;

    private boolean isForQm;

    private boolean isForQa;

    private List<String> projects;

    public static List<Application> applicationManager() {
        List<Application> applications = new ArrayList<>();
        applications.add(new Application(Package.TEMURIN_JDK.getValue(), Version.JDK_21_LTS.getValue(), 179.00,
                Format.MSI.getValue(), true, false, true, List.of(Project.MRY.getValue())));
        applications.add(
                new Application(Package.MONGO_DB_COMMUNITY_SERVER.getValue(), Version.MONGO_DB_SERVER_7.getValue(),
                        569.00, Format.MSI.getValue(), true, false, false, List.of(Project.MRY.getValue())));
        applications.add(new Application(Package.POSTMAN.getValue(), Version.POSTMAN_11.getValue(), 131.00,
                Format.EXE.getValue(), true, true, true, List.of(Project.MRY.getValue())));

        return applications;
    }

}
