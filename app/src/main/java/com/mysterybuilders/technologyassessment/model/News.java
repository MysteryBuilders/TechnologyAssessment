package com.mysterybuilders.technologyassessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class News {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("published_date")
    private String publishedDate;
   @SerializedName("media")
   private ArrayList<Media> MediaList;
    @SerializedName("byline")
    private String author;

    public News(String id, String title, String publishedDate,ArrayList<Media> MediaList,String author) {
        this.id = id;
        this.title = title;
        this.publishedDate = publishedDate;
        this.MediaList = MediaList;

        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public ArrayList<Media> getMediaList() {
        return MediaList;
    }

    public void setMediaList(ArrayList<Media> mediaList) {
        this.MediaList = mediaList;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
