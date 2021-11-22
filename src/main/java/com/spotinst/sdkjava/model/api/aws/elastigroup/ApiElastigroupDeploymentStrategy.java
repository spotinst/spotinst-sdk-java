package com.spotinst.sdkjava.model.api.aws.elastigroup;

import com.fasterxml.jackson.annotation.*;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiElastigroupDeploymentStrategy implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private Integer                                   batchMinHealthyPercentage;
    private String                                    action;
    private ApiElastigroupDeploymentStrategyOnFailure onFailure;

    public ApiElastigroupDeploymentStrategy() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    public void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        isSet.add("batchMinHealthyPercentage");
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        isSet.add("action");
        this.action = action;
    }

    public ApiElastigroupDeploymentStrategyOnFailure getOnFailure() {
        return onFailure;
    }

    public void setOnFailure(ApiElastigroupDeploymentStrategyOnFailure onFailure) {
        isSet.add("onFailure");
        this.onFailure = onFailure;
    }


    @JsonIgnore
    public boolean isBatchMinHealthyPercentageSet() { return isSet.contains("batchMinHealthyPercentage"); }

    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }

    @JsonIgnore
    public boolean isOnFailureSet() {
        return isSet.contains("onFailure");
    }

}