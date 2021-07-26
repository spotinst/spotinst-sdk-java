package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKEStorage;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKEStorage {

    private Set<String> isSet;
    private int         localSsdCount;

    private ApiOceanGKEStorage(){isSet = new HashSet<>();
    }
    public int getLocalSsdCount() {
        return localSsdCount;
    }

    public void setLocalSsdCount(int localSsdCount) {
        isSet.add("localSsdCount");
        this.localSsdCount = localSsdCount;
    }

    public static class Builder {
        private ApiOceanGKEStorage apiGkeStorage;

        private Builder() {
            this.apiGkeStorage = new ApiOceanGKEStorage();
        }

        public static ApiOceanGKEStorage.Builder get() {
            ApiOceanGKEStorage.Builder builder = new ApiOceanGKEStorage.Builder();
            return builder;
        }

        public ApiOceanGKEStorage.Builder setLocalSsdCount(final int localSsdCount) {
            apiGkeStorage.setLocalSsdCount(localSsdCount);
            return this;
        }

        public ApiOceanGKEStorage build() {
            return apiGkeStorage;
        }
    }


    @JsonIgnore
    public boolean isLocalSsdCountSet() {
        return isSet.contains("localSsdCount");
    }

}
