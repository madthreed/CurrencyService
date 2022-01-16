package com.madthreed.currencyservice.models.giphy;

public class GifObject {
    String type;
    String id;
    String slug;
    String url;
    String bitly_url;
    String embed_url;
    String username;
    String source;
    String rating;
    String content_url;
    UserObject user;
    String source_tld;
    String source_post_url;
    String update_datetime;
    String create_datetime;
    String import_datetime;
    String trending_datetime;
    ImageObject images;
    String title;

    public GifObject() {
    }

    public GifObject(String type, String id, String slug, String url, String bitly_url, String embed_url, String username, String source, String rating, String content_url, UserObject user, String source_tld, String source_post_url, String update_datetime, String create_datetime, String import_datetime, String trending_datetime, ImageObject images, String title) {
        this.type = type;
        this.id = id;
        this.slug = slug;
        this.url = url;
        this.bitly_url = bitly_url;
        this.embed_url = embed_url;
        this.username = username;
        this.source = source;
        this.rating = rating;
        this.content_url = content_url;
        this.user = user;
        this.source_tld = source_tld;
        this.source_post_url = source_post_url;
        this.update_datetime = update_datetime;
        this.create_datetime = create_datetime;
        this.import_datetime = import_datetime;
        this.trending_datetime = trending_datetime;
        this.images = images;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBitly_url() {
        return bitly_url;
    }

    public void setBitly_url(String bitly_url) {
        this.bitly_url = bitly_url;
    }

    public String getEmbed_url() {
        return embed_url;
    }

    public void setEmbed_url(String embed_url) {
        this.embed_url = embed_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public UserObject getUser() {
        return user;
    }

    public void setUser(UserObject user) {
        this.user = user;
    }

    public String getSource_tld() {
        return source_tld;
    }

    public void setSource_tld(String source_tld) {
        this.source_tld = source_tld;
    }

    public String getSource_post_url() {
        return source_post_url;
    }

    public void setSource_post_url(String source_post_url) {
        this.source_post_url = source_post_url;
    }

    public String getUpdate_datetime() {
        return update_datetime;
    }

    public void setUpdate_datetime(String update_datetime) {
        this.update_datetime = update_datetime;
    }

    public String getCreate_datetime() {
        return create_datetime;
    }

    public void setCreate_datetime(String create_datetime) {
        this.create_datetime = create_datetime;
    }

    public String getImport_datetime() {
        return import_datetime;
    }

    public void setImport_datetime(String import_datetime) {
        this.import_datetime = import_datetime;
    }

    public String getTrending_datetime() {
        return trending_datetime;
    }

    public void setTrending_datetime(String trending_datetime) {
        this.trending_datetime = trending_datetime;
    }

    public ImageObject getImages() {
        return images;
    }

    public void setImages(ImageObject images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
