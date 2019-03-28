package com.mysterybuilders.technologyassessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MediaList {

    private ArrayList<Media> mediaList;

    public ArrayList<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(ArrayList<Media> mediaList) {
        this.mediaList = mediaList;
    }
}
