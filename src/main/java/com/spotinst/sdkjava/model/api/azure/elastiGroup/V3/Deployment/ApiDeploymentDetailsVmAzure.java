package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import java.util.Date;

public class ApiDeploymentDetailsVmAzure {
    //region members
    private String  vmName;
    private Integer batchNum;
    private String  status;
    private String  type;
    private Date    updatedAt;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
