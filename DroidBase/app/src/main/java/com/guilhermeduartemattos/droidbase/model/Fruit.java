package com.guilhermeduartemattos.droidbase.model;

/**
 * Created by guilhermeduartemattos on 6/4/15.
 */
public class Fruit {

    private String imgUrl;
    private String title;
    private String description;
    private double value;

    public Fruit(String imgUrl, String title, String description, double value) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.description = description;
        this.value = value;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
