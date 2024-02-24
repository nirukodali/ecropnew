package com.ecrops.dto.crop.response;


import java.util.List;

public class WeblandPullResponse {
    private String message;
    private List<WeblandCropDetails> cropData;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<WeblandCropDetails> getCropData() {
        return cropData;
    }

    public void setCropData(List<WeblandCropDetails> cropData) {
        this.cropData = cropData;
    }
}
