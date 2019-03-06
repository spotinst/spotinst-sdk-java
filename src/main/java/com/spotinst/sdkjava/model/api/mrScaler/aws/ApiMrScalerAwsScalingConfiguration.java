package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ApiMrScalerAwsScalingConfiguration {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<ApiMrScalerAwsScalingPolicy> up;
    private List<ApiMrScalerAwsScalingPolicy> down;

    // endregion

    //region Constructor
    public ApiMrScalerAwsScalingConfiguration() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region up
    public List<ApiMrScalerAwsScalingPolicy> getUp(){
        return up;
    }

    public void setUp(List<ApiMrScalerAwsScalingPolicy> up){
        isSet.add("up");
        this.up = up;
    }

    public Boolean isUpSet(){
        return isSet.contains("up");
    }
    // endregion

    // region down
    public List<ApiMrScalerAwsScalingPolicy> getDown(){
        return down;
    }

    public void setDown(List<ApiMrScalerAwsScalingPolicy> down){
        isSet.add("down");
        this.down = down;
    }

    public Boolean isDownSet(){
        return isSet.contains("down");
    }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsScalingConfiguration scaling;

        private Builder(){ this.scaling = new ApiMrScalerAwsScalingConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setUp(final List<ApiMrScalerAwsScalingPolicy> up){
            scaling.setUp(up);
            return this;
        }
        public Builder setDown(final List<ApiMrScalerAwsScalingPolicy> down){
            scaling.setDown(down);
            return this;
        }

        public ApiMrScalerAwsScalingConfiguration build(){
            return scaling;
        }
        // endregion
    }
}
