package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeVmSizesConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>  isSet;
    private List<String> spotSizes;
    private List<String> odSizes;
    private List<String> preferredSpotSizes;

    public ApiStatefulNodeVmSizesConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getSpotSizes() {
        return spotSizes;
    }

    public void setSpotSizes(List<String> spotSizes) {
        isSet.add("spotSizes");
        this.spotSizes = spotSizes;
    }

    public List<String> getOdSizes() {
        return odSizes;
    }

    public void setOdSizes(List<String> odSizes) {
        isSet.add("odSizes");
        this.odSizes = odSizes;
    }

    public List<String> getPreferredSpotSizes() {
        return preferredSpotSizes;
    }

    public void setPreferredSpotSizes(List<String> preferredSpotSizes) {
        isSet.add("preferredSpotSizes");
        this.preferredSpotSizes = preferredSpotSizes;
    }


    @JsonIgnore
    public boolean isSpotSizesSet() {
        return isSet.contains("spotSizes");
    }

    public boolean isOdSizesSet() {
        return isSet.contains("odSizes");
    }

    public boolean isPreferredSpotSizesSet() {
        return isSet.contains("preferredSpotSizes");
    }
}