package com.example.easygo_travelapp.model;

import java.io.Serializable;

public class TourDetail extends TourAndTicket implements Serializable {
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public TourDetail() {
    }

    public TourDetail(int idTour, String imageTour, String nameTour, int rating, double latitude, double longitude) {
        super(idTour, imageTour, nameTour, rating);
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
