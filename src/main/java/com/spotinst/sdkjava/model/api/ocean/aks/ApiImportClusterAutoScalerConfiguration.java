package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiImportClusterAutoScalerConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                 isSet;
    private Boolean                                     isEnabled;
    private ApiImportClusterResourceLimitsSpecification resourceLimits;
    private ApiImportClusterDownSpecification           down;
    private ApiImportClusterHeadroomSpecification       headroom;

    public ApiImportClusterAutoScalerConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public ApiImportClusterResourceLimitsSpecification getResourceLimits() {
        return resourceLimits;
    }

    public void setResourceLimits(ApiImportClusterResourceLimitsSpecification resourceLimits) {
        isSet.add("resourceLimits");
        this.resourceLimits = resourceLimits;
    }

    public ApiImportClusterDownSpecification getDown() {
        return down;
    }

    public void setDown(ApiImportClusterDownSpecification down) {
        isSet.add("down");
        this.down = down;
    }

    public ApiImportClusterHeadroomSpecification getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiImportClusterHeadroomSpecification headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isResourceLimits() {
        return isSet.contains("resourceLimits");
    }

    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headroom");
    }

}
