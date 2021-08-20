package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiK8sVngElasticIpPool {

    @JsonIgnore
    private Set<String>                 isSet;
    private ApiK8sVngTagSelector  tagSelector;

    public ApiK8sVngElasticIpPool() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiK8sVngTagSelector getTagSelector() {
        return tagSelector;
    }

    public void setTagSelector(ApiK8sVngTagSelector tagSelector) {
        isSet.add("tagSelector");
        this.tagSelector = tagSelector;
    }

    @JsonIgnore
    public boolean isTagSelectorSet() {
        return isSet.contains("tagSelector");
    }
}