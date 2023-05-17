package ru.ubrr.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isWebMobile() {
        if (config.browserMobileView() != null) {
            return !config.browserMobileView().equals("");
        }
        return false;
    }

    public static boolean isRemoteWebDriver() {
        if (config.remoteDriverUrl() != null) {
            return !config.remoteDriverUrl().equals("");
        }
        return false;
    }
    public static boolean isVideoOn() {
        if (config.videoStorage() != null) {
            return !config.videoStorage().equals("");
        }
        return false;
    }
}
