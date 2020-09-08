package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupVmSizesAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> odSizes;
    private List<String> spotSizes;
    //endregion

    //region Constructor

    public ApiElastigroupVmSizesAzure() {
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

    public List<String> getOdSizes() {
        return odSizes;
    }

    public void setOdSizes(List<String> odSizes) {
        isSet.add("odSizes");
        this.odSizes = odSizes;
    }

    public List<String> getSpotSizes() {
        return spotSizes;
    }

    public void setSpotSizes(List<String> spotSizes) {
        isSet.add("spotSizes");
        this.spotSizes = spotSizes;
    }

    //endregion

    //region isSet methods
    // Is odSizes Set boolean method
    @JsonIgnore
    public boolean isOdSizesSet() {
        return isSet.contains("odSizes");
    }

    // Is spotSizes Set boolean method
    @JsonIgnore
    public boolean isSpotSizesSet() {
        return isSet.contains("spotSizes");
    }

    //endregion
}
