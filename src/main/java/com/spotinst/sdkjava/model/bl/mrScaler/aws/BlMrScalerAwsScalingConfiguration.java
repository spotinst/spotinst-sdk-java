package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsScalingConfiguration {
    //region Members
    private List<BlMrScalerAwsScalingPolicy> up;
    private List<BlMrScalerAwsScalingPolicy> down;

    // endregion

    //region Constructor
    public BlMrScalerAwsScalingConfiguration() {
    }
    // endregion

    //region getters and setters
    // region up
    public List<BlMrScalerAwsScalingPolicy> getUp() {
        return up;
    }

    public void setUp(List<BlMrScalerAwsScalingPolicy> up) {
        this.up = up;
    }
    // endregion

    // region down
    public List<BlMrScalerAwsScalingPolicy> getDown() {
        return down;
    }

    public void setDown(List<BlMrScalerAwsScalingPolicy> down) {
        this.down = down;
    }
    // endregion
    // endregion
}
