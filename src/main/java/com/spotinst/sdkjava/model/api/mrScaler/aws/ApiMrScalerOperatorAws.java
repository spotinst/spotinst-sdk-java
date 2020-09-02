package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerOperatorAws extends ApiMrScalerAws {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    // endregion

    //region Constructor
    public ApiMrScalerOperatorAws() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region Name
    public String getOperatorName() {
        return name;
    }

    public void setOperatorName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean isOperatorNameSet(){
        return isSet.contains("name");
    }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerOperatorAws apiMrScalerOperatorAws;
        private Builder() { this.apiMrScalerOperatorAws = new ApiMrScalerOperatorAws(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;

        }

        //region Build methods
        public Builder setOperatorName(final String name) {
            apiMrScalerOperatorAws.setOperatorName(name);
            return this;
        }

        public Builder setName(final String name) {
            apiMrScalerOperatorAws.setName(name);
            return this;
        }
        protected Builder setId(final String id) {
            apiMrScalerOperatorAws.setId(id);
            return this;
        }

        public Builder setDescription(final String description) {
            apiMrScalerOperatorAws.setDescription(description);
            return this;
        }

        public Builder setRegion(final String mrScalerRegion) {
            apiMrScalerOperatorAws.setRegion(mrScalerRegion);
            return this;
        }

        public Builder setStrategy(final ApiMrScalerAwsStrategyConfiguration strategy){
            apiMrScalerOperatorAws.setStrategy(strategy);
            return this;
        }

        public Builder setCompute(final ApiMrScalerAwsComputeConfiguration compute){
            apiMrScalerOperatorAws.setCompute(compute);
            return this;
        }

        public Builder setCluster(final ApiMrScalerAwsClusterConfiguration cluster){
            apiMrScalerOperatorAws.setCluster(cluster);
            return this;
        }

        public Builder setScaling(final ApiMrScalerAwsScalingConfiguration scaling){
            apiMrScalerOperatorAws.setScaling(scaling);
            return this;
        }

        public Builder seCoretScaling(final ApiMrScalerAwsScalingConfiguration coreScaling){
            apiMrScalerOperatorAws.setCoreScaling(coreScaling);
            return this;
        }

        public Builder setScheduling(final ApiMrScalerAwsSchedulingConfiguration scheduling){
            apiMrScalerOperatorAws.setScheduling(scheduling);
            return this;
        }

        public ApiMrScalerOperatorAws build(){
            return apiMrScalerOperatorAws;
        }
        // endregion
    }
}
