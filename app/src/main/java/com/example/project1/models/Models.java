package com.example.project1.models;

import android.widget.ImageView;
import android.widget.RatingBar;

public class Models {

    private String image;
    private String name;
    private String adress;
    private String info;
    private int cost;
    private float ratingBar;

    public Models(String image, String name, String adress, String info, int cost, float ratingBar) {
        this.image = image;
        this.name = name;
        this.adress = adress;
        this.info = info;
        this.cost = cost;
        this.ratingBar = ratingBar;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAdress() { return adress;  }

    public void setAdress(String adress) { this.adress = adress; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }
}
