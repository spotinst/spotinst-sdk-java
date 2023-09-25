package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sobhana p on 8/13/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicVolumeSize {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Integer                  baseSize;
    private Integer                  sizePerResourceUnit;
    private String                   resource;
    //endregion

    //region Constructor
    private DynamicVolumeSize() {
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
        private DynamicVolumeSize dynamicVolumeSize;

        private Builder() {
            this.dynamicVolumeSize = new DynamicVolumeSize();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBaseSize(final Integer baseSize) {
            dynamicVolumeSize.setBaseSize(baseSize);
            return this;
        }

        public Builder setSizePerResourceUnit(final Integer sizePerResourceUnit) {
            dynamicVolumeSize.setSizePerResourceUnit(sizePerResourceUnit);
            return this;
        }

        public Builder setResource(final String resource) {
            dynamicVolumeSize.setResource(resource);
            return this;
        }

        public DynamicVolumeSize build() {
            return dynamicVolumeSize;
        }
    }

    //endregion

    //region isSet methods
    // Is baseSize Set boolean method
    @JsonIgnore
    public boolean isBaseSizeSet() {
        return isSet.contains("baseSize");
    }

    @JsonIgnore
    public boolean isSizePerResourceUnitSet() {
        return isSet.contains("sizePerResourceUnit");
    }

    // Is resource Set boolean method
    @JsonIgnore
    public boolean isResourceSet() {
        return isSet.contains("resource");
    }
    //endregion
}
