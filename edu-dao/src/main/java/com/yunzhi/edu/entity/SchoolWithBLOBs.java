package com.yunzhi.edu.entity;

public class SchoolWithBLOBs extends School {
    private String news;

    private String banner;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news == null ? null : news.trim();
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }
}