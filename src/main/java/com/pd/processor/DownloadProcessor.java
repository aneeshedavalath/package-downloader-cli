package com.pd.processor;

import com.pd.enums.Status;
import com.pd.model.Application;
import com.pd.model.Url;
import com.pd.utils.Constants;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DownloadProcessor {

    private DownloadProcessor() {
    }

    public static void processor(boolean isForDeveloper, boolean isForQm, boolean isForQa, String project) {
        createDirectory();
        filter(Application.applicationManager(), isForDeveloper, isForQm, isForQa, project);
    }

    public static void filter(List<Application> applications, boolean isForDeveloper, boolean isForQm, boolean isForQa, String project) {
        if ((isForDeveloper && isForQa) || (isForDeveloper && isForQm)) {
            System.exit(0);
        } else if (isForDeveloper) {
            download(applications.stream().filter(applicationList -> Boolean.TRUE.equals(applicationList.isForDeveloper()) && applicationList.getProjects().contains(project)).toList());
        } else if (isForQa) {
            download(applications.stream().filter(applicationList -> Boolean.TRUE.equals(applicationList.isForQa()) && applicationList.getProjects().contains(project)).toList());
        } else if (isForQm) {
            download(applications.stream().filter(applicationList -> Boolean.TRUE.equals(applicationList.isForQm()) && applicationList.getProjects().contains(project)).toList());
        } else {
            System.exit(0);
        }
    }

    public static void download(List<Application> applications) {
        for (Application application : applications) {
            String url = createURL(application.getName(), application.getVersion());
            String fileName = createFileName(application.getName(), application.getVersion(), application.getFormat());

            try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {

                byte[] dataBuffer = new byte[1024];
                int bytesRead;
                long totalBytesRead = 0;
                long fileSize = new URL(url).openConnection().getContentLengthLong();
                int lastPercentage = 0;

                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    totalBytesRead += bytesRead;
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                    int percentage = (int) ((totalBytesRead * 100) / fileSize);
                    if (percentage != lastPercentage) {
                        printProgress(application.getName(), percentage, applications.size(), applications.indexOf(application) + 1);
                        lastPercentage = percentage;
                    }
                }
                System.out.printf(Constants.LINE_FEED);
            } catch (IOException e) {
                System.out.printf("[%s]", Status.FAILED);
            }
        }
    }

    private static void createDirectory() {
        Path path = Paths.get(Constants.DOWNLOAD_DIRECTORY);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("Failed to create applications folder");
            }
        }
    }

    private static String createURL(String applicationName, String version) {
        return Url.getUrl(applicationName, version);
    }

    private static String createFileName(String applicationName, String version, String format) {
        return Constants.DOWNLOAD_DIRECTORY + Constants.FORWARD_SLASH + applicationName + Constants.ADDITION_SIGN + version + format;
    }

    private static void printProgress(String applicationName, int percentage, Integer totalFragments, Integer currentFragment) {
        String progressBar = "|" + ":".repeat(percentage / 2) + " ".repeat(50 - percentage / 2) + "|";
        System.out.printf(Constants.CARRIAGE_RETURN + Constants.PROGRESS_FORMAT, applicationName, progressBar, percentage, currentFragment, totalFragments, percentage == 100 ? Status.DOWNLOADED : Status.DOWNLOADING);
    }
}
