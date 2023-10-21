package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsCloneStrategy {
    @JsonIgnore
    private Set<String> isSet;
    private String      originClusterId;
    private Boolean     includeSteps;
    private Integer     numberOfRetries;

    private MrScalerAwsCloneStrategy()   {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOriginClusterId(){ return originClusterId;}

    public void setOriginClusterId(String originClusterId){
        isSet.add("originClusterId");
        this.originClusterId = originClusterId;
    }

    public Boolean getIncludeSteps(){ return includeSteps;}

    public void setIncludeSteps(Boolean includeSteps){
        isSet.add("includeSteps");
        this.includeSteps = includeSteps;
    }

    public Integer getNumberOfRetries(){ return numberOfRetries;}

    public void setNumberOfRetries(Integer numberOfRetries){
        isSet.add("numberOfRetries");
        this.numberOfRetries = numberOfRetries;
    }

    public static class Builder {
        private MrScalerAwsCloneStrategy mrScalerAwsCloneStrategy;

        private Builder(){ this.mrScalerAwsCloneStrategy = new MrScalerAwsCloneStrategy(); }

        public static Builder get(){
            Builder builder = new Builder();
            return builder;
        }

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

        public MrScalerAwsCloneStrategy build(){
            return mrScalerAwsCloneStrategy;
        }

    }

    @JsonIgnore
    public Boolean isOriginClusterIdSet(){ return isSet.contains("originClusterId"); }

    @JsonIgnore
    public Boolean isIncludeStepsSet(){ return isSet.contains("includeSteps"); }

    @JsonIgnore
    public Boolean isNumberOfRetriesSet(){ return isSet.contains("numberOfRetries"); }
}
