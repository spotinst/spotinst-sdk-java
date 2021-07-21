package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class OceanGKEResourceLimits {

    private int maxInstanceCount;

    private Set<String> isSet;


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public int getMaxInstanceCount(){
        return maxInstanceCount;
    }

    public void setMaxInstanceCount(int maxInstanceCount){
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    public static class Builder {
        private OceanGKEResourceLimits gkeResourceLimits;

        private Builder() {
            this.gkeResourceLimits = new OceanGKEResourceLimits();
        }

        public static OceanGKEResourceLimits.Builder get() {
            OceanGKEResourceLimits.Builder builder = new OceanGKEResourceLimits.Builder();
            return builder;
        }

        public OceanGKEResourceLimits.Builder setMaxInstanceCount(final int maxInstanceCount) {
            gkeResourceLimits.setMaxInstanceCount(maxInstanceCount);
            return this;
        }

        public OceanGKEResourceLimits build() {
            return gkeResourceLimits;
        }
    }


    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }
}
