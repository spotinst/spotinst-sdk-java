package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.PerformAtEnumGcp;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRevertToSpot {

    @JsonIgnore
    private Set<String> isSet;
    private PerformAtEnumGcp performAt;

    public ApiRevertToSpot() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public PerformAtEnumGcp getPerformAt() {
        return performAt;
    }

    public void setPerformAt(PerformAtEnumGcp performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }

}
