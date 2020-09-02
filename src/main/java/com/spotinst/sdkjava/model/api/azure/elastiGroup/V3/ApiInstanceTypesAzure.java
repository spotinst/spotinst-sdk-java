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
class ApiInstanceTypesAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private String       ondemand;
    private List<String> spot;
    //endregion

    //region Constructor

    public ApiInstanceTypesAzure() {
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

    public List<String> getSpot() {
        return spot;
    }

    public void setSpot(List<String> spot) {
        isSet.add("spot");
        this.spot = spot;
    }

    public String getOndemand() {

        return ondemand;
    }

    public void setOndemand(String ondemand) {
        isSet.add("ondemand");
        this.ondemand = ondemand;
    }

    //endregion

    //region isSet methods

    // Is ondemand Set boolean method
    @JsonIgnore
    public boolean isOndemandSet() {
        return isSet.contains("ondemand");
    }

    // Is spot Set boolean method
    @JsonIgnore
    public boolean isSpotSet() {
        return isSet.contains("spot");
    }


    //endregion

}
