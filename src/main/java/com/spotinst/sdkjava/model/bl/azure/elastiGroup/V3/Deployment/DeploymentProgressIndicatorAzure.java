package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AzureUnitEnum;

import java.util.HashSet;
import java.util.Set;

public class DeploymentProgressIndicatorAzure {
    //region Members
    @JsonIgnore
    private Set<String>   isSet;
    private AzureUnitEnum unit;
    private Float         value;
    //endregion

    //region constructor
    public DeploymentProgressIndicatorAzure() {
        isSet = new HashSet<>();
    }
    //endreigon

    //region Getters and Setters
    public AzureUnitEnum getUnit() {
        return unit;
    }

    public void setUnit(AzureUnitEnum unit) {
        this.unit = unit;
        touch("unit");
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
        touch("value");
    }
    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isUnitSet() {
        return this.isSet.contains("unit");
    }
    @JsonIgnore
    public Boolean isValueSet() {
        return this.isSet.contains("value");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
