package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiPerFormAt {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> timeWindow;
    //endregion

    //region Constructor
    public ApiPerFormAt() {isSet = new HashSet<>();}
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    public List<String> getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(List<String> timeWindow) {
        isSet.add("timeWindow");
        this.timeWindow = timeWindow;
    }
    //endregion

    //region isSet methods
    // Is timeWindow Set boolean method
    @JsonIgnore
    public boolean isTimeWindowSet() {
        return isSet.contains("timeWindow");
    }

}
