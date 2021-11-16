package com.spotinst.sdkjava.model.api.ocean.kubernetes;

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
public class ApiK8sVngElasticIpPool implements IPartialUpdateEntity {

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