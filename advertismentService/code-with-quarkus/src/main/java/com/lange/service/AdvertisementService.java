package com.lange.service;


import com.lange.domain.Ads.Advertisement;
import com.lange.domain.Ads.Category;
import com.lange.domain.Ads.Mobile;
import com.lange.persistance.Rep;
import com.lange.service.requests.CreateAdvertisementRequest;
import com.lange.service.requests.GetAdvertisementRequest;
import com.lange.service.responses.CreateAdvertisementResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Dependent
    @Transactional
    public class AdvertisementService {
        private final Rep repository;
        @Inject
        public AdvertisementService(Rep repository){this.repository = repository;}

        public Advertisement get(GetAdvertisementRequest request){
            return repository.getAdvertisement(request.getId());
        }




        public List<Advertisement> getAll(){return repository.getAllAds();}

        public CreateAdvertisementResponse createAd(CreateAdvertisementRequest request){
            Advertisement advertisement = repository.createAdvertisement(request.getCategory(), request.getType(),
                    request.getHeaderText(), request.getBodyText(), request.getPrice(), request.getPhoneNumber(),
                    request.getImageUrl());
            return new CreateAdvertisementResponse(advertisement);
        }

        public HashMap<Category, Integer> createMapWithTotalAmountOfAdvertisementsForEveryCategory () {
            HashMap<Category, Integer> map = new HashMap<>();
            for (Category category : Category.values()) {
                int amount = repository.findAllAdvertisementByCategory(category).size();
                map.put(category, amount);
            }
        return  map;
        }

    public HashMap<String, String> createMapWithAdvertisementsForCategory (Category category) {
        List<Advertisement> list = repository.findAllAdvertisementByCategory(category);
        HashMap<String, String> map = convertListToMap(list);
        return  map;
    }

    private HashMap<String, String> convertListToMap (List<Advertisement> list)  {
        HashMap<String, String> newMap = new HashMap<>();
            for (Advertisement a : list) {
            newMap.put(a.getId().getRaw(), a.getHeaderText().getValue());
        }
            return newMap;
    }

}
