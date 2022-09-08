package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsVolumeSpecification {
    @JsonIgnore
    private Set<String> isSet;
    private String      volumeType;
    private Integer     sizeInGB;
    private Integer     iops;

    private MrScalerAwsVolumeSpecification() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getVolumeType() {
        return volumeType;
    }

    public void setVolumeType(String volumeType) {
        isSet.add("volumeType");
        this.volumeType = volumeType;
    }

    public Integer getSizeInGB() {
        return sizeInGB;
    }

    public void setSizeInGB(Integer sizeInGB) {
        isSet.add("sizeInGB");
        this.sizeInGB = sizeInGB;
    }

    public Integer getIops() {
        return iops;
    }

    public void setIops(Integer iops) {
        isSet.add("iops");
        this.iops = iops;
    }

    public static class Builder {
        private MrScalerAwsVolumeSpecification volumeSpecification;

        private Builder(){ this.volumeSpecification = new MrScalerAwsVolumeSpecification(); }

        public static Builder get(){
            return new Builder();
        }

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

        public MrScalerAwsVolumeSpecification build(){
            return volumeSpecification;
        }
    }

    @JsonIgnore
    public Boolean isVolumeTypeSet(){ return isSet.contains("volumeType"); }

    @JsonIgnore
    public Boolean isSizeInGBSet(){ return isSet.contains("sizeInGB"); }

    @JsonIgnore
    public Boolean isIopsSet(){ return isSet.contains("iops"); }
}
