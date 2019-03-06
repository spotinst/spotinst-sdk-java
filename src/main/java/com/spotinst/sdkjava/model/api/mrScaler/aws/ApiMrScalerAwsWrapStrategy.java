package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsWrapStrategy {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String sourceClusterId;
    // endregion

    //region Constructor
    public ApiMrScalerAwsWrapStrategy() { isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region sourceClusterId
    public String getSourceClusterId(){ return sourceClusterId; }

    public void setSourceClusterId(String sourceClusterId){
        isSet.add("sourceClusterId");
        this.sourceClusterId = sourceClusterId;
    }

    public Boolean isSourceClusterIdSet(){ return isSet.contains("sourceClusterId"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsWrapStrategy wrapStrategy;

        private Builder(){ this.wrapStrategy = new ApiMrScalerAwsWrapStrategy(); }

        public static Builder get(){
            return new Builder();
        }

        // region builder methods
        public Builder setSourceClusterId(final String sourceClusterId){
            wrapStrategy.setSourceClusterId(sourceClusterId);
            return this;
        }

        public ApiMrScalerAwsWrapStrategy build(){
            return wrapStrategy;
        }
        // endregion
    }
}
