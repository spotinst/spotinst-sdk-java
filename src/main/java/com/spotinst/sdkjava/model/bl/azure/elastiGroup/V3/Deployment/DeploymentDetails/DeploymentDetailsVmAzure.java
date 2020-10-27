package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.spotinst.sdkjava.enums.DeploymentInstanceStatusEnumAzure;
import com.spotinst.sdkjava.enums.GenerationEnumAzure;

import java.util.Date;

public class DeploymentDetailsVmAzure {
    //region members
    private String                            vmName;
    private Integer                           batchNum;
    private DeploymentInstanceStatusEnumAzure status;
    private GenerationEnumAzure               type;
    private Date                              updatedAt;
    //endregion

    //region getters & setters
    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    public DeploymentInstanceStatusEnumAzure getStatus() {
        return status;
    }

    public void setStatus(DeploymentInstanceStatusEnumAzure status) {
        this.status = status;
    }

    public GenerationEnumAzure getType() {
        return type;
    }

    public void setType(GenerationEnumAzure type) {
        this.type = type;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    //endregion
}
