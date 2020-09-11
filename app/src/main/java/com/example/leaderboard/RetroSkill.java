package com.example.leaderboard;

import com.google.gson.annotations.SerializedName;

public class RetroSkill {

    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private Integer score;
    @SerializedName("country")
    private String country;
    @SerializedName("badgeUrl")
    private String badgeUrl;

    public RetroSkill(String name, Integer score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setSkill(int score) {
        this.score = score;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return this.country;
    }

    public void setBadgeUrl(String country) {
        this.country = country;
    }
}
