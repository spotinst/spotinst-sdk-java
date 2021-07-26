package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiOceanGKEAutoScale {

    private List<ApiOceanGKEHeadRooms> headrooms;

    private Set<String> isSet;

    private ApiOceanGKEAutoScale(){isSet = new HashSet<>();
    }

    public List<ApiOceanGKEHeadRooms> getHeadrooms(){
        return headrooms;
    }

    public void setHeadrooms(List<ApiOceanGKEHeadRooms> headrooms){

        this.headrooms = headrooms;
    }

    public static class Builder {
        private ApiOceanGKEAutoScale apiGkeAutoScale;

        private Builder() {
            this.apiGkeAutoScale = new ApiOceanGKEAutoScale();
        }

        public static ApiOceanGKEAutoScale.Builder get() {
            ApiOceanGKEAutoScale.Builder builder = new ApiOceanGKEAutoScale.Builder();
            return builder;
        }

        public ApiOceanGKEAutoScale.Builder setHeadrooms(final List<ApiOceanGKEHeadRooms> headrooms) {
            apiGkeAutoScale.setHeadrooms(headrooms);
            return this;
        }

        public ApiOceanGKEAutoScale build() {
            return apiGkeAutoScale;
        }
    }


    @JsonIgnore
    public boolean isHeadroomsSet() {
        return isSet.contains("headrooms");
    }
}
