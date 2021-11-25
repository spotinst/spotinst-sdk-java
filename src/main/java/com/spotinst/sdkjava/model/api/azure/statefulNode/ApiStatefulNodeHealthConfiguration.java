package com.spotinst.sdkjava.model.api.azure.statefulNode;

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
public class ApiStatefulNodeHealthConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>  isSet;
    private String       autoHealing;
    private Integer      gracePeriod;
    private List<String> healthCheckTypes;
    private Integer      unhealthyDuration;

    public ApiStatefulNodeHealthConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAutoHealing() {
        return autoHealing;
    }

    public void setAutoHealing(String autoHealing) {
        isSet.add("autoHealing");
        this.autoHealing = autoHealing;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }

    public List<String> getHealthCheckTypes() {
        return healthCheckTypes;
    }

    public void setHealthCheckTypes(List<String> healthCheckTypes) {
        isSet.add("healthCheckTypes");
        this.healthCheckTypes = healthCheckTypes;
    }

    public Integer getUnhealthyDuration() {
        return unhealthyDuration;
    }

    public void setUnhealthyDuration(Integer unhealthyDuration) {
        isSet.add("unhealthyDuration");
        this.unhealthyDuration = unhealthyDuration;
    }

    @JsonIgnore
    public boolean isAutoHealingSet() {
        return isSet.contains("autoHealing");
    }

    @JsonIgnore
    public boolean isHealthCheckTypesSet() {
        return isSet.contains("healthCheckTypes");
    }

    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    @JsonIgnore
    public boolean isUnhealthyDurationSet() {
        return isSet.contains("unhealthyDuration");
    }

}