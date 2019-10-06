package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupHeadroomSpecification {
    //region Members
    @JsonIgnore
    private Set<String>     isSet;
    private Integer         cpuPerUnit;
    private Integer         memoryPerUnit;
    private Integer         numOfUnits;
    //endregion

    //region Constructor

    private ElastigroupHeadroomSpecification() {
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

    public Integer getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(Integer numOfUnits) {
        isSet.add("numOfUnits");
        this.numOfUnits = numOfUnits;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupHeadroomSpecification headroom;

        private Builder() {
            this.headroom = new ElastigroupHeadroomSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCpuPerUnit(final Integer cpuPerUnit) {
            headroom.setCpuPerUnit(cpuPerUnit);
            return this;
        }

        public Builder setMemoryPerUnit(final Integer memoryPerUnit) {
            headroom.setCpuPerUnit(memoryPerUnit);
            return this;
        }

        public Builder setNumOfUnits(final Integer numOfUnits) {
            headroom.setCpuPerUnit(numOfUnits);
            return this;
        }

        public ElastigroupHeadroomSpecification build() {
            return headroom;
        }
    }
    //endregion
    //region isSet methods
    // Is cpuPerUnit Set boolean method
    @JsonIgnore
    public boolean isCpuPerUnitSet() {return isSet.contains("cpuPerUnit");}

    // Is memoryPerUnit Set boolean method
    @JsonIgnore
    public boolean isMemoryPerUnitSet() {return isSet.contains("memoryPerUnit");}

    // Is numOfUnits Set boolean method
    @JsonIgnore
    public boolean isNumOfUnitsSet() {return isSet.contains("numOfUnits");}

    //endregion

}
