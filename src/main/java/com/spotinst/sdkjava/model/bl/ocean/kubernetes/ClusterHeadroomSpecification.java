package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterHeadroomSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     cpuPerUnit;
    private Integer     memoryPerUnit;
    private Integer     gpuPerUnit;
    private Integer     numOfUnits;

    private ClusterHeadroomSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getCpuPerUnit() {
        return cpuPerUnit;
    }

    public void setCpuPerUnit(Integer cpuPerUnit) {
        isSet.add("cpuPerUnit");
        this.cpuPerUnit = cpuPerUnit;
    }

    public Integer getMemoryPerUnit() {
        return memoryPerUnit;
    }

    public void setMemoryPerUnit(Integer memoryPerUnit) {
        isSet.add("memoryPerUnit");
        this.memoryPerUnit = memoryPerUnit;
    }

    public Integer getGpuPerUnit() {
        return gpuPerUnit;
    }

    public void setGpuPerUnit(Integer gpuPerUnit) {
        isSet.add("gpuPerUnit");
        this.gpuPerUnit = gpuPerUnit;
    }

    public Integer getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(Integer numOfUnits) {
        isSet.add("numOfUnits");
        this.numOfUnits = numOfUnits;
    }

    public static class Builder {
        private ClusterHeadroomSpecification headroom;

        private Builder() {
            this.headroom = new ClusterHeadroomSpecification();
        }

        public static ClusterHeadroomSpecification.Builder get() {
            ClusterHeadroomSpecification.Builder builder = new ClusterHeadroomSpecification.Builder();
            return builder;
        }

        public ClusterHeadroomSpecification.Builder setCpuPerUnit(final Integer cpuPerUnit) {
            headroom.setCpuPerUnit(cpuPerUnit);
            return this;
        }

        public ClusterHeadroomSpecification.Builder setMemoryPerUnit(final Integer memoryPerUnit) {
            headroom.setMemoryPerUnit(memoryPerUnit);
            return this;
        }

        public ClusterHeadroomSpecification.Builder setGpuPerUnit(final Integer gpuPerUnit) {
            headroom.setMemoryPerUnit(gpuPerUnit);
            return this;
        }

        public ClusterHeadroomSpecification.Builder setNumOfUnits(final Integer numOfUnits) {
            headroom.setNumOfUnits(numOfUnits);
            return this;
        }

        public ClusterHeadroomSpecification build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isCpuPerUnitSet() {return isSet.contains("cpuPerUnit");}

    @JsonIgnore
    public boolean isMemoryPerUnitSet() {return isSet.contains("memoryPerUnit");}

    @JsonIgnore
    public boolean isGpuPerUnitSet() {return isSet.contains("gpuPerUnit");}

    @JsonIgnore
    public boolean isNumOfUnitsSet() {return isSet.contains("numOfUnits");}

}
