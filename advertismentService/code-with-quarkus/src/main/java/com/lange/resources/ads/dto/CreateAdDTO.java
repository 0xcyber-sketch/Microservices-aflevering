package com.lange.resources.ads.dto;

import com.lange.service.requests.CreateAdvertisementRequest;

public class CreateAdDTO {
    private final String category;
    private final String type;
    private final String headerText;
    private final String bodyText;
    private final double price;
    private final String phoneNumber;
    private final String imageUrl;


    public CreateAdDTO(String category, String type, String headerText, String bodyText, double price, String phoneNumber, String imageUrl) {
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.bodyText = bodyText;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public double getPrice() {
        return price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CreateAdvertisementRequest toRequest(){return new CreateAdvertisementRequest(category, type, headerText, bodyText, price,
            phoneNumber, imageUrl);}
}

