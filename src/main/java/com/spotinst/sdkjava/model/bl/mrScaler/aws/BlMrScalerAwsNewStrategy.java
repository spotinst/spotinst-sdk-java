package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsNewStrategy {
    //region Members
    private String  releaseLabel;
    private Integer numberOfRetries;
    // endregion

    //region Constructor
    public BlMrScalerAwsNewStrategy() {
    }
    // endregion

    // region methods
    // region releaseLabel
    public String getReleaseLabel() {
        return releaseLabel;
    }

    public void setReleaseLabel(String releaseLabel) {
        this.releaseLabel = releaseLabel;
    }
    // endregion

    // region numberOfRetries
    public Integer getNumberOfRetries() {
        return numberOfRetries;
    }

    public void setNumberOfRetries(Integer numberOfRetries) {
        this.numberOfRetries = numberOfRetries;
    }
    // endregion
    // endregion
}
