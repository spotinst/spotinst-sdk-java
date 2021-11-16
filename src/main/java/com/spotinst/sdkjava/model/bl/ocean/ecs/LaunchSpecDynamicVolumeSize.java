package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecDynamicVolumeSize {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     baseSize;
    private String      resource;
    private Integer     sizePerResourceUnit;

    private LaunchSpecDynamicVolumeSize() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        isSet.add("resource");
        this.resource = resource;
    }

    public Integer getBaseSize() {
        return baseSize;
    }

    public void setBaseSize(Integer baseSize) {
        isSet.add("baseSize");
        this.baseSize = baseSize;
    }

    public Integer getSizePerResourceUnit() {
        return sizePerResourceUnit;
    }

    public void setSizePerResourceUnit(Integer sizePerResourceUnit) {
        isSet.add("sizePerResourceUnit");
        this.sizePerResourceUnit = sizePerResourceUnit;
    }

    public static class Builder {

        private LaunchSpecDynamicVolumeSize launchSpecDynamicVolumeSize;

        private Builder() {
            this.launchSpecDynamicVolumeSize = new LaunchSpecDynamicVolumeSize();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setBaseSize(final Integer baseSize) {
            launchSpecDynamicVolumeSize.setBaseSize(baseSize);
            return this;
        }

        public Builder setResource(final String resource) {
            launchSpecDynamicVolumeSize.setResource(resource);
            return this;
        }

        public Builder setSizePerResourceUnit(final Integer sizePerResourceUnit) {
            launchSpecDynamicVolumeSize.setSizePerResourceUnit(sizePerResourceUnit);
            return this;
        }

        public LaunchSpecDynamicVolumeSize build() {
            return launchSpecDynamicVolumeSize;
        }
    }

    @JsonIgnore
    public boolean isBaseSizeSet() {
        return isSet.contains("baseSize");
    }

    @JsonIgnore
    public boolean isResourceSet() {
        return isSet.contains("resource");
    }

    @JsonIgnore
    public boolean isSizePerResourceUnitSet() {
        return isSet.contains("sizePerResourceUnit");
    }
}
