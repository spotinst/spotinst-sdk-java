package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterHeadroomsSpecification {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     cpuPerUnit;
    private Integer     memoryPerUnit;
    private Integer     numOfUnits;

    private ClusterHeadroomsSpecification() {
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

    public Integer getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(Integer numOfUnits) {
        isSet.add("numOfUnits");
        this.numOfUnits = numOfUnits;
    }

    public Integer getMemoryPerUnit() {
        return memoryPerUnit;
    }

    public void setMemoryPerUnit(Integer memoryPerUnit) {
        isSet.add("memoryPerUnit");
        this.memoryPerUnit = memoryPerUnit;
    }

    public static class Builder {
        private ClusterHeadroomsSpecification headroomsSpecificationEcs;

        public Builder() {
            this.headroomsSpecificationEcs = new ClusterHeadroomsSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCpuPerUnit(Integer cpuPerUnit) {
            headroomsSpecificationEcs.setCpuPerUnit(cpuPerUnit);
            return this;
        }

        public Builder setMemoryPerUnit(Integer memoryPerUnit) {
            headroomsSpecificationEcs.setMemoryPerUnit(memoryPerUnit);
            return this;
        }

        public Builder setNumOfUnits(Integer numOfUnits) {
            headroomsSpecificationEcs.setNumOfUnits(numOfUnits);
            return this;
        }

        public ClusterHeadroomsSpecification build() {
            return headroomsSpecificationEcs;
        }
    }

    @JsonIgnore
    public boolean isCpuPerUnitSet() {
        return isSet.contains("cpuPerUnit");
    }

    @JsonIgnore
    public boolean isMemoryPerUnitSet() {
        return isSet.contains("memoryPerUnit");
    }

    @JsonIgnore
    public boolean isNumOfUnitsSet() {
        return isSet.contains("numOfUnits");
    }
}
