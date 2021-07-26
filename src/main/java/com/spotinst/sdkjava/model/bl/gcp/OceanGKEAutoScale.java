package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OceanGKEAutoScale {

    private List<OceanGKEHeadRooms> headrooms;

    private Set<String> isSet;

    public OceanGKEAutoScale(){isSet = new HashSet<>();
    }

    public List<OceanGKEHeadRooms> getHeadrooms(){
        return headrooms;
    }

    public void setHeadrooms(List<OceanGKEHeadRooms> headrooms){
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    public static class Builder {
        private OceanGKEAutoScale gkeAutoScale;

        private Builder() {
            this.gkeAutoScale = new OceanGKEAutoScale();
        }

        public static OceanGKEAutoScale.Builder get() {
            OceanGKEAutoScale.Builder builder = new OceanGKEAutoScale.Builder();
            return builder;
        }

        public OceanGKEAutoScale.Builder setHeadrooms(final List<OceanGKEHeadRooms> headrooms) {
            gkeAutoScale.setHeadrooms(headrooms);
            return this;
        }

        public OceanGKEAutoScale build() {
            return gkeAutoScale;
        }
    }


    @JsonIgnore
    public boolean isHeadroomsSet() {
        return isSet.contains("headrooms");
    }
}
