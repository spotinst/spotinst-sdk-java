package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.MultipleMetrics;

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
    private List<ScalingPolicy> target;
    private List<MultipleMetrics> multipleMetrics;
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

    //region Target
    public List<ScalingPolicy> getTarget() {
        return target;
    }

    public void setTarget(List<ScalingPolicy> target) {
        isSet.add("target");
        this.target = target;
    }

    public List<MultipleMetrics> getMultipleMetrics() {
        return multipleMetrics;
    }

    public void setMultipleMetrics(List<MultipleMetrics> multipleMetrics) {
        isSet.add("multipleMetrics");
        this.multipleMetrics = multipleMetrics;
    }

    //endregion

    //endregion

    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElastigroupScalingConfiguration elastigroupScalingConfiguration = (ElastigroupScalingConfiguration) o;

        if (!Objects.equals(up, elastigroupScalingConfiguration.up)) return false;
        if (!Objects.equals(down, elastigroupScalingConfiguration.down)) return false;
        return !(!Objects.equals(target, elastigroupScalingConfiguration.target));

    }

    @Override
    public int hashCode() {
        int result = up != null ? up.hashCode() : 0;
        result = 31 * result + (down != null ? down.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
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
            return new Builder();
        }

        public Builder setDown(final List<ScalingPolicy> downScalingPolicies) {
            elastigroupScalingConfiguration.setDown(downScalingPolicies);
            return this;
        }

        public Builder setUp(final List<ScalingPolicy> upScalingPolicies) {
            elastigroupScalingConfiguration.setUp(upScalingPolicies);
            return this;
        }

        public Builder setTarget(final List<ScalingPolicy> targetScalingPolicies) {
            elastigroupScalingConfiguration.setTarget(targetScalingPolicies);
            return this;
        }

        public Builder setMultipleMetrics(final List<MultipleMetrics> multipleMetrics) {
            elastigroupScalingConfiguration.setMultipleMetrics(multipleMetrics);
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

    // Is target Set boolean method
    @JsonIgnore
    public boolean isTargetSet() {
        return isSet.contains("target");
    }

    // Is multipleMetrics Set boolean method
    @JsonIgnore
    public boolean isMultipleMetricsSet() {
        return isSet.contains("multipleMetrics");
    }

    //endregion
}
