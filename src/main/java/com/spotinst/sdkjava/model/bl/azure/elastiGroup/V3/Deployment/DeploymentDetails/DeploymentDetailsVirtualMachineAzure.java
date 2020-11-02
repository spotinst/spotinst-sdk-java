package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.DeploymentInstanceStatusEnumAzure;
import com.spotinst.sdkjava.enums.GenerationEnumAzure;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DeploymentDetailsVirtualMachineAzure {
    //region members
    @JsonIgnore
    private Set<String>                       isSet;
    private String                            vmName;
    private Integer                           batchNum;
    private DeploymentInstanceStatusEnumAzure status;
    private GenerationEnumAzure               type;
    private Date                              updatedAt;
    //endregion

    //region constructor
    public DeploymentDetailsVirtualMachineAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
        touch("vmName");
    }

    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
        touch("batchNum");
    }

    public DeploymentInstanceStatusEnumAzure getStatus() {
        return status;
    }

    public void setStatus(DeploymentInstanceStatusEnumAzure status) {
        this.status = status;
        touch("status");
    }

    public GenerationEnumAzure getType() {
        return type;
    }

    public void setType(GenerationEnumAzure type) {
        this.type = type;
        touch("type");
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        touch("updatedAt");
    }

    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isVmNameSet() {
        return this.isSet.contains("vmName");
    }
    @JsonIgnore
    public Boolean isBatchNumSet() {
        return this.isSet.contains("batchNum");
    }
    @JsonIgnore
    public Boolean isStatusSet() {
        return this.isSet.contains("status");
    }
    @JsonIgnore
    public Boolean isTypeSet() {
        return this.isSet.contains("type");
    }
    @JsonIgnore
    public Boolean isUpdatedAtSet() {
        return this.isSet.contains("updatedAt");
    }
    //endregion


    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
