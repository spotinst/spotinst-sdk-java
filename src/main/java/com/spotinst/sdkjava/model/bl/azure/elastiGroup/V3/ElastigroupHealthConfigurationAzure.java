package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupHealthConfigurationAzure {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean autoHealing;
    private String  healthCheckTypes;
    private Integer gracePeriod;
    private Integer unhealthyDuration;
    //endregion

    //region Constructor
    private ElastigroupHealthConfigurationAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods
    public Set<String> getIsSet() {
        return isSet;
    }

    public Boolean getAutoHealing() {
        return autoHealing;
    }

    public void setAutoHealing(Boolean autoHealing) {
        isSet.add("autoHealing");
        this.autoHealing = autoHealing;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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

    //region Builder class
    public static class Builder {
        private ElastigroupHealthConfigurationAzure capacity;
        private Builder() {
            this.capacity = new ElastigroupHealthConfigurationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setHealthCheckTypes(final String healthCheckTypes) {
            capacity.setHealthCheckTypes(healthCheckTypes);
            return this;
        }

        public Builder setAutoHealing(final Boolean autoHealing) {
            capacity.setAutoHealing(autoHealing);
            return this;
        }
        public Builder setGracePeriod(final Integer gracePeriod) {
            capacity.setGracePeriod(gracePeriod);
            return this;
        }

        public Builder setUnhealthyDuration (final Integer unhealthyDuration) {
            capacity.setUnhealthyDuration(unhealthyDuration);
            return this;
        }

        public ElastigroupHealthConfigurationAzure build() {
            // TODO : Validations
            return capacity;
        }
    }
    //endregion

    //region isSet methods
    // Is healthCheckTypes Set boolean method
    @JsonIgnore
    public boolean isHealthCheckTypesSet() {
        return isSet.contains("healthCheckTypes");
    }

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

    // Is unhealthyDuration Set boolean method
    @JsonIgnore
    public boolean isUnhealthyDurationSet() {
        return isSet.contains("unhealthyDuration");
    }
    //endregion
}
