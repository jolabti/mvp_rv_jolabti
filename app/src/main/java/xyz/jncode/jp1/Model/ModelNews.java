package xyz.jncode.jp1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelNews {

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotResult() {
        return totResult;
    }

    public void setTotResult(int totResult) {
        this.totResult = totResult;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    @SerializedName("status")
    public String status;

    @SerializedName("totalResult")
    public int totResult;

    @SerializedName("articles")
    public ArrayList<Articles> articles ;




}
