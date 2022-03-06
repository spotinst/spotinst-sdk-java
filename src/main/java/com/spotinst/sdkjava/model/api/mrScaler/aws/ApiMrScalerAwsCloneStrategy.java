package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsCloneStrategy {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String originClusterId;
    private Boolean includeSteps;
    private Integer numberOfRetries;
    // endregion

    //region Constructor
    public ApiMrScalerAwsCloneStrategy() { isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region originClusterId
    public String getOriginClusterId(){ return originClusterId;}

    public void setOriginClusterId(String originClusterId){
        isSet.add("originClusterId");
        this.originClusterId = originClusterId;
    }

    public Boolean isOriginClusterIdSet(){ return isSet.contains("originClusterId"); }
    // endregion

    // region includeSteps
    public Boolean getIncludeSteps(){ return includeSteps;}

    public void setIncludeSteps(Boolean includeSteps){
        isSet.add("includeSteps");
        this.includeSteps = includeSteps;
    }

    public Boolean isIncludeStepsSet(){ return isSet.contains("includeSteps"); }
    // endregion

    // region numberOfRetries
    public Integer getNumberOfRetries(){ return numberOfRetries;}

    public void setNumberOfRetries(Integer numberOfRetries){
        isSet.add("numberOfRetries");
        this.numberOfRetries = numberOfRetries;
    }

    public Boolean isNumberOfRetriesSet(){ return isSet.contains("numberOfRetries"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsCloneStrategy mrScalerAwsCloneStrategy;

        private Builder(){ this.mrScalerAwsCloneStrategy = new ApiMrScalerAwsCloneStrategy(); }

        public static Builder get(){
            return new Builder();
        }

        // builders
        public Builder setOriginClusterId(final String clusterId){
            mrScalerAwsCloneStrategy.setOriginClusterId(clusterId);
            return this;
        }
        public Builder setIncludeSteps(final Boolean includeSteps){
            mrScalerAwsCloneStrategy.setIncludeSteps(includeSteps);
            return this;
        }
        public Builder setNumberOfRetries(final Integer numberOfRetries){
            mrScalerAwsCloneStrategy.setNumberOfRetries(numberOfRetries);
            return this;
        }

        public ApiMrScalerAwsCloneStrategy build(){
            return mrScalerAwsCloneStrategy;
        }

        // endregion
    }
}
