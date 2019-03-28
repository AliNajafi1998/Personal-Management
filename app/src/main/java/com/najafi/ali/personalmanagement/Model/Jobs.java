package com.najafi.ali.personalmanagement.Model;

public class Jobs {

    private int id;
    private int image;
    private String name;
    private double duration;
    private double paid;
    private double price;
    private boolean expanded;
    private boolean hasNote;
    private String note;

    public Jobs(int id, int image, String name, double duration, double paid, double price, boolean hasNote) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.duration = duration;
        this.paid = paid;
        this.price = price;
        this.hasNote = hasNote;
        this.expanded = true;
    }

    public boolean isHasNote() {
        return hasNote;
    }

    public void setHasNote(boolean hasNote) {
        this.hasNote = hasNote;
    }

    public String getNote() {
        if (hasNote)
            return note;
        else
            return "";
    }

    public void setNote(String note) {
        this.hasNote = true;
        this.note = note;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
