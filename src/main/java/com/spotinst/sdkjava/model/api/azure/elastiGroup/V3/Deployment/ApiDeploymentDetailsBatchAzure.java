package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDeploymentDetailsBatchAzure implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String>                                   isSet;
    private Integer                                       batch;
    private List<ApiDeploymentDetailsVirtualMachineAzure> blue;
    private List<ApiDeploymentDetailsVirtualMachineAzure> green;
    //endregion

    //region constructor
    public ApiDeploymentDetailsBatchAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
        touch("batch");
    }

    public List<ApiDeploymentDetailsVirtualMachineAzure> getBlue() {
        return blue;
    }

    public void setBlue(List<ApiDeploymentDetailsVirtualMachineAzure> blue) {
        this.blue = blue;
        touch("blue");
    }

    public List<ApiDeploymentDetailsVirtualMachineAzure> getGreen() {
        return green;
    }

    public void setGreen(List<ApiDeploymentDetailsVirtualMachineAzure> green) {
        this.green = green;
        touch("green");
    }

    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isBatchSet() {
        return this.isSet.contains("batch");
    }
    @JsonIgnore
    public Boolean isBlueSet() {
        return this.isSet.contains("blue");
    }
    @JsonIgnore
    public Boolean isGreenSet() {
        return this.isSet.contains("green");
    }
    //endregion

    //region private methods - touch helper
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion


}
