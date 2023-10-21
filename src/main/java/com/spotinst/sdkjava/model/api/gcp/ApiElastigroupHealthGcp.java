package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.gcp.GcpElastigroupHealthCheckTypeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupHealthGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>             isSet;
    private Boolean                 autoHealing;
    private Integer                 gracePeriod;
    private GcpElastigroupHealthCheckTypeEnum healthCheckType;
    private Integer                 unhealthyDuration;

    public ApiElastigroupHealthGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getAutoHealing() {
        return autoHealing;
    }

    public void setAutoHealing(Boolean autoHealing) {
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

    public GcpElastigroupHealthCheckTypeEnum getHealthCheckType() {
        return healthCheckType;
    }

    public void setHealthCheckType(GcpElastigroupHealthCheckTypeEnum healthCheckType) {
        isSet.add("healthCheckType");
        this.healthCheckType = healthCheckType;
    }

    public Integer getUnhealthyDuration() {
        return unhealthyDuration;
    }

    public void setUnhealthyDuration(Integer unhealthyDuration) {
        isSet.add("unhealthyDuration");
        this.unhealthyDuration = unhealthyDuration;
    }

    @JsonIgnore
    public boolean isAutoHealingSet() { return isSet.contains("autoHealing"); }

    @JsonIgnore
    public boolean isGracePeriodSet() { return isSet.contains("gracePeriod"); }

    @JsonIgnore
    public boolean isHealthCheckTypeSet() { return isSet.contains("healthCheckType"); }

    @JsonIgnore
    public boolean isUnhealthyDurationSet() { return isSet.contains("unhealthyDuration"); }
}
