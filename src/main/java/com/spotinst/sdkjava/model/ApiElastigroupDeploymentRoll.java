package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.*;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiElastigroupDeploymentRoll implements IPartialUpdateEntity {
    @JsonProperty("roll")
    private Set<String>           isSet;
    private String                status;

    public ApiElastigroupDeploymentRoll() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) { this.isSet = isSet;  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    @JsonIgnore
    public boolean isStatusSet() { return isSet.contains("status"); }

}