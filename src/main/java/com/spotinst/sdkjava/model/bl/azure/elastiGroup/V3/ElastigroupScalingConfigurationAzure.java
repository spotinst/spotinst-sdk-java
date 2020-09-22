package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ElastigroupScalingConfigurationAzure implements IPartialUpdateEntity {
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
