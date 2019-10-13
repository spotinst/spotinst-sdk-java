package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiHeadroom implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     cpuPerUnit;
    private Integer     memoryPerUnit;
    private Integer     numOfUnits;
    //endregion

    //region Constructor
    public ApiHeadroom() {
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

    //todo sali - why no one use - done
    public Integer getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(Integer numOfUnits) {
        isSet.add("numOfUnits");
        this.numOfUnits = numOfUnits;
    }

    //endregion
    //region isSet methods
    // Is cpuPerUnit Set boolean method
    @JsonIgnore
    public boolean isCpuPerUnitSet() {
        return isSet.contains("cpuPerUnit");
    }

    // Is memoryPerUnit Set boolean method
    @JsonIgnore
    public boolean isMemoryPerUnitSet() {
        return isSet.contains("memoryPerUnit");
    }

    // Is numOfUnits Set boolean method
    @JsonIgnore
    public boolean isNumOfUnitsSet() {
        return isSet.contains("numOfUnits");
    }

    //endregion
}
