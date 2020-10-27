package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGroupDeploymentStrategyAzure implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> healthCheckTypes;
    private Integer      batchMinHealthyPercentage;
    private Integer      drainingTimeout;
    private Integer      gracePeriod;
    //endregion

    // region constructor
    public ApiGroupDeploymentStrategyAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public List<String> getHealthCheckTypes() {
        return healthCheckTypes;
    }

    public void setHealthCheckTypes(List<String> healthCheckTypes) {
        this.healthCheckTypes = healthCheckTypes;
        touch("healthCheckTypes");
    }

    public Integer getBatchMinHealthyPercentage() {
        return batchMinHealthyPercentage;
    }

    public void setBatchMinHealthyPercentage(Integer batchMinHealthyPercentage) {
        this.batchMinHealthyPercentage = batchMinHealthyPercentage;
        touch("batchMinHealthyPercentage");
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        this.drainingTimeout = drainingTimeout;
        touch("drainingTimeout");
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
        touch("gracePeriod");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
