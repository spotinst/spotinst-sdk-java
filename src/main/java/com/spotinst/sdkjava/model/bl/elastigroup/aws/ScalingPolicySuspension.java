package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScalingPolicySuspension {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     ttlInMinutes;

    private ScalingPolicySuspension() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getTtlInMinutes() {
        return ttlInMinutes;
    }

    public void setTtlInMinutes(Integer ttlInMinutes) {
        isSet.add("ttlInMinutes");
        this.ttlInMinutes = ttlInMinutes;
    }

    public static class Builder {
        private ScalingPolicySuspension suspension;

        private Builder() {
            this.suspension = new ScalingPolicySuspension();
        }

        public static ScalingPolicySuspension.Builder get() {
            return new Builder();
        }

        public ScalingPolicySuspension.Builder setTtlInMinutes(final Integer ttlInMinutes) {
            suspension.setTtlInMinutes(ttlInMinutes);
            return this;
        }

        public ScalingPolicySuspension build() {
            return suspension;
        }
    }

    @JsonIgnore
    public boolean isTtlInMinutesSet() {
        return isSet.contains("ttlInMinutes");
    }
}
