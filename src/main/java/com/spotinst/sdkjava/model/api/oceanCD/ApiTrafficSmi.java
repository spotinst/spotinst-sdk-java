package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiTrafficSmi implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     rootService;
    private String                     trafficSplitName;

    public ApiTrafficSmi() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getRootService() {
        return rootService;
    }

    public void setRootService(String rootService) {
        isSet.add("rootService");
        this.rootService = rootService;
    }

    public String getTrafficSplitName() {
        return trafficSplitName;
    }

    public void setTrafficSplitName(String trafficSplitName) {
        isSet.add("trafficSplitName");
        this.trafficSplitName = trafficSplitName;
    }

    @JsonIgnore
    public boolean isRootServiceSet() {
        return isSet.contains("rootService");
    }

    @JsonIgnore
    public boolean isTrafficSplitNameSet() {
        return isSet.contains("trafficSplitName");
    }
}