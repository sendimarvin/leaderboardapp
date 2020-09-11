package com.example.leaderboard;

import com.google.gson.annotations.SerializedName;

public class RetroLeader {
    @SerializedName("name")
    private String name;
    @SerializedName("hours")
    private Integer hours;
    @SerializedName("country")
    private String country;
    @SerializedName("badgeUrl")
    private String badgeUrl;

    public RetroLeader(String name, Integer hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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
