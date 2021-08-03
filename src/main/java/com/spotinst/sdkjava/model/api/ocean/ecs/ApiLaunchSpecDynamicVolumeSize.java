package com.spotinst.sdkjava.model.api.ocean.ecs;

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
public class ApiLaunchSpecDynamicVolumeSize implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     baseSize;
    private String      resource;
    private Integer     sizePerResourceUnit;

    public ApiLaunchSpecDynamicVolumeSize() {
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
