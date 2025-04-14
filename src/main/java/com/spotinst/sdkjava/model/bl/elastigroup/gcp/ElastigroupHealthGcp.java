package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.gcp.GcpElastigroupHealthCheckTypeEnum;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupHealthGcp {

    @JsonIgnore
    private Set<String>             isSet;
    private Boolean                 autoHealing;
    private Integer                 gracePeriod;
    private GcpElastigroupHealthCheckTypeEnum healthCheckType;
    private Integer                 unhealthyDuration;

    private ElastigroupHealthGcp() {
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

    public static class Builder {
        private ElastigroupHealthGcp health;

        private Builder() {
            this.health = new ElastigroupHealthGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAutoHealing(final Boolean autoHealing) {
            health.setAutoHealing(autoHealing);
            return this;
        }

        public Builder setGracePeriod(final Integer gracePeriod) {
            health.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder setHealthCheckType(final GcpElastigroupHealthCheckTypeEnum healthCheckType) {
            health.setHealthCheckType(healthCheckType);
            return this;
        }

        public Builder setUnhealthyDuration(final Integer unhealthyDuration) {
            health.setUnhealthyDuration(unhealthyDuration);
            return this;
        }

        public ElastigroupHealthGcp build() {
            return health;
        }
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
