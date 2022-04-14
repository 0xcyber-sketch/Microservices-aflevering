package com.lange.service.requests;

import com.lange.domain.Ads.AdvertisementID;

public class GetAdvertisementRequest {
    private final AdvertisementID id;

    public GetAdvertisementRequest(String id) { this.id = new AdvertisementID(id);}

    public AdvertisementID getId() {return id;}
}
