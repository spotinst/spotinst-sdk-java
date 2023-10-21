package com.spotinst.sdkjava.model.api.gcp;


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
public class ApiElastigroupGkeConfigurationGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                 isSet;
    private ApiElastigroupAutoscaleConfigurationGcp     autoScale;
    private Boolean                                     autoUpdate;
    private String                                      clusterIdentifier;
    private String                                      location;


    public ApiElastigroupGkeConfigurationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiElastigroupAutoscaleConfigurationGcp getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ApiElastigroupAutoscaleConfigurationGcp autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public Boolean getAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(Boolean autoUpdate) {
        isSet.add("autoUpdate");
        this.autoUpdate = autoUpdate;
    }

    public String getClusterIdentifier() {
        return clusterIdentifier;
    }

    public void setClusterIdentifier(String clusterIdentifier) {
        isSet.add("clusterIdentifier");
        this.clusterIdentifier = clusterIdentifier;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        isSet.add("location");
        this.location = location;
    }

    @JsonIgnore
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }

    @JsonIgnore
    public boolean isAutoUpdateSet() {
        return isSet.contains("autoUpdate");
    }

    @JsonIgnore
    public boolean isClusterIdentifierSet() {
        return isSet.contains("clusterIdentifier");
    }

    @JsonIgnore
    public boolean isLocationSet() {
        return isSet.contains("location");
    }
}
