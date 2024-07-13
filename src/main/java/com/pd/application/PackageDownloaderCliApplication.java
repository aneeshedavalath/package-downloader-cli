package com.pd.application;

import com.pd.option.CliOption;
import picocli.CommandLine;

public class PackageDownloaderCliApplication {

    public static void main(String... args) {
        int exitCode = new CommandLine(new CliOption()).execute(args);
        System.exit(exitCode);
    }

}
