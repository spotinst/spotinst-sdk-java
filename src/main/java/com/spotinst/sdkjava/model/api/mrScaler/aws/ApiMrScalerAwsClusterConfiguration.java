package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsClusterConfiguration {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean visibleToAllUsers;
    private Boolean terminationProtected;
    private Boolean keepJobFlowAliveWhenNoSteps;
    private String logUri;
    private String additionalInfo;
    private String jobFlowRole;
    private String securityConfiguration;
    private String serviceRole;
    // endregion


    //region Constructor
    public ApiMrScalerAwsClusterConfiguration() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters

    // region visibleToAllUsers
    public Boolean getVisibleToAllUsers(){
        return visibleToAllUsers;
    }

    public void setVisibleToAllUsers(Boolean visibleToAllUsers){
        isSet.add("visibleToAllUsers");
        this.visibleToAllUsers = visibleToAllUsers;
    }

    public Boolean isVisibleToAllUsersSet(){
        return isSet.contains("visibleToAllUsers");
    }
    // endregion

    // region terminationProtected
    public Boolean getTerminationProtected(){
        return terminationProtected;
    }

    public void setTerminationProtected(Boolean terminationProtected){
        isSet.add("terminationProtected");
        this.terminationProtected = terminationProtected;
    }

    public Boolean isTerminationProtectedSet(){
        return isSet.contains("terminationProtected");
    }
    // endregion

    // region keepJobFlowAliveWhenNoSteps
    public Boolean getKeepJobFlowAliveWhenNoSteps(){
        return keepJobFlowAliveWhenNoSteps;
    }

    public void setKeepJobFlowAliveWhenNoSteps(Boolean keepJobFlowAliveWhenNoSteps){
        isSet.add("keepJobFlowAliveWhenNoSteps");
        this.keepJobFlowAliveWhenNoSteps = keepJobFlowAliveWhenNoSteps;
    }

    public Boolean isKeepJobFlowAliveWhenNoStepsSet(){
        return isSet.contains("keepJobFlowAliveWhenNoSteps");
    }
    // endregion

    // region logUri
    public String getLogUri(){
        return logUri;
    }

    public void setLogUri(String logUri){
        isSet.add("logUri");
        this.logUri = logUri;
    }

    public Boolean isLogUriSet(){
        return isSet.contains("logUri");
    }
    // endregion

    // region additionalInfo
    public String getAdditionalInfo(){
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo){
        isSet.add("additionalInfo");
        this.additionalInfo = additionalInfo;
    }

    public Boolean isAdditionalInfoSet(){
        return isSet.contains("additionalInfo");
    }
    // endregion

    // region jobFlowRole
    public String getJobFlowRole(){
        return jobFlowRole;
    }

    public void setJobFlowRole(String jobFlowRole){
        isSet.add("jobFlowRole");
        this.jobFlowRole = jobFlowRole;
    }

    public Boolean isJobFlowRoleSet(){
        return isSet.contains("jobFlowRole");
    }
    // endregion

    // region securityConfiguration
    public String getSecurityConfiguration(){
        return securityConfiguration;
    }

    public void setSecurityConfiguration(String securityConfiguration){
        isSet.add("securityConfiguration");
        this.securityConfiguration = securityConfiguration;
    }

    public Boolean isSecurityConfigurationSet(){
        return isSet.contains("securityConfiguration");
    }
    // endregion

    // region serviceRole
    public String getServiceRole(){ return serviceRole; }

    public void setServiceRole(String serviceRole){
        isSet.add("serviceRole");
        this.serviceRole = serviceRole;
    }

    public Boolean isServiceRoleSet(){
        return isSet.contains("serviceRole");
    }
    // endregion

    // endregion

    public static class Builder {
        private ApiMrScalerAwsClusterConfiguration cluster;

        private Builder(){ this.cluster = new ApiMrScalerAwsClusterConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setVisibleToAllUsers(final Boolean visibleToAllUsers){
            cluster.setVisibleToAllUsers(visibleToAllUsers);
            return this;
        }
        public Builder setTerminationProtected(final Boolean terminationProtected){
            cluster.setTerminationProtected(terminationProtected);
            return this;
        }
        public Builder setKeepJobFlowAliveWhenNoSteps(final Boolean keepJobFlowAliveWhenNoSteps){
            cluster.setKeepJobFlowAliveWhenNoSteps(keepJobFlowAliveWhenNoSteps);
            return this;
        }
        public Builder setLogUri(final String logUri){
            cluster.setLogUri(logUri);
            return this;
        }
        public Builder setAdditionalInfo(final String additionalInfo){
            cluster.setAdditionalInfo(additionalInfo);
            return this;
        }
        public Builder setJobFlowRole(final String jobFlowRole){
            cluster.setJobFlowRole(jobFlowRole);
            return this;
        }
        public Builder setSecurityConfiguration(final String securityConfiguration){
            cluster.setSecurityConfiguration(securityConfiguration);
            return this;
        }
        public Builder setServiceRole(final String serviceRole){
            cluster.setServiceRole(serviceRole);
            return this;
        }

        public ApiMrScalerAwsClusterConfiguration build(){
            return cluster;
        }
        // endregion
    }
}
