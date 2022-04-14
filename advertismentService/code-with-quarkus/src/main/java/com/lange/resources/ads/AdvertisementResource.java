package com.lange.resources.ads;

import com.lange.domain.Ads.Advertisement;
import com.lange.domain.Ads.Category;
import com.lange.domain.Ads.Mobile;
import com.lange.resources.ads.dto.AdvertisementDTO;
import com.lange.resources.ads.dto.CreateAdDTO;
import com.lange.service.AdvertisementService;
import com.lange.service.requests.GetAdvertisementRequest;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/")
public class AdvertisementResource {

    private final AdvertisementService advertisementService;
    @Inject
    public AdvertisementResource(AdvertisementService advertisementService){
        this.advertisementService = advertisementService;
    }




    @Path("/advertisements")
    @GET
    @RolesAllowed({"USER, ADMIN, SUPER_USER"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Advertisement> showAds(){
        List<Advertisement> advertisementList = advertisementService.getAll();
        return advertisementList;
    }

    @Path("/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"USER", "ADMIN", "SUPER_USER"})
    public Response categories() {
        HashMap<Category, Integer> map = advertisementService.createMapWithTotalAmountOfAdvertisementsForEveryCategory();
        List<Map.Entry<Category, Integer>> categoryList = map.entrySet().stream().toList();
        return Response.ok().entity(categoryList).build();
    }
    @Path("/createAd")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"USER", "ADMIN", "SUPER_USER"})
    @Produces(MediaType.APPLICATION_JSON)
    public Mobile createAd(CreateAdDTO advertisement){
        return new Mobile(advertisementService.createAd(advertisement.toRequest()).getAdvertisement().getPhoneNumber().getNumber());
    }

    @Path("/{category}/advertisements")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"USER", "ADMIN", "SUPER_USER"})
    public Response adsForCategory(@PathParam("category") String category) {
        Category category1 = Category.valueOf(category.toUpperCase());
        HashMap<String,String> map = advertisementService.createMapWithAdvertisementsForCategory(category1);
        List<Map.Entry<String,String>> mapList = map.entrySet().stream().toList();
        return Response.ok().entity(mapList).build();
    }

    @Path("/advertisement/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"USER", "ADMIN", "SUPER_USER"})
    public Response getAd(@PathParam("id") String id) {
        GetAdvertisementRequest request = new GetAdvertisementRequest(id);
        Advertisement advertisement = advertisementService.get(request);
        return Response.ok().entity(advertisement).build();
    }
}
