package com.wangzijie.nutrition_user.model.bean;

public class SiteData {
    private String region;

    public SiteData() {
        super();
    }

    @Override
    public String toString() {
        return "SiteData{" +
                "region='" + region + '\'' +
                '}';
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public SiteData(String region) {
        this.region = region;
    }
}
