package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthCheck {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     autoHealing;
    private Integer     gracePeriod;
    private String      type;
    private Integer     unhealthyDuration;

    private HealthCheck() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public Integer getUnhealthyDuration() {
        return unhealthyDuration;
    }

    public void setUnhealthyDuration(Integer unhealthyDuration) {
        isSet.add("unhealthyDuration");
        this.unhealthyDuration = unhealthyDuration;
    }

    public static class Builder {
        private HealthCheck healthCheck;

        private Builder() {
            this.healthCheck = new HealthCheck();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAutoHealing(final Boolean autoHealing) {
            healthCheck.setAutoHealing(autoHealing);
            return this;
        }

        public Builder setGracePeriod(final Integer gracePeriod) {
            healthCheck.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder setType(final String type) {
            healthCheck.setType(type);
            return this;
        }

        public Builder setUnhealthyDuration(final Integer unhealthyDuration) {
            healthCheck.setUnhealthyDuration(unhealthyDuration);
            return this;
        }

        public HealthCheck build() {
            return healthCheck;
        }
    }

    @JsonIgnore
    public boolean isAutoHealingSet() {
        return isSet.contains("autoHealing");
    }

    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @JsonIgnore
    public boolean isUnhealthyDurationSet() {
        return isSet.contains("unhealthyDuration");
    }

}
