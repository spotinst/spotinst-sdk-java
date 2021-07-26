package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKEHeadRooms;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKEHeadRooms {

    private int         cpuPerUnit;
    private int         memoryPerUnit;
    private int         gpuPerUnit;
    private int         numOfUnits;
    private Set<String> isSet;

    private ApiOceanGKEHeadRooms(){isSet = new HashSet<>();
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
        private ApiOceanGKEHeadRooms apiGkeHeadRooms;

        private Builder() {
            this.apiGkeHeadRooms = new ApiOceanGKEHeadRooms();
        }

        public static ApiOceanGKEHeadRooms.Builder get() {
            ApiOceanGKEHeadRooms.Builder builder = new ApiOceanGKEHeadRooms.Builder();
            return builder;
        }

        public ApiOceanGKEHeadRooms.Builder setCpuPerUnit(final int cpuPerUnit) {
            apiGkeHeadRooms.setCpuPerUnit(cpuPerUnit);
            return this;
        }

        public ApiOceanGKEHeadRooms.Builder setMemoryPerUnit(final int memoryPerUnit) {
            apiGkeHeadRooms.setMemoryPerUnit(memoryPerUnit);
            return this;
        }
        public ApiOceanGKEHeadRooms.Builder setGpuPerUnit(final int gpuPerUnit) {
            apiGkeHeadRooms.setGpuPerUnit(gpuPerUnit);
            return this;
        }

        public ApiOceanGKEHeadRooms.Builder setNumOfUnits(final int numOfUnits) {
            apiGkeHeadRooms.setNumOfUnits(numOfUnits);
            return this;
        }
        public ApiOceanGKEHeadRooms build() {
            return apiGkeHeadRooms;
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
