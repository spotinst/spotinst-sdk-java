package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeploymentDetailsBatchAzure {
    //region members
    @JsonIgnore
    private Set<String>                                isSet;
    private Integer                                    batch;
    private List<DeploymentDetailsVirtualMachineAzure> blue;
    private List<DeploymentDetailsVirtualMachineAzure> green;
    //endregion

    //region constructor
    public DeploymentDetailsBatchAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters & setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        touch("isSet");
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
        touch("batch");
    }

    public List<DeploymentDetailsVirtualMachineAzure> getBlue() {
        return blue;
    }

    public void setBlue(List<DeploymentDetailsVirtualMachineAzure> blue) {
        this.blue = blue;
        touch("blue");
    }

    public List<DeploymentDetailsVirtualMachineAzure> getGreen() {
        return green;
    }

    public void setGreen(List<DeploymentDetailsVirtualMachineAzure> green) {
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
