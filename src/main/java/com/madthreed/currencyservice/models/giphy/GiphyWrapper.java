package com.madthreed.currencyservice.models.giphy;

public class GiphyWrapper {
    private Giphy giphy;

    public GiphyWrapper() {
    }

    public GiphyWrapper(Giphy giphy) {
        this.giphy = giphy;
    }

    public Giphy getGiphy() {
        return giphy;
    }

    public void setGiphy(Giphy giphy) {
        this.giphy = giphy;
    }
}
