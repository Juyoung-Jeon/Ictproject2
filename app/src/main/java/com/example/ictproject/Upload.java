package com.example.ictproject;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mExperience;
    private String mRegion;
    private String mDay;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl, String experience,String region, String day) {
        mName = name;
        mImageUrl = imageUrl;
        mExperience = experience;
        mRegion = region;
        mDay = day;
    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
    public String getExperience() {
        return mExperience;
    }
    public void setExperience(String experience) {
        mExperience = experience;
    }
    public String getRegion() {
        return mRegion;
    }
    public void setRegion(String region) {
        mRegion = region;
    }
    public String getDay() {
        return mDay;
    }
    public void setDay(String day) {
        mDay = day;
    }
}