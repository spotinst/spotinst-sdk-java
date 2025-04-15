package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsVolumeSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      volumeType;
    private Integer     sizeInGB;
    private Integer     iops;

    public ApiMrScalerAwsVolumeSpecification() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getVolumeType(){ return volumeType; }

    public void setVolumeType(String volumeType) {
        isSet.add("volumeType");
        this.volumeType = volumeType;
    }

    public Integer getSizeInGB(){ return sizeInGB; }

    public void setSizeInGB(Integer sizeInGB) {
        isSet.add("sizeInGB");
        this.sizeInGB = sizeInGB;
    }

    public Integer getIops(){ return iops; }

    public void setIops(Integer iops) {
        isSet.add("iops");
        this.iops = iops;
    }

    @JsonIgnore
    public Boolean isVolumeTypeSet(){ return isSet.contains("volumeType"); }

    @JsonIgnore
    public Boolean isSizeInGBSet(){ return isSet.contains("sizeInGB"); }

    @JsonIgnore
    public Boolean isIopsSet(){ return isSet.contains("iops"); }

}
