package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsClusterConfiguration {
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

    private MrScalerAwsClusterConfiguration() { isSet = new HashSet<>(); }

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

    public static class Builder {
        private MrScalerAwsClusterConfiguration cluster;

        private Builder(){ this.cluster = new MrScalerAwsClusterConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

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

        public MrScalerAwsClusterConfiguration build(){
            return cluster;
        }
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
