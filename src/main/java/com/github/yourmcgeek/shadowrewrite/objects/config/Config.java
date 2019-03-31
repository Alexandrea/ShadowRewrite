package com.github.yourmcgeek.shadowrewrite.objects.config;

import java.util.ArrayList;

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
    private ArrayList<String> swearWords = new ArrayList<>();
    private String linkingURL = "Change this to the proper \"Linking Accounts\" wiki page url";
    private String crashURL = "Change this to the proper \"Crash Reports\" wiki page url";
    private String claimURL = "Change this to the proper \"Tiqaulity Tile Entity Claiming\" wiki page url";
    private String clURL = "Change this to the proper \"Chunk Loading\" wiki page url";
    private String restartURL = "Change this to the proper \"Restart and Wipe\" wiki page url";
    private String wikiURL = "Change this to the proper \"Wiki\" direct url";
    private String crateURL = "Change this to the proper \"Crates\" wiki page url";
    private String relocateURL = "Change this to the proper \"Relocation\" wiki page url";
    private String hostname = "changeme";
    private int port = 0;
    private String username = "changeme";
    private String password = "changeme";
    private String databaseName = "changeme";
    private ArrayList<Long> channelsToWatch = new ArrayList<>();
    private ArrayList<Long> rolesToWatch = new ArrayList<>();
    private ArrayList<Long> userMentionToWatch = new ArrayList<>();
    private int pingChannel = 0;

    public Config() {}

    public Config(String prefix, String token, String botOwnerId, String supportId, String supportCategoryId
    , String guildID, String logChannelID, int colorRed, int colorBlue, int colorGreen, ArrayList<String> blacklistFiles,
                  String linkingURL, String crashURL, String claimURL, String clURL,
                  String restartURL, String wikiURL, String crateURL, String relocateURL, ArrayList<String> swearWords,
                  String hostname, int port, String username, String password, String databaseName, ArrayList<Long> channelsToWatch,
                  ArrayList<Long> rolesToWatch, int pingChannel, ArrayList<Long> userMentionToWatch) {
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
        this.linkingURL = linkingURL;
        this.crashURL = crashURL;
        this.clURL = clURL;
        this.claimURL = claimURL;
        this.restartURL = restartURL;
        this.wikiURL = wikiURL;
        this.crateURL = crateURL;
        this.relocateURL = relocateURL;
        this.swearWords = swearWords;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.channelsToWatch = channelsToWatch;
        this.rolesToWatch = rolesToWatch;
        this.pingChannel = pingChannel;
        this.userMentionToWatch = userMentionToWatch;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getToken() {
        return token;
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

    public String getCrashURL() {
        return crashURL;
    }

    public String getLinkingURL() {
        return linkingURL;
    }

    public String getClaimURL() {
        return claimURL;
    }

    public String getCLURL() {
        return clURL;
    }

    public String getRestartURL() {
        return restartURL;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public String getCrateURL() {
        return crateURL;
    }

    public String getRelocateURL() {
        return relocateURL;
    }

    public ArrayList<String> getSwearWords() {
        return swearWords;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public ArrayList<Long> getChannelsToWatch() { return channelsToWatch; }

    public ArrayList<Long> getRolesToWatch() {
        return rolesToWatch;
    }

    public int getPingChannel() {
        return pingChannel;
    }

    public ArrayList<Long> getUserMentionToWatch() {
        return userMentionToWatch;
    }
}