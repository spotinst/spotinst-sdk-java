package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class OceanGKEHeadRooms {


     private int cpuPerUnit;
     private int memoryPerUnit;
     private int gpuPerUnit;
     private int numOfUnits;
    private Set<String> isSet;

    private OceanGKEHeadRooms(){isSet = new HashSet<>();
    }
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public int getCpuPerUnit(){
        return cpuPerUnit;
    }

    public void setCpuPerUnit(int cpuPerUnit){
        isSet.add("cpuPerUnit");
        this.cpuPerUnit = cpuPerUnit;
    }

    public int getMemoryPerUnit(){
        return cpuPerUnit;
    }

    public void setMemoryPerUnit(int memoryPerUnit){
        isSet.add("memoryPerUnit");
        this.memoryPerUnit = memoryPerUnit;
    }

    public int getGpuPerUnit(){
        return gpuPerUnit;
    }

    public void setGpuPerUnit(int gpuPerUnit){
        isSet.add("gpuPerUnit");
        this.gpuPerUnit = gpuPerUnit;
    }

    public int getNumOfUnits(){
        return numOfUnits;
    }

    public void setNumOfUnits(int numOfUnits){
        isSet.add("numOfUnits");
        this.numOfUnits = numOfUnits;
    }

    public static class Builder {
        private OceanGKEHeadRooms gkeHeadRooms;

        private Builder() {
            this.gkeHeadRooms = new OceanGKEHeadRooms();
        }

        public static OceanGKEHeadRooms.Builder get() {
            OceanGKEHeadRooms.Builder builder = new OceanGKEHeadRooms.Builder();
            return builder;
        }

        public OceanGKEHeadRooms.Builder setCpuPerUnit(final int cpuPerUnit) {
            gkeHeadRooms.setCpuPerUnit(cpuPerUnit);
            return this;
        }

        public OceanGKEHeadRooms.Builder setMemoryPerUnit(final int memoryPerUnit) {
            gkeHeadRooms.setMemoryPerUnit(memoryPerUnit);
            return this;
        }
        public OceanGKEHeadRooms.Builder setGpuPerUnit(final int gpuPerUnit) {
            gkeHeadRooms.setGpuPerUnit(gpuPerUnit);
            return this;
        }

        public OceanGKEHeadRooms.Builder setNumOfUnits(final int numOfUnits) {
            gkeHeadRooms.setNumOfUnits(numOfUnits);
            return this;
        }
        public OceanGKEHeadRooms build() {
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
