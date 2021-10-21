package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecHeadroomsSpecification {
    @JsonIgnore
    private Set<String>     isSet;
     private Integer        cpuPerUnit;
     private Integer        memoryPerUnit;
     private Integer        gpuPerUnit;
     private Integer        numOfUnits;

    public LaunchSpecHeadroomsSpecification(){ isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getCpuPerUnit(){
        return cpuPerUnit;
    }

    public void setCpuPerUnit(Integer cpuPerUnit){
        isSet.add("cpuPerUnit");
        this.cpuPerUnit = cpuPerUnit;
    }

    public Integer getMemoryPerUnit(){
        return memoryPerUnit;
    }

    public void setMemoryPerUnit(Integer memoryPerUnit){
        isSet.add("memoryPerUnit");
        this.memoryPerUnit = memoryPerUnit;
    }

    public Integer getGpuPerUnit(){
        return gpuPerUnit;
    }

    public void setGpuPerUnit(Integer gpuPerUnit){
        isSet.add("gpuPerUnit");
        this.gpuPerUnit = gpuPerUnit;
    }

    public Integer getNumOfUnits(){
        return numOfUnits;
    }

    public void setNumOfUnits(Integer numOfUnits){
        isSet.add("numOfUnits");
        this.numOfUnits = numOfUnits;
    }

    public static class Builder {
        private LaunchSpecHeadroomsSpecification gkeHeadRooms;

        private Builder() {
            this.gkeHeadRooms = new LaunchSpecHeadroomsSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCpuPerUnit(final Integer cpuPerUnit){
            gkeHeadRooms.setCpuPerUnit(cpuPerUnit);
            return this;
        }

        public Builder setMemoryPerUnit(final Integer memoryPerUnit) {
            gkeHeadRooms.setMemoryPerUnit(memoryPerUnit);
            return this;
        }
        public Builder setGpuPerUnit(final Integer gpuPerUnit) {
            gkeHeadRooms.setGpuPerUnit(gpuPerUnit);
            return this;
        }

        public Builder setNumOfUnits(final Integer numOfUnits) {
            gkeHeadRooms.setNumOfUnits(numOfUnits);
            return this;
        }
        public LaunchSpecHeadroomsSpecification build() {
            return gkeHeadRooms;
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
    public boolean isGpuPerUnitSet() {
        return isSet.contains("gpuPerUnit");
    }

    @JsonIgnore
    public boolean isNumOfUnitsSet() {
        return isSet.contains("numOfUnits");
    }
}
