package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment;

import com.spotinst.sdkjava.enums.UnitEnum;

public class DeploymentProgressIndicatorAzure {
    //region Members
    private UnitEnum unit;
    private Float    value;
    //endregion

    //region Getters and Setters
    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
    //endregion
}
