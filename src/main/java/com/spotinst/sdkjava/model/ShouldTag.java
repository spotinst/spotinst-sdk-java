package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShouldTag {
    //region Members
    private Set<String>        isSet;
    private Boolean            shouldTag;

    //endregion


    //region Setters&Getters

    public Boolean getShouldTag() {
        return shouldTag;
    }

    public void setShouldTag(Boolean shouldTag) {
        isSet.add("set");
        this.shouldTag = shouldTag;
    }

    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    //endregion

    //region Methods
    @JsonIgnore
    public boolean isSet() {
        return isSet.contains("set");
    }

    //endregion
}
