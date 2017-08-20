package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

/**
 * Created by aharontwizer on 8/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElastigroupScalingConfiguration {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private List<ScalingPolicy> up;
    private List<ScalingPolicy> down;
    //endregion

    //region Constructor

    private ElastigroupScalingConfiguration() {
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
    public List<ScalingPolicy> getUp() {
        return up;
    }

    public void setUp(List<ScalingPolicy> up) {
        isSet.add("up");
        this.up = up;
    }

    //endregion

    //region Down
    public List<ScalingPolicy> getDown() {
        return down;
    }

    public void setDown(List<ScalingPolicy> down) {
        isSet.add("down");
        this.down = down;
    }

    //endregion

    //endregion

    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElastigroupScalingConfiguration elastigroupScalingConfiguration = (ElastigroupScalingConfiguration) o;

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
        private ElastigroupScalingConfiguration elastigroupScalingConfiguration;

        private Builder() {
            this.elastigroupScalingConfiguration = new ElastigroupScalingConfiguration();
        }

        public static Builder get(){
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDown(final List<ScalingPolicy> downScalingPolicies) {
            elastigroupScalingConfiguration.setDown(downScalingPolicies);
            return this;
        }

        public Builder setUp(final List<ScalingPolicy> upScalingPolicies) {
            elastigroupScalingConfiguration.setUp(upScalingPolicies);
            return this;
        }

        public ElastigroupScalingConfiguration build() {
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
