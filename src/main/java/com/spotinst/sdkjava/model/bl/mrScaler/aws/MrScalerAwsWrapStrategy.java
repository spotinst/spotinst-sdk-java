package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsWrapStrategy {
    @JsonIgnore
    private Set<String> isSet;
    private String      sourceClusterId;

    private MrScalerAwsWrapStrategy() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getSourceClusterId() {
        return sourceClusterId;
    }

    public void setSourceClusterId(String sourceClusterId) {
        isSet.add("sourceClusterId");
        this.sourceClusterId = sourceClusterId;
    }

    public static class Builder {
        private MrScalerAwsWrapStrategy wrapStrategy;

        private Builder(){ this.wrapStrategy = new MrScalerAwsWrapStrategy(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setSourceClusterId(final String sourceClusterId){
            wrapStrategy.setSourceClusterId(sourceClusterId);
            return this;
        }

        public MrScalerAwsWrapStrategy build(){
            return wrapStrategy;
        }
    }

    @JsonIgnore
    public Boolean isSourceClusterIdSet(){ return isSet.contains("sourceClusterId"); }
}
