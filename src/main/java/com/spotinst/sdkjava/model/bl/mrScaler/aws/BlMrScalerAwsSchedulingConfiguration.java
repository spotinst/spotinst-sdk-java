package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlMrScalerAwsSchedulingConfiguration {
    //region Members
    private List<BlMrScalerAwsTask> tasks;
    //region Constructor
    public BlMrScalerAwsSchedulingConfiguration() { }
    // endregion

    //region getters and setters
    // region tasks
    public List<BlMrScalerAwsTask> getTasks(){
        return tasks;
    }

    public void setTasks(List<BlMrScalerAwsTask> tasks){
        this.tasks = tasks;
    }
    // endregion

    // endregion
}
