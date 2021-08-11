package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class HealthCheck {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     autoHealing;
    private Integer     gracePeriod;
    private String      type;
    private Integer     unhealthyDuration;

    //endregion

    //region constructor
    private HealthCheck() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

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
    //endregion

    //region Builder class
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
            // TODO : Validations
            return healthCheck;
        }
    }
    //endregion

    //region isSet methods
    // Is autoHealing Set boolean method
    @JsonIgnore
    public boolean isAutoHealingSet() {
        return isSet.contains("autoHealing");
    }

    // Is gracePeriod Set boolean method
    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    // Is type Set boolean method
    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    // Is unhealthyDuration Set boolean method
    @JsonIgnore
    public boolean isUnhealthyDurationSet() {
        return isSet.contains("unhealthyDuration");
    }

    //endregion
}
