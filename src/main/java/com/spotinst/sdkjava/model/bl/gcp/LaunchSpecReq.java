package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaunchSpecReq {

    @JsonIgnore
    private Set<String> isSet;
    private String oceanId;
    private String sourceImage;

    private LaunchSpecReq() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        isSet.add("oceanId");
        this.oceanId = oceanId;
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        isSet.add("sourceImage");
        this.sourceImage = sourceImage;
    }

    public static class Builder {
        private LaunchSpecReq launchSpecReq;

        private Builder() {
            this.launchSpecReq = new LaunchSpecReq();
        }

        public static LaunchSpecReq.Builder get() {
            LaunchSpecReq.Builder builder = new LaunchSpecReq.Builder();
            return builder;
        }

        public LaunchSpecReq.Builder setSourceImage(final String sourceImage) {
            launchSpecReq.setSourceImage(sourceImage);
            return this;
        }

        public LaunchSpecReq.Builder setOceanId(final String OceanId) {
            launchSpecReq.setOceanId(OceanId);
            return this;
        }

        public LaunchSpecReq build() {
            return launchSpecReq;
        }
    }

    @JsonIgnore
    public boolean isSourceImage() {
        return isSet.contains("sourceImage");
    }

    // Is ondemand Set boolean method
    @JsonIgnore
    public boolean isOceanIdSet() { return isSet.contains("OceanId"); }
    //endregion

}
