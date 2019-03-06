package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsEbsBlockDeviceConfig {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer volumesPerInstance;
    private ApiMrScalerAwsVolumeSpecification volumeSpecification;
    // endregion

    //region Constructor
    public ApiMrScalerAwsEbsBlockDeviceConfig() {  isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region volumesPerInstance
    public Integer getVolumesPerInstance(){ return volumesPerInstance; }

    public void setVolumesPerInstance(Integer volumesPerInstance) {
        isSet.add("volumesPerInstance");
        this.volumesPerInstance = volumesPerInstance;
    }

    public Boolean isVolumesPerInstanceSet(){ return isSet.contains("volumesPerInstance"); }
    // endregion

    // region volumeSpecification
    public ApiMrScalerAwsVolumeSpecification getVolumeSpecification(){ return volumeSpecification; }

    public void setVolumeSpecification(ApiMrScalerAwsVolumeSpecification volumeSpecification) {
        isSet.add("volumeSpecification");
        this.volumeSpecification = volumeSpecification;
    }

    public Boolean isVolumeSpecificationSet(){ return isSet.contains("volumeSpecification"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsEbsBlockDeviceConfig ebsConfig;

        private Builder() { this.ebsConfig = new ApiMrScalerAwsEbsBlockDeviceConfig(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setVolumesPerInstance(final Integer volumesPerInstance){
            ebsConfig.setVolumesPerInstance(volumesPerInstance);
            return this;
        }
        public Builder setVolumeSpecification(final ApiMrScalerAwsVolumeSpecification volumeSpecification){
            ebsConfig.setVolumeSpecification(volumeSpecification);
            return this;
        }

        public ApiMrScalerAwsEbsBlockDeviceConfig build(){
            return ebsConfig;
        }

        // endregion
    }
}
