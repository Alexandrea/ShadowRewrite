package com.github.yourmcgeek.objects.config;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {
    private String prefix = "/";
    private String botOwnerId = "changeme";
    private String token = "changeme";
    private String supportId = "changeme";
    private String supportCategoryId = "changeme";
    private String guildID = "";
    private String logChannelID = "";
    private int colorRed = 0;
    private int colorBlue = 0;
    private int colorGreen = 0;
    private ArrayList<String> blacklistFiles = new ArrayList<>();
    private ArrayList<String> serverRoles = new ArrayList<>();
    private String linkingURL = "Change this to the proper \"Linking Accounts\" wiki page url";
    private String crashURL = "Change this to the proper \"Crash Reports\" wiki page url";

    public Config() {}

    public Config(String prefix, String token, String botOwnerId, String supportId, String supportCategoryId
    , String guildID, String logChannelID, int colorRed, int colorBlue, int colorGreen, ArrayList<String> blacklistFiles
    , ArrayList<String> serverRoles, String linkingURL, String crashURL) {
        this.prefix = prefix;
        this.token = token;
        this.botOwnerId = botOwnerId;
        this.supportId = supportId;
        this.supportCategoryId = supportCategoryId;
        this.guildID = guildID;
        this.logChannelID = logChannelID;
        this.colorRed = colorRed;
        this.colorGreen = colorGreen;
        this.colorBlue = colorBlue;
        this.blacklistFiles = blacklistFiles;
        this.serverRoles = serverRoles;
        this.linkingURL = linkingURL;
        this.crashURL = crashURL;
    }

    @Override
    public String toString() {
        return "Config{" +
                "prefix='" + prefix + '\'' +
                ", botOwnerId=" + botOwnerId + + '\'' +
                ", token='" + token + '\'' +
                ", supportId='" + supportId + '\'' +
                ", guildId='" + guildID + '\'' +
                ", logChannelId='" + logChannelID + '\'' +
                ", colorRed='" + colorRed + '\'' +
                ", colorGreen='" + colorGreen + '\'' +
                ", colorBlue='" + colorBlue + '\'' +
                ", crashURL='" + crashURL + '\'' +
                ", linkingURL='" + linkingURL + '\'' +
                ", blacklistFiles: ['" + Arrays.toString(blacklistFiles.toArray()) + "']" +
                ", serverRoles: ['" + Arrays.toString(serverRoles.toArray()) + "']";
    }

    public String getPrefix() {
        return prefix;
    }

    public String getBotOwnerId() {
        return botOwnerId;
    }

    public String getToken() {
        return token;
    }

    public String getSupportId() {
        return supportId;
    }

    public String getSupportCategoryId() {
        return supportCategoryId;
    }

    public String getGuildID() {
        return guildID;
    }

    public String getLogChannelID() {
        return logChannelID;
    }

    public int getColorRed() {
        return colorRed;
    }

    public int getColorBlue() {
        return colorBlue;
    }

    public int getColorGreen() {
        return colorGreen;
    }

    public ArrayList<String> getBlacklistFiles() {
        return blacklistFiles;
    }

    public ArrayList<String> getServerRoles() { return serverRoles; }

    public String getCrashURL() {
        return crashURL;
    }

    public String getLinkingURL() {
        return linkingURL;
    }
}