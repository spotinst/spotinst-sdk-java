package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsNewStrategy {
    @JsonIgnore
    private Set<String> isSet;
    private String      releaseLabel;
    private Integer     numberOfRetries;

    private MrScalerAwsNewStrategy() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getReleaseLabel() {
        return releaseLabel;
    }

    public void setReleaseLabel(String releaseLabel) {
        isSet.add("releaseLabel");
        this.releaseLabel = releaseLabel;
    }

    public Integer getNumberOfRetries() {
        return numberOfRetries;
    }

    public void setNumberOfRetries(Integer numberOfRetries) {
        isSet.add("numberOfRetries");
        this.numberOfRetries = numberOfRetries;
    }

    public static class Builder {
        private MrScalerAwsNewStrategy newStrategy;

        private Builder(){ this.newStrategy = new MrScalerAwsNewStrategy(); }

        public static Builder get(){
            Builder builder = new Builder();
            return builder;
        }

        public Builder setReleaseLabel(final String releaseLabel){
            newStrategy.setReleaseLabel(releaseLabel);
            return this;
        }
        public Builder setNumberOfRetries(final Integer numberOfRetries){
            newStrategy.setNumberOfRetries(numberOfRetries);
            return this;
        }

        public MrScalerAwsNewStrategy build(){
            return newStrategy;
        }
    }

    @JsonIgnore
    public Boolean isNumberOfRetriesSet(){ return isSet.contains("numberOfRetries"); }

    @JsonIgnore
    public Boolean isReleaseLabelSet(){ return isSet.contains("releaseLabel"); }
}
