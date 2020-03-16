package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsClusterConfiguration {
    //region Members
    private Boolean visibleToAllUsers;
    private Boolean terminationProtected;
    private Boolean keepJobFlowAliveWhenNoSteps;
    private String  logUri;
    private String  additionalInfo;
    private String  jobFlowRole;
    private String  securityConfiguration;
    private String  serviceRole;
    // endregion


    //region Constructor
    public BlMrScalerAwsClusterConfiguration() {
    }
    // endregion

    //region getters and setters

    // region visibleToAllUsers
    public Boolean getVisibleToAllUsers() {
        return visibleToAllUsers;
    }

    public void setVisibleToAllUsers(Boolean visibleToAllUsers) {
        this.visibleToAllUsers = visibleToAllUsers;
    }
    // endregion

    // region terminationProtected
    public Boolean getTerminationProtected() {
        return terminationProtected;
    }

    public void setTerminationProtected(Boolean terminationProtected) {
        this.terminationProtected = terminationProtected;
    }
    // endregion

    // region keepJobFlowAliveWhenNoSteps
    public Boolean getKeepJobFlowAliveWhenNoSteps() {
        return keepJobFlowAliveWhenNoSteps;
    }

    public void setKeepJobFlowAliveWhenNoSteps(Boolean keepJobFlowAliveWhenNoSteps) {
        this.keepJobFlowAliveWhenNoSteps = keepJobFlowAliveWhenNoSteps;
    }
    // endregion

    // region logUri
    public String getLogUri() {
        return logUri;
    }

    public void setLogUri(String logUri) {
        this.logUri = logUri;
    }
    // endregion

    // region additionalInfo
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    // endregion

    // region jobFlowRole
    public String getJobFlowRole() {
        return jobFlowRole;
    }

    public void setJobFlowRole(String jobFlowRole) {
        this.jobFlowRole = jobFlowRole;
    }
    // endregion

    // region securityConfiguration
    public String getSecurityConfiguration() {
        return securityConfiguration;
    }

    public void setSecurityConfiguration(String securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }
    // endregion

    // region serviceRole
    public String getServiceRole() {
        return serviceRole;
    }

    public void setServiceRole(String serviceRole) {
        this.serviceRole = serviceRole;
    }
    // endregion

    // endregion


}
