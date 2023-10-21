package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsEbsBlockDeviceConfig {
    @JsonIgnore
    private Set<String>                      isSet;
    private Integer                          volumesPerInstance;
    private MrScalerAwsVolumeSpecification volumeSpecification;

    private MrScalerAwsEbsBlockDeviceConfig() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getVolumesPerInstance() {
        return volumesPerInstance;
    }

    public void setVolumesPerInstance(Integer volumesPerInstance) {
        isSet.add("volumesPerInstance");
        this.volumesPerInstance = volumesPerInstance;
    }

    public MrScalerAwsVolumeSpecification getVolumeSpecification() {
        return volumeSpecification;
    }

    public void setVolumeSpecification(MrScalerAwsVolumeSpecification volumeSpecification) {
        isSet.add("volumeSpecification");
        this.volumeSpecification = volumeSpecification;
    }

    public static class Builder {
        private MrScalerAwsEbsBlockDeviceConfig ebsConfig;

        private Builder() { this.ebsConfig = new MrScalerAwsEbsBlockDeviceConfig(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setVolumesPerInstance(final Integer volumesPerInstance){
            ebsConfig.setVolumesPerInstance(volumesPerInstance);
            return this;
        }
        public Builder setVolumeSpecification(final MrScalerAwsVolumeSpecification volumeSpecification){
            ebsConfig.setVolumeSpecification(volumeSpecification);
            return this;
        }

        public MrScalerAwsEbsBlockDeviceConfig build(){
            return ebsConfig;
        }

    }

    @JsonIgnore
    public Boolean isVolumesPerInstanceSet(){ return isSet.contains("volumesPerInstance"); }

    @JsonIgnore
    public Boolean isVolumeSpecificationSet(){ return isSet.contains("volumeSpecification"); }
}
