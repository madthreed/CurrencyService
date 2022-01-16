package com.madthreed.currencyservice.models.giphy;

import lombok.Data;

@Data
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
    ImagesObject images;
    String title;
}
