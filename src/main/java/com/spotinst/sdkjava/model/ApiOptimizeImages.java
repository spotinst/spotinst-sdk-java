package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiOptimizeImages implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>               isSet;
    private Boolean                   shouldOptimizeEcsAmi;
    private MaintenanceWindowTypeEnum performAt;  //todo sali - convert to enum
    private List<String>              timeWindows;
    //endregion

    //region Constructor
    public ApiOptimizeImages() {
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

    public Boolean getShouldOptimizeEcsAmi() {
        return shouldOptimizeEcsAmi;
    }

    public void setShouldOptimizeEcsAmi(Boolean shouldOptimizeEcsAmi) {
        isSet.add("shouldOptimizeEcsAmi");
        this.shouldOptimizeEcsAmi = shouldOptimizeEcsAmi;
    }

    public MaintenanceWindowTypeEnum getPerformAt() {
        return performAt;
    }

    public void setPerformAt(MaintenanceWindowTypeEnum performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    public List<String> getTimeWindows() {
        return timeWindows;
    }

    public void setTimeWindows(List<String> timeWindows) {
        isSet.add("timeWindows");
        this.timeWindows = timeWindows;
    }

    //endregion
    //region isSet methods
    // Is optimizeImages Set boolean method
    @JsonIgnore
    public boolean isShouldOptimizeEcsAmiSet() {
        return isSet.contains("shouldOptimizeEcsAmi");
    }

    // Is performAt Set boolean method
    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }

    // Is timeWindow Set boolean method
    @JsonIgnore
    public boolean isTimeWindowSet() {
        return isSet.contains("timeWindows");
    }

}
