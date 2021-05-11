package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiPredictiveScale {
    //region Members
    @JsonIgnore
    private Set<String> isSet = new HashSet<>();
    private String      mode;
    //endregion

    //region Getter and Setter methods
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        isSet.add("mode");
        this.mode = mode;
    }

    // Is Mode Set boolean method
    @JsonIgnore
    public boolean isModeSet() {
        return isSet.contains("mode");
    }
    //endregion
}
