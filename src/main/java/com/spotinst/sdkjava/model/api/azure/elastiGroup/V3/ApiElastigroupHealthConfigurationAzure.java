package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupHealthConfigurationAzure implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;

    private boolean autoHealing;
    private String  healthCheckTypes;
    private Integer gracePeriod;
    private Integer unhealthyDuration;

    //region Constructor

    public ApiElastigroupHealthConfigurationAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public boolean getAutoHealing() {
        return autoHealing;
    }

    public void setAutoHealing(boolean autoHealing) {
        isSet.add("autoHealing");
        this.autoHealing = autoHealing;
    }

    public String getHealthCheckTypes() {
        return healthCheckTypes;
    }

    public void setHealthCheckTypes(String healthCheckTypes) {
        isSet.add("healthCheckTypes");
        this.healthCheckTypes = healthCheckTypes;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }



    public Integer getUnhealthyDuration() {
        return unhealthyDuration;
    }

    public void setUnhealthyDuration(Integer unhealthyDuration) {
        isSet.add("unhealthyDuration");
        this.unhealthyDuration = unhealthyDuration;
    }

    //endregion

    //region isSet methods

    // Is autoHealing Set boolean method
    @JsonIgnore
    public boolean isAutoHealingSet() {
        return isSet.contains("autoHealing");
    }

    // Is healthCheckTypes Set boolean method
    @JsonIgnore
    public boolean isHealthCheckTypesSet() {
        return isSet.contains("healthCheckTypes");
    }

    // Is gracePeriod Set boolean method
    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    // Is unhealthyDuration Set boolean method
    @JsonIgnore
    public boolean isUnhealthyDurationSet() {
        return isSet.contains("unhealthyDuration");
    }
    //endregion
}
