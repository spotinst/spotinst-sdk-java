package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiTagSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldTag;

    public ApiTagSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldTag() {
        return shouldTag;
    }

    public void setShouldTag(Boolean shouldTag) {
        isSet.add("shouldTag");
        this.shouldTag = shouldTag;
    }

    @JsonIgnore
    public boolean isShouldTagSet() {
        return isSet.contains("shouldTag");
    }

}
