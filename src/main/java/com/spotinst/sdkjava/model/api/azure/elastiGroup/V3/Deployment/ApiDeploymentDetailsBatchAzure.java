package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import java.util.List;

public class ApiDeploymentDetailsBatchAzure {
    //region members
    private Integer                           batch;
    private List<ApiDeploymentDetailsVmAzure> blue;
    private List<ApiDeploymentDetailsVmAzure> green;
    //endregion

    //region getters & setters
    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public List<ApiDeploymentDetailsVmAzure> getBlue() {
        return blue;
    }

    public void setBlue(List<ApiDeploymentDetailsVmAzure> blue) {
        this.blue = blue;
    }

    public List<ApiDeploymentDetailsVmAzure> getGreen() {
        return green;
    }

    public void setGreen(List<ApiDeploymentDetailsVmAzure> green) {
        this.green = green;
    }
    //endregion
}
