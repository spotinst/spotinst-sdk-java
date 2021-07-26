package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKEResourceLimits;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKEResourceLimits {

    private int maxInstanceCount;

    private Set<String> isSet;

    private ApiOceanGKEResourceLimits(){isSet = new HashSet<>();
    }
    public int getMaxInstanceCount(){
        return maxInstanceCount;
    }

    public void setMaxInstanceCount(int maxInstanceCount){
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    public static class Builder {
        private ApiOceanGKEResourceLimits apiGkeResourceLimits;

        private Builder() {
            this.apiGkeResourceLimits = new ApiOceanGKEResourceLimits();
        }

        public static ApiOceanGKEResourceLimits.Builder get() {
            ApiOceanGKEResourceLimits.Builder builder = new ApiOceanGKEResourceLimits.Builder();
            return builder;
        }

        public ApiOceanGKEResourceLimits.Builder setMaxInstanceCount(final int maxInstanceCount) {
            apiGkeResourceLimits.setMaxInstanceCount(maxInstanceCount);
            return this;
        }

        public ApiOceanGKEResourceLimits build() {
            return apiGkeResourceLimits;
        }
    }


    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }
}
