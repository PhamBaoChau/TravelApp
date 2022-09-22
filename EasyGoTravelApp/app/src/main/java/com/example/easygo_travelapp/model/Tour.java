package com.example.easygo_travelapp.model;

import java.io.Serializable;
import java.util.List;

public class Tour extends TourAndTicket implements Serializable{
    private String location;
    private int timeTour;
    private List<TourDetail>detailTour;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTimeTour() {
        return timeTour;
    }

    public void setTimeTour(int timeTour) {
        this.timeTour = timeTour;
    }

    public List<TourDetail> getDetailTour() {
        return detailTour;
    }

    public void setDetailTour(List<TourDetail> detailTour) {
        this.detailTour = detailTour;
    }

    public Tour() {
    }

    public Tour(int idTour, String imageTour, String nameTour, int rating, int price, String location, int timeTour, List<TourDetail> detailTour) {
        super(idTour, imageTour, nameTour, rating, price);
        this.location = location;
        this.timeTour = timeTour;
        this.detailTour = detailTour;
    }
}
