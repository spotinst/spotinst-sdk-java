package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.AvailabilityZone;
import com.spotinst.sdkjava.model.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsComputeConfiguration {
    @JsonIgnore
    private Set<String>                    isSet;
    private Integer                        ebsRootVolumeSize;
    private List<AvailabilityZone>         availabilityZones;
    private List<Tag>                      tags;
    private MrScalerAwsInstancegroups instanceGroups;
    private String                         emrManagedMasterSecurityGroup;
    private String                         emrManagedSlaveSecurityGroup;
    private List<String>                   additionalMasterSecurityGroups;
    private List<String>                   additionalSlaveSecurityGroups;
    private String                         serviceAccessSecurityGroup;
    private String                         customAmiId;
    private String                         repoUpgradeOnBoot;
    private String                         ec2KeyName;
    private List<MrScalerAwsApplication> applications;
    private MrScalerAwsFile bootstrapActions;
    private MrScalerAwsFile configurations;
    private MrScalerAwsFile steps;
    private List<MrScalerAwsInstanceWeights>   instanceWeights;

    private MrScalerAwsComputeConfiguration() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getEbsRootVolumeSize() {
        return ebsRootVolumeSize;
    }

    public void setEbsRootVolumeSize(Integer ebsRootVolumeSize) {
        isSet.add("ebsRootVolumeSize");
        this.ebsRootVolumeSize = ebsRootVolumeSize;
    }

    public List<AvailabilityZone> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<AvailabilityZone> availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public MrScalerAwsInstancegroups getInstanceGroups() {
        return instanceGroups;
    }

    public void setInstanceGroups(MrScalerAwsInstancegroups instanceGroups) {
        isSet.add("instanceGroups");
        this.instanceGroups = instanceGroups;
    }

    public String getEmrManagedMasterSecurityGroup() {
        return emrManagedMasterSecurityGroup;
    }

    public void setEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup) {
        isSet.add("emrManagedMasterSecurityGroup");
        this.emrManagedMasterSecurityGroup = emrManagedMasterSecurityGroup;
    }

    public String getEmrManagedSlaveSecurityGroup() {
        return emrManagedSlaveSecurityGroup;
    }

    public void setEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup) {
        isSet.add("emrManagedSlaveSecurityGroup");
        this.emrManagedSlaveSecurityGroup = emrManagedSlaveSecurityGroup;
    }

    public List<String> getAdditionalMasterSecurityGroups() {
        return additionalMasterSecurityGroups;
    }

    public void setAdditionalMasterSecurityGroups(List<String> additionalMasterSecurityGroups) {
        isSet.add("additionalMasterSecurityGroups");
        this.additionalMasterSecurityGroups = additionalMasterSecurityGroups;
    }

    public List<String> getAdditionalSlaveSecurityGroups() {
        return additionalSlaveSecurityGroups;
    }

    public void setAdditionalSlaveSecurityGroups(List<String> additionalSlaveSecurityGroups) {
        isSet.add("additionalSlaveSecurityGroups");
        this.additionalSlaveSecurityGroups = additionalSlaveSecurityGroups;
    }

    public String getServiceAccessSecurityGroup() {
        return serviceAccessSecurityGroup;
    }

    public void setServiceAccessSecurityGroup(String serviceAccessSecurityGroup) {
        isSet.add("serviceAccessSecurityGroup");
        this.serviceAccessSecurityGroup = serviceAccessSecurityGroup;
    }

    public String getCustomAmiId() {
        return customAmiId;
    }

    public void setCustomAmiId(String customAmiId) {
        isSet.add("customAmiId");
        this.customAmiId = customAmiId;
    }

    public String getRepoUpgradeOnBoot() {
        return repoUpgradeOnBoot;
    }

    public void setRepoUpgradeOnBoot(String repoUpgradeOnBoot) {
        isSet.add("repoUpgradeOnBoot");
        this.repoUpgradeOnBoot = repoUpgradeOnBoot;
    }

    public String getEc2KeyName() {
        return ec2KeyName;
    }

    public void setEc2KeyName(String ec2KeyName) {
        isSet.add("ec2KeyName");
        this.ec2KeyName = ec2KeyName;
    }

    public List<MrScalerAwsApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<MrScalerAwsApplication> applications) {
        isSet.add("applications");
        this.applications = applications;
    }

    public MrScalerAwsFile getBootstrapActions() {
        return bootstrapActions;
    }

    public void setBootstrapActions(MrScalerAwsFile bootstrapActions) {
        isSet.add("bootstrapActions");
        this.bootstrapActions = bootstrapActions;
    }

    public MrScalerAwsFile getConfigurations() {
        return configurations;
    }

    public void setConfigurations(MrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public MrScalerAwsFile getSteps() {
        return steps;
    }

    public void setSteps(MrScalerAwsFile steps) {
        isSet.add("steps");
        this.steps = steps;
    }

    public List<MrScalerAwsInstanceWeights> getInstanceWeights() {
        return instanceWeights;
    }

    public void setInstanceWeights(List<MrScalerAwsInstanceWeights> instanceWeights) {
        isSet.add("instanceWeights");
        this.instanceWeights = instanceWeights;
    }

    public static class Builder {
        private MrScalerAwsComputeConfiguration compute;

        private Builder(){ this.compute = new MrScalerAwsComputeConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setEbsRootVolumeSize(final Integer ebsRootVolumeSize){
            compute.setEbsRootVolumeSize(ebsRootVolumeSize);
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
        public Builder setInstanceGroups(MrScalerAwsInstancegroups instanceGroups){
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
        public Builder setApplications(List<MrScalerAwsApplication> applications){
            compute.setApplications(applications);
            return this;
        }
        public Builder setBootstrapActions(MrScalerAwsFile bootstrapActions){
            compute.setBootstrapActions(bootstrapActions);
            return this;
        }
        public Builder setConfigurations(MrScalerAwsFile configurations){
            compute.setConfigurations(configurations);
            return this;
        }
        public Builder setSteps(MrScalerAwsFile steps){
            compute.setSteps(steps);
            return this;
        }

        public Builder setInstanceWeights(List<MrScalerAwsInstanceWeights> instanceWeights){
            compute.setInstanceWeights(instanceWeights);
            return this;
        }

        public MrScalerAwsComputeConfiguration build(){
            return compute;
        }

    }

    @JsonIgnore
    public Boolean isEbsRootVolumeSizeSet(){ return isSet.contains("ebsRootVolumeSize"); }

    @JsonIgnore
    public Boolean isAvailabilityZonesSet(){ return isSet.contains("availabilityZones"); }

    @JsonIgnore
    public Boolean isTagsSet(){ return isSet.contains("tags"); }

    @JsonIgnore
    public Boolean isInstanceGroupsSet(){ return isSet.contains("instanceGroups"); }

    @JsonIgnore
    public Boolean isEmrManagedMasterSecurityGroupSet(){ return isSet.contains("emrManagedMasterSecurityGroup"); }

    @JsonIgnore
    public Boolean isEmrManagedSlaveSecurityGroupSet(){ return isSet.contains("emrManagedSlaveSecurityGroup"); }

    @JsonIgnore
    public Boolean isAdditionalMasterSecurityGroupsSet(){ return isSet.contains("additionalMasterSecurityGroups"); }

    @JsonIgnore
    public Boolean isAdditionalSlaveSecurityGroupsSet(){ return isSet.contains("additionalSlaveSecurityGroups"); }

    @JsonIgnore
    public Boolean isServiceAccessSecurityGroupSet(){ return isSet.contains("serviceAccessSecurityGroup"); }

    @JsonIgnore
    public Boolean isCustomAmiIdSet(){ return isSet.contains("customAmiId"); }

    @JsonIgnore
    public Boolean isRepoUpgradeOnBootSet(){ return isSet.contains("repoUpgradeOnBoot"); }

    @JsonIgnore
    public Boolean isEc2KeyNameSet(){ return isSet.contains("ec2KeyName"); }

    @JsonIgnore
    public Boolean isApplicationsSet(){ return isSet.contains("applications"); }

    @JsonIgnore
    public Boolean isBootstrapActionsSet(){ return isSet.contains("bootstrapActions"); }

    @JsonIgnore
    public Boolean isConfigurationsSet(){ return isSet.contains("configurations"); }

    @JsonIgnore
    public Boolean isStepsSet(){ return isSet.contains("steps"); }

    @JsonIgnore
    public boolean isInstanceWeightsSet() {
        return isSet.contains("instanceWeights");
    }

}
