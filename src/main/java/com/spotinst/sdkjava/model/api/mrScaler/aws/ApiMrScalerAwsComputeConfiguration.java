package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.AvailabilityZone;

public class ApiMrScalerAwsComputeConfiguration {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer ebsRootVolumeSize;
    private List<AvailabilityZone> availabilityZones;
    private List<Tag> tags;
    private ApiMrScalerAwsInstancegroups instanceGroups;
    private String emrManagedMasterSecurityGroup;
    private String emrManagedSlaveSecurityGroup;
    private List<String> additionalMasterSecurityGroups;
    private List<String> additionalSlaveSecurityGroups;
    private String serviceAccessSecurityGroup;
    private String customAmiId;
    private String repoUpgradeOnBoot;
    private String ec2KeyName;
    private List<ApiMrScalerAwsApplication> applications;
    private ApiMrScalerAwsFile bootstrapActions;
    private ApiMrScalerAwsFile configurations;
    private ApiMrScalerAwsFile steps;
    // endregion

    //region Constructor
    public ApiMrScalerAwsComputeConfiguration() {  isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region ebsRootVolumeSize
    public Integer getEbsRootVolumeSize(){ return ebsRootVolumeSize; }

    public void setEbsRootVolumeSize(Integer ebsRootVolumeSize) {
        isSet.add("ebsRootVolumeSize");
        this.ebsRootVolumeSize = ebsRootVolumeSize;
    }

    public Boolean isEbsRootVolumeSizeSet(){ return isSet.contains("ebsRootVolumeSize"); }
    // endregion

    // region availabilityZones
    public List<AvailabilityZone> getAvailabilityZones(){ return availabilityZones; }

    public void setAvailabilityZones(List<AvailabilityZone> availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public Boolean isAvailabilityZonesSet(){ return isSet.contains("availabilityZones"); }
    // endregion

    // region tags
    public List<Tag> getTags(){ return tags; }

    public void setTags(List<Tag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public Boolean isTagsSet(){ return isSet.contains("tags"); }
    // endregion

    // region instanceGroups
    public ApiMrScalerAwsInstancegroups getInstanceGroups(){ return instanceGroups; }

    public void setInstanceGroups(ApiMrScalerAwsInstancegroups instanceGroups) {
        isSet.add("instanceGroups");
        this.instanceGroups = instanceGroups;
    }

    public Boolean isInstanceGroupsSet(){ return isSet.contains("instanceGroups"); }
    // endregion

    // region emrManagedMasterSecurityGroup
    public String getEmrManagedMasterSecurityGroup(){ return emrManagedMasterSecurityGroup; }

    public void setEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup) {
        isSet.add("emrManagedMasterSecurityGroup");
        this.emrManagedMasterSecurityGroup = emrManagedMasterSecurityGroup;
    }

    public Boolean isEmrManagedMasterSecurityGroupSet(){ return isSet.contains("emrManagedMasterSecurityGroup"); }
    // endregion

    // region emrManagedSlaveSecurityGroup
    public String getEmrManagedSlaveSecurityGroup(){ return emrManagedSlaveSecurityGroup; }

    public void setEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup) {
        isSet.add("emrManagedSlaveSecurityGroup");
        this.emrManagedSlaveSecurityGroup = emrManagedSlaveSecurityGroup;
    }

    public Boolean isEmrManagedSlaveSecurityGroupSet(){ return isSet.contains("emrManagedSlaveSecurityGroup"); }
    // endregion

    // region additionalMasterSecurityGroups
    public List<String> getAdditionalMasterSecurityGroups(){ return additionalMasterSecurityGroups; }

    public void setAdditionalMasterSecurityGroups(List<String> additionalMasterSecurityGroups) {
        isSet.add("additionalMasterSecurityGroups");
        this.additionalMasterSecurityGroups = additionalMasterSecurityGroups;
    }

    public Boolean isAdditionalMasterSecurityGroupsSet(){ return isSet.contains("additionalMasterSecurityGroups"); }
    // endregion

    // region additionalSlaveSecurityGroups
    public List<String> getAdditionalSlaveSecurityGroups(){ return additionalSlaveSecurityGroups; }

    public void setAdditionalSlaveSecurityGroups(List<String> additionalSlaveSecurityGroups) {
        isSet.add("additionalSlaveSecurityGroups");
        this.additionalSlaveSecurityGroups = additionalSlaveSecurityGroups;
    }

    public Boolean isAdditionalSlaveSecurityGroupsSet(){ return isSet.contains("additionalSlaveSecurityGroups"); }
    // endregion

    // region serviceAccessSecurityGroup
    public String getServiceAccessSecurityGroup(){ return serviceAccessSecurityGroup; }

    public void setServiceAccessSecurityGroup(String serviceAccessSecurityGroup) {
        isSet.add("serviceAccessSecurityGroup");
        this.serviceAccessSecurityGroup = serviceAccessSecurityGroup;
    }

    public Boolean isServiceAccessSecurityGroupSet(){ return isSet.contains("serviceAccessSecurityGroup"); }
    // endregion

    // region customAmiId
    public String getCustomAmiId(){ return customAmiId; }

    public void setCustomAmiId(String customAmiId) {
        isSet.add("customAmiId");
        this.customAmiId = customAmiId;
    }

    public Boolean isCustomAmiIdSet(){ return isSet.contains("customAmiId"); }
    // endregion

    // region repoUpgradeOnBoot
    public String getRepoUpgradeOnBoot(){ return repoUpgradeOnBoot; }

    public void setRepoUpgradeOnBoot(String repoUpgradeOnBoot) {
        isSet.add("repoUpgradeOnBoot");
        this.repoUpgradeOnBoot = repoUpgradeOnBoot;
    }

    public Boolean isRepoUpgradeOnBootSet(){ return isSet.contains("repoUpgradeOnBoot"); }
    // endregion

    // region ec2KeyName
    public String getEc2KeyName(){ return ec2KeyName; }

    public void setEc2KeyName(String ec2KeyName) {
        isSet.add("ec2KeyName");
        this.ec2KeyName = ec2KeyName;
    }

    public Boolean isEc2KeyNameSet(){ return isSet.contains("ec2KeyName"); }
    // endregion

    // region applications
    public List<ApiMrScalerAwsApplication> getApplications(){ return applications; }

    public void setApplications(List<ApiMrScalerAwsApplication> applications) {
        isSet.add("applications");
        this.applications = applications;
    }

    public Boolean isApplicationsSet(){ return isSet.contains("applications"); }
    // endregion

    // region bootstrapActions
    public ApiMrScalerAwsFile getBootstrapActions(){ return bootstrapActions; }

    public void setBootstrapActions(ApiMrScalerAwsFile bootstrapActions) {
        isSet.add("bootstrapActions");
        this.bootstrapActions = bootstrapActions;
    }

    public Boolean isBootstrapActionsSet(){ return isSet.contains("bootstrapActions"); }
    // endregion

    // region configurations
    public ApiMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(ApiMrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public Boolean isConfigurationsSet(){ return isSet.contains("configurations"); }
    // endregion

    // region steps
    public ApiMrScalerAwsFile getSteps(){ return steps; }

    public void setSteps(ApiMrScalerAwsFile steps) {
        isSet.add("steps");
        this.steps = steps;
    }

    public Boolean isStepsSet(){ return isSet.contains("steps"); }
    // endregion

    // endregion

    public static class Builder {
        private ApiMrScalerAwsComputeConfiguration compute;

        private Builder(){ this.compute = new ApiMrScalerAwsComputeConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setEbsRootVolume(final Integer ebsRootVolume){
            compute.setEbsRootVolumeSize(ebsRootVolume);
            return this;
        }
        public Builder setAvailabilityZones(final List<AvailabilityZone> availabilityZones){
            compute.setAvailabilityZones(availabilityZones);
            return this;
        }
        public Builder setTags(List<Tag> tags){
            compute.setTags(tags);
            return this;
        }
        public Builder setInstanceGroups(ApiMrScalerAwsInstancegroups instanceGroups){
            compute.setInstanceGroups(instanceGroups);
            return this;
        }
        public Builder setEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup){
            compute.setEmrManagedMasterSecurityGroup(emrManagedMasterSecurityGroup);
            return this;
        }
        public Builder setEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup){
            compute.setEmrManagedSlaveSecurityGroup(emrManagedSlaveSecurityGroup);
            return this;
        }
        public Builder setAdditionalMasterSecurityGroups(List<String> additionalMasterSecurityGroups){
            compute.setAdditionalMasterSecurityGroups(additionalMasterSecurityGroups);
            return this;
        }
        public Builder setAdditionalSlaveSecurityGroups(List<String> additionalSlaveSecurityGroups){
            compute.setAdditionalSlaveSecurityGroups(additionalSlaveSecurityGroups);
            return this;
        }
        public Builder setServiceAccessSecurityGroup(String serviceAccessSecurityGroup){
            compute.setServiceAccessSecurityGroup(serviceAccessSecurityGroup);
            return this;
        }
        public Builder setCustomAmiId(String customAmiId){
            compute.setCustomAmiId(customAmiId);
            return this;
        }
        public Builder setRepoUpgradeOnBoot(String repoUpgradeOnBoot){
            compute.setRepoUpgradeOnBoot(repoUpgradeOnBoot);
            return this;
        }
        public Builder setEc2KeyName(String ec2KeyName){
            compute.setEc2KeyName(ec2KeyName);
            return this;
        }
        public Builder setApplications(List<ApiMrScalerAwsApplication> applications){
            compute.setApplications(applications);
            return this;
        }
        public Builder setBootstrapActions(ApiMrScalerAwsFile bootstrapActions){
            compute.setBootstrapActions(bootstrapActions);
            return this;
        }
        public Builder setConfigurations(ApiMrScalerAwsFile configurations){
            compute.setConfigurations(configurations);
            return this;
        }
        public Builder setSteps(ApiMrScalerAwsFile steps){
            compute.setSteps(steps);
            return this;
        }

        public ApiMrScalerAwsComputeConfiguration build(){
            return compute;
        }
        // endregion
    }
}
