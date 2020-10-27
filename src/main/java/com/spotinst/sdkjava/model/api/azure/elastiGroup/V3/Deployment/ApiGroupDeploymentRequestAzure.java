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
public class ApiGroupDeploymentRequestAzure implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String>  isSet;
    private Integer      batchSizePercentage;
    private Integer      gracePeriod;
    private Integer      batchMinHealthyPercentage;
    private Integer      drainingTimeout;
    private List<String> healthCheckTypes;
    //endregion

    //region constructor
    public ApiGroupDeploymentRequestAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public Integer getBatchSizePercentage() {
        return batchSizePercentage;
    }

    public void setBatchSizePercentage(Integer batchSizePercentage) {
        this.batchSizePercentage = batchSizePercentage;
        touch("batchSizePercentage");
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
        touch("gracePeriod");
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

    public List<String> getHealthCheckTypes() {
        return healthCheckTypes;
    }

    public void setHealthCheckTypes(List<String> healthCheckTypes) {
        this.healthCheckTypes = healthCheckTypes;
        touch("healthCheckTypes");
    }
    //endregion


    //region isSet methods
    public Boolean isHealthCheckTypesSet() {
        return this.isSet.contains("healthCheckTypes");
    }

    public Boolean isDrainingTimeoutSet() {
        return this.isSet.contains("drainingTimeout");
    }

    public Boolean isBatchMinHealthyPercentageSet() {
        return this.isSet.contains("batchMinHealthyPercentage");
    }

    public Boolean isBatchSizePercentageSet() {
        return this.isSet.contains("batchSizePercentage");
    }

    public Boolean isGracePeriodSet() {
        return this.isSet.contains("gracePeriod");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
