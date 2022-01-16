package com.madthreed.currencyservice.models.giphy;

public class ImageObject {
    private RenditionObject fixedHeightStill;
    private RenditionObject fixedHeight;
    private RenditionObject fixedHeightDownsampled;
    private RenditionObject fixedWidth;
    private RenditionObject fixedWidthStill;
    private RenditionObject fixedWidthDownsampled;
    private RenditionObject fixedHeightSmall;
    private RenditionObject fixedHeightSmallStill;
    private RenditionObject fixedWidthSmall;
    private RenditionObject fixedWidthSmallStill;
    private RenditionObject downsized;
    private RenditionObject downsizedStill;
    private RenditionObject downsizedMedium;
    private RenditionObject downsizedLarge;
    private RenditionObject original;//GiphyOriginal original;
    private RenditionObject originalStill;
    private RenditionObject looping;

    public ImageObject() {
    }

    public ImageObject(RenditionObject fixedHeightStill, RenditionObject fixedHeight, RenditionObject fixedHeightDownsampled, RenditionObject fixedWidth, RenditionObject fixedWidthStill, RenditionObject fixedWidthDownsampled, RenditionObject fixedHeightSmall, RenditionObject fixedHeightSmallStill, RenditionObject fixedWidthSmall, RenditionObject fixedWidthSmallStill, RenditionObject downsized, RenditionObject downsizedStill, RenditionObject downsizedMedium, RenditionObject downsizedLarge, RenditionObject original, RenditionObject originalStill, RenditionObject looping) {
        this.fixedHeightStill = fixedHeightStill;
        this.fixedHeight = fixedHeight;
        this.fixedHeightDownsampled = fixedHeightDownsampled;
        this.fixedWidth = fixedWidth;
        this.fixedWidthStill = fixedWidthStill;
        this.fixedWidthDownsampled = fixedWidthDownsampled;
        this.fixedHeightSmall = fixedHeightSmall;
        this.fixedHeightSmallStill = fixedHeightSmallStill;
        this.fixedWidthSmall = fixedWidthSmall;
        this.fixedWidthSmallStill = fixedWidthSmallStill;
        this.downsized = downsized;
        this.downsizedStill = downsizedStill;
        this.downsizedMedium = downsizedMedium;
        this.downsizedLarge = downsizedLarge;
        this.original = original;
        this.originalStill = originalStill;
        this.looping = looping;
    }

    public RenditionObject getFixedHeightStill() {
        return fixedHeightStill;
    }

    public void setFixedHeightStill(RenditionObject fixedHeightStill) {
        this.fixedHeightStill = fixedHeightStill;
    }

    public RenditionObject getFixedHeight() {
        return fixedHeight;
    }

    public void setFixedHeight(RenditionObject fixedHeight) {
        this.fixedHeight = fixedHeight;
    }

    public RenditionObject getFixedHeightDownsampled() {
        return fixedHeightDownsampled;
    }

    public void setFixedHeightDownsampled(RenditionObject fixedHeightDownsampled) {
        this.fixedHeightDownsampled = fixedHeightDownsampled;
    }

    public RenditionObject getFixedWidth() {
        return fixedWidth;
    }

    public void setFixedWidth(RenditionObject fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    public RenditionObject getFixedWidthStill() {
        return fixedWidthStill;
    }

    public void setFixedWidthStill(RenditionObject fixedWidthStill) {
        this.fixedWidthStill = fixedWidthStill;
    }

    public RenditionObject getFixedWidthDownsampled() {
        return fixedWidthDownsampled;
    }

    public void setFixedWidthDownsampled(RenditionObject fixedWidthDownsampled) {
        this.fixedWidthDownsampled = fixedWidthDownsampled;
    }

    public RenditionObject getFixedHeightSmall() {
        return fixedHeightSmall;
    }

    public void setFixedHeightSmall(RenditionObject fixedHeightSmall) {
        this.fixedHeightSmall = fixedHeightSmall;
    }

    public RenditionObject getFixedHeightSmallStill() {
        return fixedHeightSmallStill;
    }

    public void setFixedHeightSmallStill(RenditionObject fixedHeightSmallStill) {
        this.fixedHeightSmallStill = fixedHeightSmallStill;
    }

    public RenditionObject getFixedWidthSmall() {
        return fixedWidthSmall;
    }

    public void setFixedWidthSmall(RenditionObject fixedWidthSmall) {
        this.fixedWidthSmall = fixedWidthSmall;
    }

    public RenditionObject getFixedWidthSmallStill() {
        return fixedWidthSmallStill;
    }

    public void setFixedWidthSmallStill(RenditionObject fixedWidthSmallStill) {
        this.fixedWidthSmallStill = fixedWidthSmallStill;
    }

    public RenditionObject getDownsized() {
        return downsized;
    }

    public void setDownsized(RenditionObject downsized) {
        this.downsized = downsized;
    }

    public RenditionObject getDownsizedStill() {
        return downsizedStill;
    }

    public void setDownsizedStill(RenditionObject downsizedStill) {
        this.downsizedStill = downsizedStill;
    }

    public RenditionObject getDownsizedMedium() {
        return downsizedMedium;
    }

    public void setDownsizedMedium(RenditionObject downsizedMedium) {
        this.downsizedMedium = downsizedMedium;
    }

    public RenditionObject getDownsizedLarge() {
        return downsizedLarge;
    }

    public void setDownsizedLarge(RenditionObject downsizedLarge) {
        this.downsizedLarge = downsizedLarge;
    }

    public RenditionObject getOriginal() {
        return original;
    }

    public void setOriginal(RenditionObject original) {
        this.original = original;
    }

    public RenditionObject getOriginalStill() {
        return originalStill;
    }

    public void setOriginalStill(RenditionObject originalStill) {
        this.originalStill = originalStill;
    }

    public RenditionObject getLooping() {
        return looping;
    }

    public void setLooping(RenditionObject looping) {
        this.looping = looping;
    }
}
