package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterResourceLimitsSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     maxMemoryGib;
    private Integer     maxVCpu;

    private ClusterResourceLimitsSpecification() {
        isSet = new HashSet<>();
    }


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Integer getMaxMemoryGib() {
        return maxMemoryGib;
    }

    public void setMaxMemoryGib(Integer maxMemoryGib) {
        isSet.add("maxMemoryGib");
        this.maxMemoryGib = maxMemoryGib;
    }

    public Integer getMaxVCpu() {
        return maxVCpu;
    }

    public void setMaxVCpu(Integer maxVCpu) {
        isSet.add("maxCPU");
        this.maxVCpu = maxVCpu;
    }

    public static class Builder {
        private ClusterResourceLimitsSpecification resourceLimits;

        private Builder() {
            this.resourceLimits = new ClusterResourceLimitsSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMaxMemoryGib(final Integer maxMemoryGib) {
            resourceLimits.setMaxMemoryGib(maxMemoryGib);
            return this;
        }

        public Builder setMaxVCpu(final Integer maxVCpu) {
            resourceLimits.setMaxVCpu(maxVCpu);
            return this;
        }

        public ClusterResourceLimitsSpecification build() {
            return resourceLimits;
        }
    }

    @JsonIgnore
    public boolean isMaxMemoryGibSet() {
        return isSet.contains("maxMemoryGib");
    }

    @JsonIgnore
    public boolean isMaxVCpuSet() {
        return isSet.contains("maxVCpu");
    }

}
