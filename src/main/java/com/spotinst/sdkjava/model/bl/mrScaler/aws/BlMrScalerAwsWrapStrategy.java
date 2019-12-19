package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsWrapStrategy {
    //region Members
    private String sourceClusterId;
    // endregion

    //region Constructor
    public BlMrScalerAwsWrapStrategy() {
    }
    // endregion

    // region methods
    // region sourceClusterId
    public String getSourceClusterId() {
        return sourceClusterId;
    }

    public void setSourceClusterId(String sourceClusterId) {
        this.sourceClusterId = sourceClusterId;
    }
    // endregion
    // endregion
}
