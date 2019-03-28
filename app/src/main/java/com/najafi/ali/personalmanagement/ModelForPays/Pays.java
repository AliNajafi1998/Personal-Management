package com.najafi.ali.personalmanagement.ModelForPays;

public class Pays {
    private double price;
    private double duration;
    private String date;

    public Pays(double price, double duration, String date) {
        this.price = price;
        this.duration = duration;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
