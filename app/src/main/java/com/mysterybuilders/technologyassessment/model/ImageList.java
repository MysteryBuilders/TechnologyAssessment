package com.mysterybuilders.technologyassessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ImageList {

    private ArrayList<Image> imageArrayList;

    public ArrayList<Image> getImageList() {
        return imageArrayList;
    }

    public void setImageArrayList(ArrayList<Image> imageArrayList) {
        this.imageArrayList = imageArrayList;
    }
}
