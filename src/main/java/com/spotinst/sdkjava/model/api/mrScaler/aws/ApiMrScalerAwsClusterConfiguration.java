package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsClusterConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     visibleToAllUsers;
    private Boolean     terminationProtected;
    private Boolean     keepJobFlowAliveWhenNoSteps;
    private String      logUri;
    private String      additionalInfo;
    private String      jobFlowRole;
    private String      securityConfiguration;
    private String      serviceRole;

    public ApiMrScalerAwsClusterConfiguration() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getVisibleToAllUsers(){
        return visibleToAllUsers;
    }

    public void setVisibleToAllUsers(Boolean visibleToAllUsers){
        isSet.add("visibleToAllUsers");
        this.visibleToAllUsers = visibleToAllUsers;
    }

    public Boolean getTerminationProtected(){
        return terminationProtected;
    }

    public void setTerminationProtected(Boolean terminationProtected){
        isSet.add("terminationProtected");
        this.terminationProtected = terminationProtected;
    }

    public Boolean getKeepJobFlowAliveWhenNoSteps(){
        return keepJobFlowAliveWhenNoSteps;
    }

    public void setKeepJobFlowAliveWhenNoSteps(Boolean keepJobFlowAliveWhenNoSteps){
        isSet.add("keepJobFlowAliveWhenNoSteps");
        this.keepJobFlowAliveWhenNoSteps = keepJobFlowAliveWhenNoSteps;
    }

    public String getLogUri(){
        return logUri;
    }

    public void setLogUri(String logUri){
        isSet.add("logUri");
        this.logUri = logUri;
    }

    public String getAdditionalInfo(){
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo){
        isSet.add("additionalInfo");
        this.additionalInfo = additionalInfo;
    }

    public String getJobFlowRole(){
        return jobFlowRole;
    }

    public void setJobFlowRole(String jobFlowRole){
        isSet.add("jobFlowRole");
        this.jobFlowRole = jobFlowRole;
    }

    public String getSecurityConfiguration(){
        return securityConfiguration;
    }

    public void setSecurityConfiguration(String securityConfiguration){
        isSet.add("securityConfiguration");
        this.securityConfiguration = securityConfiguration;
    }

    public String getServiceRole(){ return serviceRole; }

    public void setServiceRole(String serviceRole){
        isSet.add("serviceRole");
        this.serviceRole = serviceRole;
    }

    @JsonIgnore
    public Boolean isVisibleToAllUsersSet(){
        return isSet.contains("visibleToAllUsers");
    }

    @JsonIgnore
    public Boolean isTerminationProtectedSet(){
        return isSet.contains("terminationProtected");
    }

    @JsonIgnore
    public Boolean isKeepJobFlowAliveWhenNoStepsSet(){
        return isSet.contains("keepJobFlowAliveWhenNoSteps");
    }

    @JsonIgnore
    public Boolean isLogUriSet(){
        return isSet.contains("logUri");
    }

    @JsonIgnore
    public Boolean isJobFlowRoleSet(){
        return isSet.contains("jobFlowRole");
    }

    @JsonIgnore
    public Boolean isAdditionalInfoSet(){
        return isSet.contains("additionalInfo");
    }

    @JsonIgnore
    public Boolean isSecurityConfigurationSet(){
        return isSet.contains("securityConfiguration");
    }

    @JsonIgnore
    public Boolean isServiceRoleSet(){
        return isSet.contains("serviceRole");
    }

}
