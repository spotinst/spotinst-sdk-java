package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsNewStrategy {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String releaseLabel;
    private Integer numberOfRetries;
    // endregion

    //region Constructor
    public ApiMrScalerAwsNewStrategy() { isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region releaseLabel
    public String getReleaseLabel(){ return releaseLabel; }

    public void setReleaseLabel(String releaseLabel){
        isSet.add("releaseLabel");
        this.releaseLabel = releaseLabel;
    }

    public Boolean isReleaseLabelSet(){ return isSet.contains("releaseLabel"); }
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
        private ApiMrScalerAwsNewStrategy newStrategy;

        private Builder(){ this.newStrategy = new ApiMrScalerAwsNewStrategy(); }

        public static Builder get(){
            return new Builder();
        }

        // build methods
        public Builder setReleaseLabel(final String releaseLabel){
            newStrategy.setReleaseLabel(releaseLabel);
            return this;
        }
        public Builder setNumberOfRetries(final Integer numberOfRetries){
            newStrategy.setNumberOfRetries(numberOfRetries);
            return this;
        }

        public ApiMrScalerAwsNewStrategy build(){
            return newStrategy;
        }
        // endregion
    }
}
