package com.spotinst.sdkjava.model.bl.gcp;

public class OceanGKEHeadRooms {
     private String cpuPerUnit;
     private String memoryPerUnit;
     private String gpuPerUnit;
     private String numOfUnits;

    public String getCpuPerUnit(){
        return cpuPerUnit;
    }

    public void setCpuPerUnit(String cpuPerUnit){
        this.cpuPerUnit = cpuPerUnit;
    }

    public String getMemoryPerUnit(){
        return cpuPerUnit;
    }

    public void setMemoryPerUnit(String memoryPerUnit){
        this.memoryPerUnit = memoryPerUnit;
    }

    public String getGpuPerUnit(){
        return gpuPerUnit;
    }

    public void setGpuPerUnit(String gpuPerUnit){
        this.gpuPerUnit = gpuPerUnit;
    }

    public String getNumOfUnits(){
        return numOfUnits;
    }

    public void setNumOfUnits(String numOfUnits){
        this.numOfUnits = numOfUnits;
    }
}
