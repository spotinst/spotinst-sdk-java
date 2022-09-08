package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ImportClusterResourceLimitsSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     maxMemoryGib;
    private Integer     maxVCpu;


    private ImportClusterResourceLimitsSpecification() {
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
        private ImportClusterResourceLimitsSpecification resourceLimits;

        private Builder() {
            this.resourceLimits = new ImportClusterResourceLimitsSpecification();
        }

        public static ImportClusterResourceLimitsSpecification.Builder get() {
            return new Builder();
        }

        public ImportClusterResourceLimitsSpecification.Builder setMaxMemoryGib(final Integer maxMemoryGib) {
            resourceLimits.setMaxMemoryGib(maxMemoryGib);
            return this;
        }

        public ImportClusterResourceLimitsSpecification.Builder setMaxVCpu(final Integer maxVCpu) {
            resourceLimits.setMaxVCpu(maxVCpu);
            return this;
        }

        public ImportClusterResourceLimitsSpecification build() {
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
