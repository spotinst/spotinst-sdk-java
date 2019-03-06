package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsVolumeSpecification {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String volumeType;
    private Integer sizeInGB;
    private Integer iops;
    // endregion

    //region Constructor
    public ApiMrScalerAwsVolumeSpecification() {  isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region volumeType
    public String getVolumeType(){ return volumeType; }

    public void setVolumeType(String volumeType) {
        isSet.add("volumeType");
        this.volumeType = volumeType;
    }

    public Boolean isVolumeTypeSet(){ return isSet.contains("volumeType"); }
    // endregion

    // region sizeInGB
    public Integer getSizeInGB(){ return sizeInGB; }

    public void setSizeInGB(Integer sizeInGB) {
        isSet.add("sizeInGB");
        this.sizeInGB = sizeInGB;
    }

    public Boolean isSizeInGBSet(){ return isSet.contains("sizeInGB"); }
    // endregion

    // region iops
    public Integer getIops(){ return iops; }

    public void setIops(Integer iops) {
        isSet.add("iops");
        this.iops = iops;
    }

    public Boolean isIopsSet(){ return isSet.contains("iops"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsVolumeSpecification volumeSpecification;

        private Builder(){ this.volumeSpecification = new ApiMrScalerAwsVolumeSpecification(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setVolumeType(final String volumeType){
            volumeSpecification.setVolumeType(volumeType);
            return this;
        }
        public Builder setSizeInGb(final Integer sizeInGB){
            volumeSpecification.setSizeInGB(sizeInGB);
            return this;
        }
        public Builder setIops(final Integer iops){
            volumeSpecification.setIops(iops);
            return this;
        }

        public ApiMrScalerAwsVolumeSpecification build(){
            return volumeSpecification;
        }
        // endregion
    }
}
