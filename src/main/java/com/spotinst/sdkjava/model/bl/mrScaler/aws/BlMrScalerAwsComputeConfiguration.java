package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.model.AvailabilityZone;
import com.spotinst.sdkjava.model.Tag;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsComputeConfiguration {
    //region Members
    private Integer ebsRootVolumeSize;
    private List<AvailabilityZone> availabilityZones;
    private List<Tag> tags;
    private BlMrScalerAwsInstancegroups instanceGroups;
    private String emrManagedMasterSecurityGroup;
    private String emrManagedSlaveSecurityGroup;
    private List<String> additionalMasterSecurityGroups;
    private List<String> additionalSlaveSecurityGroups;
    private String serviceAccessSecurityGroup;
    private String customAmiId;
    private String repoUpgradeOnBoot;
    private String ec2KeyName;
    private List<BlMrScalerAwsApplication> applications;
    private BlMrScalerAwsFile bootstrapActions;
    private BlMrScalerAwsFile configurations;
    private BlMrScalerAwsFile steps;
    // endregion

    //region Constructor
    public BlMrScalerAwsComputeConfiguration() {}
    // endregion

    // region methods
    // region ebsRootVolumeSize
    public Integer getEbsRootVolumeSize(){ return ebsRootVolumeSize; }

    public void setEbsRootVolumeSize(Integer ebsRootVolumeSize) {
        this.ebsRootVolumeSize = ebsRootVolumeSize;
    }
    // endregion

    // region availabilityZones
    public List<AvailabilityZone> getAvailabilityZones(){ return availabilityZones; }

    public void setAvailabilityZones(List<AvailabilityZone> availabilityZones) {
        this.availabilityZones = availabilityZones;
    }
    // endregion

    // region tags
    public List<Tag> getTags(){ return tags; }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    // endregion

    // region instanceGroups
    public BlMrScalerAwsInstancegroups getInstanceGroups(){ return instanceGroups; }

    public void setInstanceGroups(BlMrScalerAwsInstancegroups instanceGroups) {
        this.instanceGroups = instanceGroups;
    }
    // endregion

    // region emrManagedMasterSecurityGroup
    public String getEmrManagedMasterSecurityGroup(){ return emrManagedMasterSecurityGroup; }

    public void setEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup) {
        this.emrManagedMasterSecurityGroup = emrManagedMasterSecurityGroup;
    }
    // endregion

    // region emrManagedSlaveSecurityGroup
    public String getEmrManagedSlaveSecurityGroup(){ return emrManagedSlaveSecurityGroup; }

    public void setEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup) {
        this.emrManagedSlaveSecurityGroup = emrManagedSlaveSecurityGroup;
    }
    // endregion

    // region additionalMasterSecurityGroups
    public List<String> getAdditionalMasterSecurityGroups(){ return additionalMasterSecurityGroups; }

    public void setAdditionalMasterSecurityGroups(List<String> additionalMasterSecurityGroups) {
        this.additionalMasterSecurityGroups = additionalMasterSecurityGroups;
    }
    // endregion

    // region additionalSlaveSecurityGroups
    public List<String> getAdditionalSlaveSecurityGroups(){ return additionalSlaveSecurityGroups; }

    public void setAdditionalSlaveSecurityGroups(List<String> additionalSlaveSecurityGroups) {
        this.additionalSlaveSecurityGroups = additionalSlaveSecurityGroups;
    }
    // endregion

    // region serviceAccessSecurityGroup
    public String getServiceAccessSecurityGroup(){ return serviceAccessSecurityGroup; }

    public void setServiceAccessSecurityGroup(String serviceAccessSecurityGroup) {
        this.serviceAccessSecurityGroup = serviceAccessSecurityGroup;
    }
    // endregion

    // region customAmiId
    public String getCustomAmiId(){ return customAmiId; }

    public void setCustomAmiId(String customAmiId) {
        this.customAmiId = customAmiId;
    }
    // endregion

    // region repoUpgradeOnBoot
    public String getRepoUpgradeOnBoot(){ return repoUpgradeOnBoot; }

    public void setRepoUpgradeOnBoot(String repoUpgradeOnBoot) {
        this.repoUpgradeOnBoot = repoUpgradeOnBoot;
    }
    // endregion

    // region ec2KeyName
    public String getEc2KeyName(){ return ec2KeyName; }

    public void setEc2KeyName(String ec2KeyName) {
        this.ec2KeyName = ec2KeyName;
    }
    // endregion

    // region applications
    public List<BlMrScalerAwsApplication> getApplications(){ return applications; }

    public void setApplications(List<BlMrScalerAwsApplication> applications) {
        this.applications = applications;
    }
    // endregion

    // region bootstrapActions
    public BlMrScalerAwsFile getBootstrapActions(){ return bootstrapActions; }

    public void setBootstrapActions(BlMrScalerAwsFile bootstrapActions) {
        this.bootstrapActions = bootstrapActions;
    }
    // endregion

    // region configurations
    public BlMrScalerAwsFile getConfigurations(){ return configurations; }

    public void setConfigurations(BlMrScalerAwsFile configurations) {
        this.configurations = configurations;
    }
    // endregion

    // region steps
    public BlMrScalerAwsFile getSteps(){ return steps; }

    public void setSteps(BlMrScalerAwsFile steps) {
        this.steps = steps;
    }
    // endregion

    // endregion
}
