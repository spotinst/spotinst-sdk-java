package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiGroupTagSpecification {
    //region Members
    @JsonIgnore
    private Set<String>        isSet = new HashSet<>();
    private Boolean            shouldTag;

    //endregion


    //region Setters&Getters

    public Boolean getShouldTag() {
        return shouldTag;
    }

    public void setShouldTag(Boolean shouldTag) {
        isSet.add("shouldTag");
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
    public boolean isShouldTagSet() {
        return isSet.contains("shouldTag");
    }

    //endregion
}
