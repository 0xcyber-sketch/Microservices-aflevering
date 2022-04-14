package com.lange.domain.Ads;
import java.util.UUID;
public class AdvertisementID {

        private  UUID value;
        public AdvertisementID(UUID id){this.value = id;}


        public AdvertisementID(String uuid) {
            this.value = UUID.fromString(uuid);
        }

        public String getRaw() {
            return value.toString();
        }
        public UUID getUuid() {
            return value;
        }

}
