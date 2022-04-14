package com.lange.service.responses;

import com.lange.domain.Ads.Advertisement;

public class CreateAdvertisementResponse {
    private final Advertisement advertisement;

    public CreateAdvertisementResponse(Advertisement advertisement){
        this.advertisement = advertisement;
    }
    public Advertisement getAdvertisement(){
        return advertisement;
    }


}
