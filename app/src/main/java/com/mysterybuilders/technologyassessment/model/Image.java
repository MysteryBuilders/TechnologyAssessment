package com.mysterybuilders.technologyassessment.model;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("url")
    private String imageUrl;


    public Image(String imageUrl) {
        this.imageUrl = imageUrl;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
