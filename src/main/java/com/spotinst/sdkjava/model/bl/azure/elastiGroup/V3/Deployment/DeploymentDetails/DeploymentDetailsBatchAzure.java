package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import java.util.List;

public class DeploymentDetailsBatchAzure {
    //region members
    private Integer                        batch;
    private List<DeploymentDetailsVmAzure> blue;
    private List<DeploymentDetailsVmAzure> green;
    //endregion

    //region getters & setters
    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public List<DeploymentDetailsVmAzure> getBlue() {
        return blue;
    }

    public void setBlue(List<DeploymentDetailsVmAzure> blue) {
        this.blue = blue;
    }

    public List<DeploymentDetailsVmAzure> getGreen() {
        return green;
    }

    public void setGreen(List<DeploymentDetailsVmAzure> green) {
        this.green = green;
    }
    //endregion
}
