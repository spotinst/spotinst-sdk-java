package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.Tag;
import com.spotinst.sdkjava.model.AvailabilityZone;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsComputeConfiguration implements IPartialUpdateEntity {
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
    private List<ApiMrScalerAwsInstanceWeights>   instanceWeights;

    public ApiMrScalerAwsComputeConfiguration() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getEbsRootVolumeSize(){ return ebsRootVolumeSize; }

    public void setEbsRootVolumeSize(Integer ebsRootVolumeSize) {
        isSet.add("ebsRootVolumeSize");
        this.ebsRootVolumeSize = ebsRootVolumeSize;
    }
    // endregion

    // region availabilityZones
    public List<AvailabilityZone> getAvailabilityZones(){ return availabilityZones; }

    public void setAvailabilityZones(List<AvailabilityZone> availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public List<Tag> getTags(){ return tags; }

    public void setTags(List<Tag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ApiMrScalerAwsInstancegroups getInstanceGroups(){ return instanceGroups; }

    public void setInstanceGroups(ApiMrScalerAwsInstancegroups instanceGroups) {
        isSet.add("instanceGroups");
        this.instanceGroups = instanceGroups;
    }

    public String getEmrManagedMasterSecurityGroup(){ return emrManagedMasterSecurityGroup; }

    public void setEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup) {
        isSet.add("emrManagedMasterSecurityGroup");
        this.emrManagedMasterSecurityGroup = emrManagedMasterSecurityGroup;
    }

    public String getEmrManagedSlaveSecurityGroup(){ return emrManagedSlaveSecurityGroup; }

    public void setEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup) {
        isSet.add("emrManagedSlaveSecurityGroup");
        this.emrManagedSlaveSecurityGroup = emrManagedSlaveSecurityGroup;
    }

    public List<String> getAdditionalMasterSecurityGroups(){ return additionalMasterSecurityGroups; }

    public void setAdditionalMasterSecurityGroups(List<String> additionalMasterSecurityGroups) {
        isSet.add("additionalMasterSecurityGroups");
        this.additionalMasterSecurityGroups = additionalMasterSecurityGroups;
    }

    public List<String> getAdditionalSlaveSecurityGroups(){ return additionalSlaveSecurityGroups; }

    public void setAdditionalSlaveSecurityGroups(List<String> additionalSlaveSecurityGroups) {
        isSet.add("additionalSlaveSecurityGroups");
        this.additionalSlaveSecurityGroups = additionalSlaveSecurityGroups;
    }

    public String getServiceAccessSecurityGroup(){ return serviceAccessSecurityGroup; }

    public void setServiceAccessSecurityGroup(String serviceAccessSecurityGroup) {
        isSet.add("serviceAccessSecurityGroup");
        this.serviceAccessSecurityGroup = serviceAccessSecurityGroup;
    }

    public String getCustomAmiId(){ return customAmiId; }

    public void setCustomAmiId(String customAmiId) {
        isSet.add("customAmiId");
        this.customAmiId = customAmiId;
    }

    public String getRepoUpgradeOnBoot(){ return repoUpgradeOnBoot; }

    public void setRepoUpgradeOnBoot(String repoUpgradeOnBoot) {
        isSet.add("repoUpgradeOnBoot");
        this.repoUpgradeOnBoot = repoUpgradeOnBoot;
    }

    public String getEc2KeyName(){ return ec2KeyName; }

    public void setEc2KeyName(String ec2KeyName) {
        isSet.add("ec2KeyName");
        this.ec2KeyName = ec2KeyName;
    }

    public List<ApiMrScalerAwsApplication> getApplications(){ return applications; }

    public void setApplications(List<ApiMrScalerAwsApplication> applications) {
        isSet.add("applications");
        this.applications = applications;
    }

    public ApiMrScalerAwsFile getBootstrapActions(){ return bootstrapActions; }

    public void setBootstrapActions(ApiMrScalerAwsFile bootstrapActions) {
        isSet.add("bootstrapActions");
        this.bootstrapActions = bootstrapActions;
    }

    public ApiMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(ApiMrScalerAwsFile configurations) {
        isSet.add("configurations");
        this.configurations = configurations;
    }

    public ApiMrScalerAwsFile getSteps(){ return steps; }

    public void setSteps(ApiMrScalerAwsFile steps) {
        isSet.add("steps");
        this.steps = steps;
    }

    public List<ApiMrScalerAwsInstanceWeights> getInstanceWeights() {
        return instanceWeights;
    }

    public void setInstanceWeights(List<ApiMrScalerAwsInstanceWeights> instanceWeights) {
        isSet.add("instanceWeights");
        this.instanceWeights = instanceWeights;
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
