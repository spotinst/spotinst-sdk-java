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
public class ApiRolloutSpecFailurePolicy implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     action;

    public ApiRolloutSpecFailurePolicy() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        isSet.add("action");
        this.action = action;
    }

    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }
}