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
public class ApiEcsInitiateRollProgress implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                  isSet;
    private String                                        unit;
    private Integer                                      value;
    private ApiEcsInitiateRollDetailedStatus     detailedStatus;


    public ApiEcsInitiateRollProgress() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        isSet.add("value");
        this.value = value;
    }

    public ApiEcsInitiateRollDetailedStatus getDetailedStatus() {
        return detailedStatus;
    }

    public void setDetailedStatus(ApiEcsInitiateRollDetailedStatus detailedStatus) {
        isSet.add("detailedStatus");
        this.detailedStatus = detailedStatus;
    }

    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }

    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }

    @JsonIgnore
    public boolean isDetailedStatusSet() {
        return isSet.contains("detailedStatus");
    }
}