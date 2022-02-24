package com.cdu.videoshare.model;

import lombok.Data;

@Data
public class Praise {
    private int id;
    private int videoId;
    private int userId;
    private String praiseTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(String praiseTime) {
        this.praiseTime = praiseTime;
    }

    public Praise(int videoId, int userId) {
        this.videoId = videoId;
        this.userId = userId;


    }
}
