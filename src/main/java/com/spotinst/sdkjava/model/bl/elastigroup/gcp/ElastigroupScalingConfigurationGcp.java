package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScalingConfigurationGcp {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ElastigroupScalingPolicyGcp>   up;
    private List<ElastigroupScalingPolicyGcp>   down;

    private ElastigroupScalingConfigurationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupScalingPolicyGcp> getUp() {
        return up;
    }

    public void setUp(List<ElastigroupScalingPolicyGcp> up) {
        isSet.add("up");
        this.up = up;
    }

    public List<ElastigroupScalingPolicyGcp> getDown() {
        return down;
    }

    public void setDown(List<ElastigroupScalingPolicyGcp> down) {
        isSet.add("down");
        this.down = down;
    }

    public static class Builder {
        private ElastigroupScalingConfigurationGcp elastigroupScalingConfiguration;

        private Builder() {
            this.elastigroupScalingConfiguration = new ElastigroupScalingConfigurationGcp();
        }

        public static Builder get(){
            return new Builder();
        }

        public Builder setDown(final List<ElastigroupScalingPolicyGcp> downScalingPolicies) {
            elastigroupScalingConfiguration.setDown(downScalingPolicies);
            return this;
        }

        public Builder setUp(final List<ElastigroupScalingPolicyGcp> upScalingPolicies) {
            elastigroupScalingConfiguration.setUp(upScalingPolicies);
            return this;
        }

        public ElastigroupScalingConfigurationGcp build() {
            return elastigroupScalingConfiguration;
        }
    }

    @JsonIgnore
    public boolean isUpSet() {
        return isSet.contains("up");
    }

    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

}
