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
public class ApiIstioDestinationRule implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     name;
    private String                     canarySubsetName;
    private String                     stableSubsetName;

    public ApiIstioDestinationRule() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getCanarySubsetName() {
        return canarySubsetName;
    }

    public void setCanarySubsetName(String canarySubsetName) {
        isSet.add("canarySubsetName");
        this.canarySubsetName = canarySubsetName;
    }

    public String getStableSubsetName() {
        return stableSubsetName;
    }

    public void setStableSubsetName(String stableSubsetName) {
        isSet.add("stableSubsetName");
        this.stableSubsetName = stableSubsetName;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isCanarySubsetNameSet() {
        return isSet.contains("canarySubsetName");
    }

    @JsonIgnore
    public boolean isStableSubsetNameSet() {
        return isSet.contains("stableSubsetName");
    }
}