package xyz.jncode.jp1.Model;

import com.google.gson.annotations.SerializedName;

public class Articles {



    @SerializedName("source")
    public Sources source;

    @SerializedName("author")
    public String author;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String desc;


    @SerializedName("url")
    public String urlOnly;

    @SerializedName("urlToImage")
    public String mediaUrlImage;

    @SerializedName("publishedAt")
    public String publishedAt;

    public Sources getSource() {
        return source;
    }

    public void setSource(Sources source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrlOnly() {
        return urlOnly;
    }

    public void setUrlOnly(String urlOnly) {
        this.urlOnly = urlOnly;
    }

    public String getMediaUrlImage() {
        return mediaUrlImage;
    }

    public void setMediaUrlImage(String mediaUrlImage) {
        this.mediaUrlImage = mediaUrlImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @SerializedName("content")
    public String content;






}
