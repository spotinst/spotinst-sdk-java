package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsVolumeTypeEnum;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class Dynamiclops {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Integer                  baseSize;
    private Integer                  sizePerResourceUnit;
    private String                   resource;
    //endregion

    //region Constructor
    private Dynamiclops() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        isSet.add("resource");
        this.resource = resource;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private Dynamiclops dynamiclops;

        private Builder() {
            this.dynamiclops = new Dynamiclops();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBaseSize(final Integer baseSize) {
            dynamiclops.setBaseSize(baseSize);
            return this;
        }

        public Builder setSizePerResourceUnit(final Integer sizePerResourceUnit) {
            dynamiclops.setSizePerResourceUnit(sizePerResourceUnit);
            return this;
        }

        public Builder setResource(final String resource) {
            dynamiclops.setResource(resource);
            return this;
        }

        public Dynamiclops build() {
            return dynamiclops;
        }
    }

    //endregion

    //region isSet methods
    // Is deleteOnTermination Set boolean method
    @JsonIgnore
    public boolean isBaseSizeSet() {
        return isSet.contains("baseSize");
    }

    @JsonIgnore
    public boolean isSizePerResourceUnitSet() {
        return isSet.contains("sizePerResourceUnit");
    }

    // Is encrypted Set boolean method
    @JsonIgnore
    public boolean isResourceSet() {
        return isSet.contains("resource");
    }
    //endregion
}
