package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeHealthConfiguration {
    @JsonIgnore
    private Set<String>  isSet;
    private String       autoHealing;
    private Integer      gracePeriod;
    private List<String> healthCheckTypes;
    private Integer      unhealthyDuration;

    private StatefulNodeHealthConfiguration() {
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

    public static class Builder {
        private StatefulNodeHealthConfiguration compute;

        private Builder() {
            this.compute = new StatefulNodeHealthConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAutoHealing(final String autoHealing) {
            compute.setAutoHealing(autoHealing);
            return this;
        }

        public Builder setHealthCheckTypes(final List<String> healthCheckTypes) {
            compute.setHealthCheckTypes(healthCheckTypes);
            return this;
        }

        public Builder setGracePeriod(final Integer gracePeriod) {
            compute.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder setUnhealthyDuration(final Integer unhealthyDuration) {
            compute.setUnhealthyDuration(unhealthyDuration);
            return this;
        }

        public StatefulNodeHealthConfiguration build() {
            return compute;
        }
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