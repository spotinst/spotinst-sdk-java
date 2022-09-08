package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsInstancegroups {
    @JsonIgnore
    private Set<String>              isSet;
    private MrScalerAwsMasterGroup masterGroup;
    private MrScalerAwsCoreGroup coreGroup;
    private MrScalerAwsTaskGroup taskGroup;

    private MrScalerAwsInstancegroups() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public MrScalerAwsMasterGroup getMasterGroup() {
        return masterGroup;
    }

    public void setMasterGroup(MrScalerAwsMasterGroup masterGroup) {
        isSet.add("masterGroup");
        this.masterGroup = masterGroup;
    }

    public MrScalerAwsCoreGroup getCoreGroup() {
        return coreGroup;
    }

    public void setCoreGroup(MrScalerAwsCoreGroup coreGroup) {
        isSet.add("coreGroup");
        this.coreGroup = coreGroup;
    }

    public MrScalerAwsTaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(MrScalerAwsTaskGroup taskGroup) {
        isSet.add("taskGroup");
        this.taskGroup = taskGroup;
    }

    public static class Builder {
        private MrScalerAwsInstancegroups instancegroups;

        private Builder(){ this.instancegroups = new MrScalerAwsInstancegroups(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setMasterGroup(final MrScalerAwsMasterGroup masterGroup){
            instancegroups.setMasterGroup(masterGroup);
            return this;
        }
        public Builder setCoreGroup(final MrScalerAwsCoreGroup coreGroup){
            instancegroups.setCoreGroup(coreGroup);
            return this;
        }
        public Builder setTaskGroup(final MrScalerAwsTaskGroup taskGroup){
            instancegroups.setTaskGroup(taskGroup);
            return this;
        }

        public MrScalerAwsInstancegroups build(){
            return instancegroups;
        }
    }

    @JsonIgnore
    public Boolean isMasterGroupSet(){ return isSet.contains("masterGroup"); }

    @JsonIgnore
    public Boolean isCoreGroupSet(){ return isSet.contains("coreGroup"); }

    @JsonIgnore
    public Boolean isTaskGroupSet(){ return isSet.contains("taskGroup"); }
}
