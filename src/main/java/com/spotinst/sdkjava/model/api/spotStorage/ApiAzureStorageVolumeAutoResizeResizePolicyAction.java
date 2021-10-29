package com.spotinst.sdkjava.model.api.spotStorage;

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
public class ApiAzureStorageVolumeAutoResizeResizePolicyAction implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      type;
    private Integer     adjustmentPercentage;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeAutoResizeResizePolicyAction() {
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

    //region Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }
    //endregion

    //region adjustmentPercentage
    public Integer getAdjustmentPercentage() {
        return adjustmentPercentage;
    }

    public void setAdjustmentPercentage(Integer adjustmentPercentage) {
        isSet.add("adjustmentPercentage");
        this.adjustmentPercentage = adjustmentPercentage;
    }
    //endregion

    //region isSet methods
    // Is type Set boolean method
    @JsonIgnore
    public boolean istypeSet() {
        return isSet.contains("type");
    }

    // Is adjustmentPercentage Set boolean method
    @JsonIgnore
    public boolean isadjustmentPercentageSet() {
        return isSet.contains("adjustmentPercentage");
    }
    //endregion
}
