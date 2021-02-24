package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.GcpPerformAtEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiRevertToPreemptibleGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>      isSet;
    private GcpPerformAtEnum performAt;
    //endregion

    //region Constructor

    public ApiRevertToPreemptibleGcp() {
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

    public GcpPerformAtEnum getPerformAt() {

        return performAt;
    }

    public void setPerformAt(GcpPerformAtEnum performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }
    //endregion

    //region isSet methods
    // Is performAt Set boolean method
    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }
    //endregion

}
