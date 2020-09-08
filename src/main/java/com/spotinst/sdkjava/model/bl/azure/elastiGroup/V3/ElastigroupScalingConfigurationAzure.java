package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElastigroupScalingConfigurationAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private List<ScalingPolicyAzure> up;
    private List<ScalingPolicyAzure> down;
    //endregion

    //region Constructor

    private ElastigroupScalingConfigurationAzure() {
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

    //region Up
    public List<ScalingPolicyAzure> getUp() {
        return up;
    }

    public void setUp(List<ScalingPolicyAzure> up) {
        isSet.add("up");
        this.up = up;
    }

    //endregion

    //region Down
    public List<ScalingPolicyAzure> getDown() {
        return down;
    }

    public void setDown(List<ScalingPolicyAzure> down) {
        isSet.add("down");
        this.down = down;
    }

    //endregion

    //endregion

    //TODO Itzik - delete?
    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElastigroupScalingConfigurationAzure elastigroupScalingConfiguration = (ElastigroupScalingConfigurationAzure) o;

        if (up != null ? !up.equals(elastigroupScalingConfiguration.up) : elastigroupScalingConfiguration.up != null) return false;
        return !(down != null ? !down.equals(elastigroupScalingConfiguration.down) : elastigroupScalingConfiguration.down != null);

    }

    @Override
    public int hashCode() {
        int result = up != null ? up.hashCode() : 0;
        result = 31 * result + (down != null ? down.hashCode() : 0);
        return result;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupScalingConfigurationAzure elastigroupScalingConfiguration;

        private Builder() {
            this.elastigroupScalingConfiguration = new ElastigroupScalingConfigurationAzure();
        }

        public static Builder get(){
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDown(final List<ScalingPolicyAzure> downScalingPolicies) {
            elastigroupScalingConfiguration.setDown(downScalingPolicies);
            return this;
        }

        public Builder setUp(final List<ScalingPolicyAzure> upScalingPolicies) {
            elastigroupScalingConfiguration.setUp(upScalingPolicies);
            return this;
        }

        public ElastigroupScalingConfigurationAzure build() {
            // TODO : Validations
            return elastigroupScalingConfiguration;
        }
    }
    //endregion
    //region isSet methods
    // Is up Set boolean method
    @JsonIgnore
    public boolean isUpSet() {
        return isSet.contains("up");
    }

    // Is down Set boolean method
    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

    //endregion
}
