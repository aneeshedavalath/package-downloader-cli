package com.pd.utils;

public class CommandOption {

    private CommandOption() {
    }

    public static final String LIST_SO = "-l";

    public static final String LIST_LO = "--list";

    public static final String LIST_DESCRIPTION = "List all available packages";

    public static final String DEVELOPER_SO = "-dv";

    public static final String DEVELOPER_LO = "--developer";

    public static final String DEVELOPER_DESCRIPTION = "Filter by developer";

    public static final String MANUAL_TESTER_SO = "-qm";

    public static final String MANUAL_TESTER_LO = "--manual-tester";

    public static final String MANUAL_TESTER_DESCRIPTION = "Filter by manual tester";

    public static final String AUTOMATION_TESTER_SO = "-qa";

    public static final String AUTOMATION_TESTER_LO = "--automation-tester";

    public static final String AUTOMATION_TESTER_DESCRIPTION = "Filter by automation tester";

    public static final String DOWNLOAD_SO = "-d";

    public static final String DOWNLOAD_LO = "--download";

    public static final String DOWNLOAD_DESCRIPTION = "Download packages";

    public static final String PROJECT_SO = "-p";

    public static final String PROJECT_LO = "--project";

    public static final String PROJECT_DESCRIPTION = "Code of the project [mry = Mercury, vns = Venus, mrs = Mars]";

}
