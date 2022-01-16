package com.madthreed.currencyservice.models.giphy;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

public class Giphy {
    GifObject gifObject;
    MetaObject metaObject;

    public Giphy() {
    }
@JsonCreator
    public Giphy(GifObject gifObject, MetaObject metaObject) {
        this.gifObject = gifObject;
        this.metaObject = metaObject;
    }

    public GifObject getGifObject() {
        return gifObject;
    }

    public void setGifObject(GifObject gifObject) {
        this.gifObject = gifObject;
    }

    public MetaObject getMetaObject() {
        return metaObject;
    }

    public void setMetaObject(MetaObject metaObject) {
        this.metaObject = metaObject;
    }
}
