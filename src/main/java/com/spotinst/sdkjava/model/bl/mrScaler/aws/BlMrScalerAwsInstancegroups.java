package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsInstancegroups {
    //region Members
    private BlMrScalerAwsMasterGroup masterGroup;
    private BlMrScalerAwsCoreGroup coreGroup;
    private BlMrScalerAwsTaskGroup taskGroup;
    // endregion

    //region Constructor
    public BlMrScalerAwsInstancegroups() { }
    // endregion

    // region methods
    // region masterGroup
    public BlMrScalerAwsMasterGroup getMasterGroup(){ return masterGroup; }

    public void setMasterGroup(BlMrScalerAwsMasterGroup masterGroup) {
        this.masterGroup = masterGroup;
    }
    // endregion

    // region coreGroup
    public BlMrScalerAwsCoreGroup getCoreGroup(){ return coreGroup; }

    public void setCoreGroup(BlMrScalerAwsCoreGroup coreGroup) {
        this.coreGroup = coreGroup;
    }
    // endregion

    // region taskGroup
    public BlMrScalerAwsTaskGroup getTaskGroup(){ return taskGroup; }

    public void setTaskGroup(BlMrScalerAwsTaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }
    // endregion
    // endregion
}
