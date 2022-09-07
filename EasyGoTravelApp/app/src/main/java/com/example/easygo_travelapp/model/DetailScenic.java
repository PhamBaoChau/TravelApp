package com.example.easygo_travelapp.model;

import java.util.List;

public class DetailScenic {
    private ItemScenic inforCommon;
    private int rating;
    private String description;
    private String photos;
    private List<TourAndTicket> tour;
    private List<Review> review;

    public ItemScenic getInforCommon() {
        return inforCommon;
    }

    public void setInforCommon(ItemScenic inforCommon) {
        this.inforCommon = inforCommon;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public List<TourAndTicket> getTour() {
        return tour;
    }

    public void setTour(List<TourAndTicket> tour) {
        this.tour = tour;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public DetailScenic() {
    }

    public DetailScenic(ItemScenic inforCommon, int rating, String description, String photos, List<TourAndTicket> tour, List<Review> review) {
        this.inforCommon = inforCommon;
        this.rating = rating;
        this.description = description;
        this.photos = photos;
        this.tour = tour;
        this.review = review;
    }

    @Override
    public String toString() {
        return "DetailScenic{" +
                "inforCommon=" + inforCommon +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", photos='" + photos + '\'' +
                ", tour=" + tour +
                ", review=" + review +
                '}';
    }
}
