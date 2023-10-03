package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsResourceTypeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicIops {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Integer                  baseSize;
    private Integer                  sizePerResourceUnit;
    private AwsResourceTypeEnum      resource;
    //endregion

    //region Constructor
    private DynamicIops() {
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

    public AwsResourceTypeEnum getResource() {
        return resource;
    }

    public void setResource(AwsResourceTypeEnum resource) {
        isSet.add("resource");
        this.resource = resource;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private DynamicIops dynamicIops;

        private Builder() {
            this.dynamicIops = new DynamicIops();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBaseSize(final Integer baseSize) {
            dynamicIops.setBaseSize(baseSize);
            return this;
        }

        public Builder setSizePerResourceUnit(final Integer sizePerResourceUnit) {
            dynamicIops.setSizePerResourceUnit(sizePerResourceUnit);
            return this;
        }

        public Builder setResource(final AwsResourceTypeEnum resource) {
            dynamicIops.setResource(resource);
            return this;
        }

        public DynamicIops build() {
            return dynamicIops;
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

    // Is encrypted Set boolean method
    @JsonIgnore
    public boolean isResourceSet() {
        return isSet.contains("resource");
    }
    //endregion
}
