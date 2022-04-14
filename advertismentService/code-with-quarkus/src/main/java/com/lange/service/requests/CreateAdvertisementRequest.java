package com.lange.service.requests;

import com.lange.domain.Ads.*;

public class CreateAdvertisementRequest {


    private final Category category;
    private final Type type;
    private final HeaderText headerText;
    private final BodyText bodyText;
    private final Price price;
    private final Mobile phoneNumber;
    private final ImgUrl imageUrl;

    public CreateAdvertisementRequest( String category, String type, String headerText, String bodyText,
                                      double price, String phoneNumber, String imageUrl) {

        this.category = Category.valueOf(category);
        this.type = Type.valueOf(type);
        this.headerText = new HeaderText(headerText);
        this.bodyText = new BodyText(bodyText);
        this.price = new Price(price);
        this.phoneNumber = new Mobile(phoneNumber);
        this.imageUrl = new ImgUrl(imageUrl);
    }


    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public HeaderText getHeaderText() {
        return headerText;
    }

    public BodyText getBodyText() {
        return bodyText;
    }

    public Price getPrice() {
        return price;
    }

    public Mobile getPhoneNumber() {
        return phoneNumber;
    }

    public ImgUrl getImageUrl() {
        return imageUrl;
    }
}
