package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiLaunchSpecHeadRoomsSpecification {

    private Integer         cpuPerUnit;
    private Integer         memoryPerUnit;
    private Integer         gpuPerUnit;
    private Integer         numOfUnits;
    private Set<String> isSet;

    public ApiLaunchSpecHeadRoomsSpecification(){ isSet = new HashSet<>();
    }
    public Integer getCpuPerUnit(){
        return cpuPerUnit;
    }

    public void setCpuPerUnit(Integer cpuPerUnit){
        isSet.add("cpuPerUnit");
        this.cpuPerUnit = cpuPerUnit;
    }

    public Integer getMemoryPerUnit(){
        return cpuPerUnit;
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
