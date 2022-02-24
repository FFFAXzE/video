package com.cdu.videoshare.model;

import lombok.Data;

/**
 * @Version 1.0
 * @Author 彭彭
 * @Date 2021/1/19 9:27
 * @Description TODO
 * Modification User:
 * Modification Date:
 */
@Data
public class Favor {
    private int id;
    private int videoId;
    private int userId;
    private String favorTime;

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

    public String getFavorTime() {
        return favorTime;
    }

    public void setFavorTime(String favorTime) {
        this.favorTime = favorTime;
    }

    public Favor(int videoId, int userId) {
        this.videoId = videoId;
        this.userId = userId;

    }
}
