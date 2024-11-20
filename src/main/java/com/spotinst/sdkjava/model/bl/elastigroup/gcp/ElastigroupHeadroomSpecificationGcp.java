package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupHeadroomSpecificationGcp {

    @JsonIgnore
    private Set<String>     isSet;
    private Integer         cpuPerUnit;
    private Integer         memoryPerUnit;
    private Integer         numOfUnits;

    private ElastigroupHeadroomSpecificationGcp() {
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

    public Integer getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(Integer numOfUnits) {
        isSet.add("numOfUnits");
        this.numOfUnits = numOfUnits;
    }

    public static class Builder {
        private ElastigroupHeadroomSpecificationGcp headroom;

        private Builder() {
            this.headroom = new ElastigroupHeadroomSpecificationGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCpuPerUnit(final Integer cpuPerUnit) {
            headroom.setCpuPerUnit(cpuPerUnit);
            return this;
        }

        public Builder setMemoryPerUnit(final Integer memoryPerUnit) {
            headroom.setMemoryPerUnit(memoryPerUnit);
            return this;
        }

        public Builder setNumOfUnits(final Integer numOfUnits) {
            headroom.setNumOfUnits(numOfUnits);
            return this;
        }

        public ElastigroupHeadroomSpecificationGcp build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isCpuPerUnitSet() {return isSet.contains("cpuPerUnit");}

    @JsonIgnore
    public boolean isMemoryPerUnitSet() {return isSet.contains("memoryPerUnit");}

    @JsonIgnore
    public boolean isNumOfUnitsSet() {return isSet.contains("numOfUnits");}
}
