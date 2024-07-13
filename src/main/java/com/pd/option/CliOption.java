package com.pd.option;

import com.pd.processor.DownloadProcessor;
import com.pd.enums.Project;
import com.pd.processor.ListProcessor;
import com.pd.utils.CommandOption;
import com.pd.utils.Constants;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = Constants.CLI_NAME, mixinStandardHelpOptions = true, version = Constants.CLI_VERSION, description = Constants.CLI_DESCRIPTION)
public class CliOption implements Callable<Integer> {

    @CommandLine.Option(names = { CommandOption.LIST_SO,
            CommandOption.LIST_LO }, description = CommandOption.LIST_DESCRIPTION)
    boolean list;

    @CommandLine.Option(names = { CommandOption.DEVELOPER_SO,
            CommandOption.DEVELOPER_LO }, description = CommandOption.DEVELOPER_DESCRIPTION)
    boolean developer;

    @CommandLine.Option(names = { CommandOption.MANUAL_TESTER_SO,
            CommandOption.MANUAL_TESTER_LO }, description = CommandOption.MANUAL_TESTER_DESCRIPTION)
    boolean qm;

    @CommandLine.Option(names = { CommandOption.AUTOMATION_TESTER_SO,
            CommandOption.AUTOMATION_TESTER_LO }, description = CommandOption.AUTOMATION_TESTER_DESCRIPTION)
    boolean qa;

    @CommandLine.Option(names = { CommandOption.DOWNLOAD_SO,
            CommandOption.DOWNLOAD_LO }, description = CommandOption.DOWNLOAD_DESCRIPTION)
    boolean download;

    @CommandLine.Option(names = { CommandOption.PROJECT_SO,
            CommandOption.PROJECT_LO }, description = CommandOption.PROJECT_DESCRIPTION, required = true)
    String project;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     */
    @Override
    public Integer call() {
        if (list) {
            ListProcessor.processor(developer, qm, qa, Project.valueOf(project.toUpperCase()).getValue());
        } else if (download) {
            DownloadProcessor.processor(developer, qm, qa, Project.valueOf(project.toUpperCase()).getValue());
        } else {
            CommandLine.usage(this, System.out);
        }

        return 0;
    }
}
