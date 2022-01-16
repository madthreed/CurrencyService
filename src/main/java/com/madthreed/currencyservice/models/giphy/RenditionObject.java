package com.madthreed.currencyservice.models.giphy;

public class RenditionObject {
    String url;
    String width;
    String height;
    String size;
    String mp4;
    String mp4_size;
    String webp;
    String webp_size;

    public RenditionObject() {
    }

    public RenditionObject(String url, String width, String height, String size, String mp4, String mp4_size, String webp, String webp_size) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.size = size;
        this.mp4 = mp4;
        this.mp4_size = mp4_size;
        this.webp = webp;
        this.webp_size = webp_size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public String getMp4_size() {
        return mp4_size;
    }

    public void setMp4_size(String mp4_size) {
        this.mp4_size = mp4_size;
    }

    public String getWebp() {
        return webp;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }

    public String getWebp_size() {
        return webp_size;
    }

    public void setWebp_size(String webp_size) {
        this.webp_size = webp_size;
    }
}
