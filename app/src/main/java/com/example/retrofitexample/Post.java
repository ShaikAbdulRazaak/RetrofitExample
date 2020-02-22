package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("albumId")
    private int albumId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public Post(int albumId, int id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    int getAlbumId() {
        return albumId;
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
