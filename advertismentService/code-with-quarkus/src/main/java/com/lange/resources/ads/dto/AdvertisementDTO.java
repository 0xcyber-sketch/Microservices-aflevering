package com.lange.resources.ads.dto;

import com.lange.domain.Ads.*;
import com.lange.service.requests.CreateAdvertisementRequest;

public class AdvertisementDTO {
    private final String id;
    private final String category;
    private final String type;
    private final String headerText;
    private final String bodyText;
    private final double price;
    private final String phoneNumber;
    private final String imageUrl;

    public AdvertisementDTO(AdvertisementID id, Category category, Type type, HeaderText headerText, BodyText bodyText,
                            Price price, Mobile phoneNumber, ImgUrl imageUrl){
        this.id = id.getRaw();
        this.category = category.toString();
        this.type = type.toString();
        this.headerText = headerText.getValue();
        this.bodyText = bodyText.getValue();
        this.price = price.getValue();
        this.phoneNumber = phoneNumber.getNumber();
        this.imageUrl = imageUrl.getUrl();
    }

    public CreateAdvertisementRequest toRequest(){return new CreateAdvertisementRequest( category, type, headerText, bodyText, price,
            phoneNumber, imageUrl);}
}

