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
public class ApiMrScalerAwsEbsBlockDeviceConfig implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private Integer                             volumesPerInstance;
    private ApiMrScalerAwsVolumeSpecification   volumeSpecification;

    public ApiMrScalerAwsEbsBlockDeviceConfig() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getVolumesPerInstance(){ return volumesPerInstance; }

    public void setVolumesPerInstance(Integer volumesPerInstance) {
        isSet.add("volumesPerInstance");
        this.volumesPerInstance = volumesPerInstance;
    }

    public ApiMrScalerAwsVolumeSpecification getVolumeSpecification(){ return volumeSpecification; }

    public void setVolumeSpecification(ApiMrScalerAwsVolumeSpecification volumeSpecification) {
        isSet.add("volumeSpecification");
        this.volumeSpecification = volumeSpecification;
    }

    @JsonIgnore
    public Boolean isVolumesPerInstanceSet(){ return isSet.contains("volumesPerInstance"); }

    @JsonIgnore
    public Boolean isVolumeSpecificationSet(){ return isSet.contains("volumeSpecification"); }

}
