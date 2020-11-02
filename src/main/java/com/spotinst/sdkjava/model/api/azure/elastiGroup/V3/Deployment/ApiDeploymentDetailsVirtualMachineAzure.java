package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDeploymentDetailsVirtualMachineAzure implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String> isSet;
    private String      vmName;
    private Integer     batchNum;
    private String      status;
    private String      type;
    private Date        updatedAt;
    //endregion

    //region constructor
    public ApiDeploymentDetailsVirtualMachineAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        touch("status");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
