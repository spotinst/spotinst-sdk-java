package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

//Headroom class is used in launch specification and cluster classes
public class ApiClusterHeadroomsSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private Integer     cpuPerUnit;
    private Integer     memoryPerUnit;
    private Integer     numOfUnits;

    public ApiClusterHeadroomsSpecification() {
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
