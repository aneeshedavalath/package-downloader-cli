package com.pd.processor;

import com.pd.enums.Headers;
import com.pd.model.Application;
import com.pd.utils.Constants;

import java.util.List;

public class ListProcessor {

    private ListProcessor() {
    }

    public static void processor(boolean isForDeveloper, boolean isForQm, boolean isForQa, String project) {
        System.out.println(Constants.LIST_SEPARATOR);
        System.out.printf(Constants.LIST_HEADER_STRING_FORMAT, Headers.NAME, Headers.VERSION, Headers.SIZE.getValue());
        System.out.println(Constants.LIST_SEPARATOR);
        filter(Application.applicationManager(), isForDeveloper, isForQm, isForQa, project);
        System.out.println(Constants.LIST_SEPARATOR);
    }

    public static void filter(List<Application> applications, boolean isForDeveloper, boolean isForQm, boolean isForQa,
                              String project) {
        if ((isForDeveloper && isForQm) || (isForDeveloper && isForQa)) {
            System.exit(0);
        } else if (isForDeveloper) {
            retrieve(applications.stream().filter(applicationList -> Boolean.TRUE.equals(
                    applicationList.isForDeveloper()) && applicationList.getProjects().contains(project)).toList());
        } else if (isForQa) {
            retrieve(applications.stream().filter(applicationList -> Boolean.TRUE.equals(
                    applicationList.isForQa()) && applicationList.getProjects().contains(project)).toList());
        } else if (isForQm) {
            retrieve(applications.stream().filter(applicationList -> Boolean.TRUE.equals(
                    applicationList.isForQm()) && applicationList.getProjects().contains(project)).toList());
        } else {
            retrieve(applications);
        }
    }

    public static void retrieve(List<Application> applications) {
        for (Application application : applications) {
            System.out.printf(Constants.LIST_HEADER_STRING_FORMAT, application.getName(), application.getVersion(), String.format(Constants.FLOATING_POINT_LIMITER, application.getSize()));
        }
    }

}
