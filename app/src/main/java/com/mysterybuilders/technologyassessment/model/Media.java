package com.mysterybuilders.technologyassessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Media {
    @SerializedName("type")
    private String type;
    @SerializedName("subType")
    private String subType;
    @SerializedName("caption")
    private String caption;
    @SerializedName("media-metadata")
    private ArrayList<Image> imageListArrayList;

    public Media(String type, String subType, String caption, ArrayList<Image> imageListArrayList) {
        this.type = type;
        this.subType = subType;
        this.caption = caption;
        this.imageListArrayList = imageListArrayList;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ArrayList<Image>  getImageList() {
        return imageListArrayList;
    }

    public void setImageList(ArrayList<Image> imageListArrayList) {
        this.imageListArrayList = imageListArrayList;
    }



}
