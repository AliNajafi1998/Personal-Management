package com.najafi.ali.personalmanagement.ModelForWork;

public class Work {
    private String name;
    private int img;
    private boolean active;

    public Work(String name, int img, boolean active) {
        this.name = name;
        this.img = img;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
