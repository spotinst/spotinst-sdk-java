package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeallocationConfig {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeleteImages;
    private Boolean     shouldDeleteNetworkInterfaces;
    private Boolean     shouldDeleteSnapshots;
    private Boolean     shouldDeleteVolumes;
    private Boolean     shouldTerminateInstance;
    //endregion

    //region Constructor

    private DeallocationConfig() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldDeleteImages() {
        return shouldDeleteImages;
    }

    public void setShouldDeleteImages(Boolean shouldDeleteImages) {
        isSet.add("shouldDeleteImages");
        this.shouldDeleteImages = shouldDeleteImages;
    }

    public Boolean getShouldDeleteNetworkInterfaces() {
        return shouldDeleteNetworkInterfaces;
    }

    public void setShouldDeleteNetworkInterfaces(Boolean shouldDeleteNetworkInterfaces) {
        isSet.add("shouldDeleteNetworkInterfaces");
        this.shouldDeleteNetworkInterfaces = shouldDeleteNetworkInterfaces;
    }

    public Boolean getShouldDeleteSnapshots() {
        return shouldDeleteSnapshots;
    }

    public void setShouldDeleteSnapshots(Boolean shouldDeleteSnapshots) {
        isSet.add("shouldDeleteSnapshots");
        this.shouldDeleteSnapshots = shouldDeleteSnapshots;
    }

    public Boolean getShouldDeleteVolumes() {
        return shouldDeleteVolumes;
    }

    public void setShouldDeleteVolumes(Boolean shouldDeleteVolumes) {
        isSet.add("shouldDeleteVolumes");
        this.shouldDeleteVolumes = shouldDeleteVolumes;
    }

    public Boolean getShouldTerminateInstance() {
        return shouldTerminateInstance;
    }

    public void setShouldTerminateInstance(Boolean shouldTerminateInstance) {
        isSet.add("shouldTerminateInstance");
        this.shouldTerminateInstance = shouldTerminateInstance;
    }

    //region Builder class
    public static class Builder {
        private DeallocationConfig deallocationConfig;

        private Builder() {
            this.deallocationConfig = new DeallocationConfig();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setShouldDeleteImages(final Boolean shouldDeleteImages) {
            deallocationConfig.setShouldDeleteImages(shouldDeleteImages);
            return this;
        }

        public Builder setShouldDeleteNetworkInterfaces(final Boolean shouldDeleteNetworkInterfaces) {
            deallocationConfig.setShouldDeleteNetworkInterfaces(shouldDeleteNetworkInterfaces);
            return this;
        }

        public Builder setShouldDeleteSnapshots(final Boolean shouldDeleteSnapshots) {
            deallocationConfig.setShouldDeleteSnapshots(shouldDeleteSnapshots);
            return this;
        }

        public Builder setShouldDeleteVolumes(final Boolean shouldDeleteVolumes) {
            deallocationConfig.setShouldDeleteVolumes(shouldDeleteVolumes);
            return this;
        }

        public Builder setShouldTerminateInstance(final Boolean shouldTerminateInstance) {
            deallocationConfig.setShouldTerminateInstance(shouldTerminateInstance);
            return this;
        }

        public DeallocationConfig build() {
            // TODO : Validations
            return deallocationConfig;
        }
    }
    //endregion

    @JsonIgnore
    public boolean isShouldDeleteImagesSet() {
        return isSet.contains("shouldDeleteImages");
    }

    @JsonIgnore
    public boolean isShouldDeleteNetworkInterfacesSet() {
        return isSet.contains("shouldDeleteNetworkInterfaces");
    }

    @JsonIgnore
    public boolean isShouldDeleteSnapshotsSet() {
        return isSet.contains("shouldDeleteSnapshots");
    }

    @JsonIgnore
    public boolean isShouldDeleteVolumesSet() {
        return isSet.contains("shouldDeleteVolumes");
    }

    @JsonIgnore
    public boolean isShouldTerminateInstanceSet() {
        return isSet.contains("shouldTerminateInstance");
    }

}
