package com.example.easygo_travelapp.model;

import java.util.List;

public class Review {
    private int idReview;
    private String avatar;
    private String fullName;
    private String time;
    private String content;
    private List<Review> replies;

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Review> getReplies() {
        return replies;
    }

    public void setReplies(List<Review> replies) {
        this.replies = replies;
    }

    public Review() {
    }

    public Review(int idReview, String avatar, String fullName, String time, String content, List<Review> replies) {
        this.idReview = idReview;
        this.avatar = avatar;
        this.fullName = fullName;
        this.time = time;
        this.content = content;
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "Review{" +
                "idReview=" + idReview +
                ", avatar='" + avatar + '\'' +
                ", fullName='" + fullName + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", replies=" + replies +
                '}';
    }
}
