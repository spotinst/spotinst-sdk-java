package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class K8sVngDynamicVolumeSize {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     baseSize;
    private String      resource;
    private Integer     sizePerResourceUnit;

    private K8sVngDynamicVolumeSize() {
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

        private K8sVngDynamicVolumeSize vngDynamicVolumeSize;

        private Builder() {
            this.vngDynamicVolumeSize = new K8sVngDynamicVolumeSize();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setBaseSize(final Integer baseSize) {
            vngDynamicVolumeSize.setBaseSize(baseSize);
            return this;
        }

        public Builder setResource(final String resource) {
            vngDynamicVolumeSize.setResource(resource);
            return this;
        }

        public Builder setSizePerResourceUnit(final Integer sizePerResourceUnit) {
            vngDynamicVolumeSize.setSizePerResourceUnit(sizePerResourceUnit);
            return this;
        }

        public K8sVngDynamicVolumeSize build() {
            return vngDynamicVolumeSize;
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
