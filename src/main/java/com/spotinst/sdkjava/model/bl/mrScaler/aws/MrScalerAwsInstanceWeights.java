package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsInstanceWeights {
    @JsonIgnore
    private Set<String> isSet;
    private String      instanceType;
    private Integer     weightedCapacity;

    private MrScalerAwsInstanceWeights() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public Integer getWeightedCapacity() {
        return weightedCapacity;
    }

    public void setWeightedCapacity(Integer weightedCapacity) {
        isSet.add("weightedCapacity");
        this.weightedCapacity = weightedCapacity;
    }

    public static class Builder {
        private MrScalerAwsInstanceWeights instanceWeights;

        private Builder() { this.instanceWeights = new MrScalerAwsInstanceWeights(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;

        }

        public Builder setInstanceType(final String instanceType) {
            instanceWeights.setInstanceType(instanceType);
            return this;
        }

        protected Builder setWeightedCapacity(final Integer weightedCapacity) {
            instanceWeights.setWeightedCapacity(weightedCapacity);
            return this;
        }

        public MrScalerAwsInstanceWeights build(){
            return instanceWeights;
        }
    }

    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

    @JsonIgnore
    public boolean isWeightedCapacitySet() {
        return isSet.contains("weightedCapacity");
    }
}
