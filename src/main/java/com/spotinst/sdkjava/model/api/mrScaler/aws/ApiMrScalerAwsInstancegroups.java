package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsInstancegroups {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private ApiMrScalerAwsMasterGroup masterGroup;
    private ApiMrScalerAwsCoreGroup coreGroup;
    private ApiMrScalerAwsTaskGroup taskGroup;
    // endregion

    //region Constructor
    public ApiMrScalerAwsInstancegroups() {  isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region masterGroup
    public ApiMrScalerAwsMasterGroup getMasterGroup(){ return masterGroup; }

    public void setMasterGroup(ApiMrScalerAwsMasterGroup masterGroup) {
        isSet.add("masterGroup");
        this.masterGroup = masterGroup;
    }

    public Boolean isMasterGroupSet(){ return isSet.contains("masterGroup"); }
    // endregion

    // region coreGroup
    public ApiMrScalerAwsCoreGroup getCoreGroup(){ return coreGroup; }

    public void setCoreGroup(ApiMrScalerAwsCoreGroup coreGroup) {
        isSet.add("coreGroup");
        this.coreGroup = coreGroup;
    }

    public Boolean isCoreGroupSet(){ return isSet.contains("coreGroup"); }
    // endregion

    // region taskGroup
    public ApiMrScalerAwsTaskGroup getTaskGroup(){ return taskGroup; }

    public void setTaskGroup(ApiMrScalerAwsTaskGroup taskGroup) {
        isSet.add("taskGroup");
        this.taskGroup = taskGroup;
    }

    public Boolean isTaskGroupSet(){ return isSet.contains("taskGroup"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsInstancegroups instancegroups;

        private Builder(){ this.instancegroups = new ApiMrScalerAwsInstancegroups(); }

        public static Builder get(){
            return new Builder();
        }

        // region builder methods
        public Builder setMasterGroup(final ApiMrScalerAwsMasterGroup masterGroup){
            instancegroups.setMasterGroup(masterGroup);
            return this;
        }
        public Builder setCoreGroup(final ApiMrScalerAwsCoreGroup coreGroup){
            instancegroups.setCoreGroup(coreGroup);
            return this;
        }
        public Builder setTaskGroup(final ApiMrScalerAwsTaskGroup taskGroup){
            instancegroups.setTaskGroup(taskGroup);
            return this;
        }

        public ApiMrScalerAwsInstancegroups build(){
            return instancegroups;
        }
        // endregion
    }
}
