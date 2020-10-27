package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;

public class ApiDeploymentProgressIndicatorAzure {
    //region Members
    private String unit;
    private Float  value;
    //endregion

    //region Getters and Setters
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
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
