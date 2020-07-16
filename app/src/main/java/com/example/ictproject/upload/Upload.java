package com.example.ictproject.upload;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mAge;
    private String mExperience;
    private String mRegion;
    private String mDay;
    private String uId;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl, String age, String experience,String region, String day, String uid) {
        mName = name;
        mImageUrl = imageUrl;
        mAge = age;
        mExperience = experience;
        mRegion = region;
        mDay = day;
        uId = uid;
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
    public String getAge() {
        return mAge;
    }
    public void setAge(String age) {
        mAge = age;
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
    public String getuId() { return uId; }
    public void setuId(String uId) { this.uId = uId; }
}