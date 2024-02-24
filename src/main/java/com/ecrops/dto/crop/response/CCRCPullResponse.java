package com.ecrops.dto.crop.response;

import java.util.List;

public class CCRCPullResponse {
    private String message;
    private List<CcrcCropDetails> cropDataCcrc;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public List<CcrcCropDetails> getCropDataCcrc() {
		return cropDataCcrc;
	}

	public void setCropDataCcrc(List<CcrcCropDetails> cropDataCcrc) {
		this.cropDataCcrc = cropDataCcrc;
	}

	
       
}
