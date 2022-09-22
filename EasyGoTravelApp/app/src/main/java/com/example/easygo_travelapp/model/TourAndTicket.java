package com.example.easygo_travelapp.model;

import java.io.Serializable;

public class TourAndTicket implements Serializable {
    private int idTour;
    private String imageTour;
    private String nameTour;
    private double rating;
    private int price;

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public String getImageTour() {
        return imageTour;
    }

    public void setImageTour(String imageTour) {
        this.imageTour = imageTour;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public TourAndTicket() {
    }

    public TourAndTicket(int idTour, String imageTour, String nameTour, double rating) {
        this.idTour = idTour;
        this.imageTour = imageTour;
        this.nameTour = nameTour;
        this.rating = rating;
    }

    public TourAndTicket(int idTour, String imageTour, String nameTour, double rating, int price) {
        this.idTour = idTour;
        this.imageTour = imageTour;
        this.nameTour = nameTour;
        this.rating = rating;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TourAndTicket{" +
                "idTour=" + idTour +
                ", imageTour='" + imageTour + '\'' +
                ", nameTour='" + nameTour + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
