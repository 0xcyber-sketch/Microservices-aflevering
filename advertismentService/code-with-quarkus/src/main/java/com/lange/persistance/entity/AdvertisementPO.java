package com.lange.persistance.entity;

import com.lange.domain.Ads.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Advertisements")
@NamedQueries({
        @NamedQuery(name = "AdvertisementPO.findAll", query = "Select a FROM AdvertisementPO a"),
        @NamedQuery(name = "AdvertisementPO.findByPhoneNumber", query = "Select a FROM AdvertisementPO a where a.phoneNumber=:phoneNumber"),
        @NamedQuery(name = "AdvertisementPO.findByCategory", query = "Select a FROM AdvertisementPO a where a.category=:category")
})

public class AdvertisementPO {
    public static final String FIND_BY_PHONENUMBER = "AdvertisementPO.findByPhoneNumber";
    public static final String PHONENUMBER_PARAM = "phoneNumber";
    public static final String FIND_ALL = "AdvertisementPO.findAll";
    public static final String FIND_BY_CATEGORY = "AdvertisementPO.findByCategory";
    public static final String CATEGORY_PARAM = "category";


    @javax.persistence.Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    private UUID id;

    @Column(name = "CATEGORY", columnDefinition = "varchar(40)")
    private String category;
    @Column(name = "TYPE", columnDefinition = "varchar(40)")
    private String type;
    @Column(name = "HEADERTEXT", columnDefinition = "varchar(100)")
    private String headerText;
    @Column(name = "BODYTEXT", columnDefinition = "varchar(280)")
    private String bodyText;
    @Column(name = "PRICE", columnDefinition = "float")
    private double price;
    @Column(name = "PHONENUMBER", columnDefinition = "varchar(40)")
    private String phoneNumber;
    @Column(name = "IMAGEURL", columnDefinition = "varchar(2048)")
    private String imageUrl;


    public AdvertisementPO(){

    }

    public AdvertisementPO(Category category, com.lange.domain.Ads.Type type,
                           HeaderText headerText, BodyText bodyText,
                           Price price, Mobile phoneNumber,
                           ImgUrl imageUrl){
        this.category = category.name();
        this.type = type.name();
        this.headerText = headerText.getValue();
        this.bodyText = bodyText.getValue();
        this.price = price.getValue();
        this.phoneNumber = phoneNumber.getNumber();
        this.imageUrl = imageUrl.getUrl();
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Advertisement toAdvertisement(){
        return new Advertisement(new AdvertisementID(id), Category.valueOf(category), com.lange.domain.Ads.Type.valueOf(type),
                new HeaderText(headerText), new BodyText(bodyText), new Price(price), new Mobile(phoneNumber),
                new ImgUrl(imageUrl));
    }
}
