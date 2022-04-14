package com.lange.persistance;



import com.lange.domain.Ads.*;

import com.lange.persistance.entity.AdvertisementPO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;



@Dependent
@Transactional
public class Rep {
    private final EntityManager entityManager;

    @Inject
    public Rep(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Advertisements

    public Advertisement createAdvertisement(Category category, Type type,
                                             HeaderText headerText, BodyText bodyText,
                                             Price price, Mobile phoneNumber,
                                             ImgUrl imageUrl) {
        AdvertisementPO advertisementPO = new AdvertisementPO(category, type, headerText, bodyText, price, phoneNumber, imageUrl);
        entityManager.persist(advertisementPO);
        return advertisementPO.toAdvertisement();
    }

    public Advertisement getAdvertisement(AdvertisementID id){return entityManager.find(AdvertisementPO.class, id.getUuid()).toAdvertisement();}

    public List<Advertisement> getAllAds(){
        return entityManager.createNamedQuery(AdvertisementPO.FIND_ALL, AdvertisementPO.class).getResultList().stream().map(AdvertisementPO::toAdvertisement).collect(Collectors.toList());
    }

    public Advertisement findAdvertisementByPhoneNumber(Mobile phoneNumber) {
        try {
            return entityManager.createNamedQuery(AdvertisementPO.FIND_BY_PHONENUMBER, AdvertisementPO.class)
                    .setParameter(AdvertisementPO.PHONENUMBER_PARAM, phoneNumber)
                    .getSingleResult().toAdvertisement();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Advertisement> findAllAdvertisementByCategory(Category category) {
        try {
            return entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY, AdvertisementPO.class)
                    .setParameter(AdvertisementPO.CATEGORY_PARAM, category.name())
                    .getResultList().stream().map(AdvertisementPO::toAdvertisement).collect(Collectors.toList());
        } catch (NoResultException e) {
            return null;
        }
    }

}



