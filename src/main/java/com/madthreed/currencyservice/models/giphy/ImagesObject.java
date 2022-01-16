package com.madthreed.currencyservice.models.giphy;

import com.madthreed.currencyservice.models.giphy.rendention.*;
import lombok.Data;

@Data
public class ImagesObject {
    private Fixed fixedHeight;
    private Still fixedHeightStill;
    private Downsampled fixedHeightDownsampled;
    private Fixed fixedWidth;
    private Still fixedWidthStill;
    private Downsampled fixedWidthDownsampled;
    private Fixed fixedHeightSmall;
    private Still fixedHeightSmallStill;
    private Fixed fixedWidthSmall;
    private Still fixedWidthSmallStill;
    private Downsized downsized;
    private Still downsizedStill;
    private Downsized downsizedLarge;
    private Downsized downsizedMedium;
    private Downsized downsizedSmall;
    private Original original;
    private Still originalStill;
    private Looping looping;
    private Preview preview;
    private PreviewGif previewGif;
}
