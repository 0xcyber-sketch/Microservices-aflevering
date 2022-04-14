package com.lange.domain.Ads;

import com.lange.resources.ads.dto.AdvertisementDTO;

public class Advertisement {
    private  Category category;
    private AdvertisementID adID;
    private Type type;
    private HeaderText headerText;
    private BodyText text;
    private Price price;
    private Mobile mobileNumber;
    private ImgUrl imgUrl;

    public Advertisement(AdvertisementID id, Category category, Type type,
                         HeaderText headerText, BodyText bodyText,
                         Price price, Mobile phoneNumber,
                         ImgUrl imageUrl){
        this.adID = id;
        this.category = category;
        this.type = type;
        this.headerText = headerText;
        this.text = bodyText;
        this.price = price;
        this.mobileNumber = phoneNumber;
        this.imgUrl = imageUrl;
    }

    public AdvertisementID getId() {
        return adID;
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
        return text;
    }

    public Price getPrice() {
        return price;
    }

    public Mobile getPhoneNumber() {
        return mobileNumber;
    }

    public ImgUrl getImageUrl() {
        return imgUrl;
    }


    public AdvertisementDTO toDTO(){
        return new AdvertisementDTO(this.adID, this.category, this.type, this.headerText, this.text,
                this.price, this.mobileNumber, this.imgUrl);
    }



}
