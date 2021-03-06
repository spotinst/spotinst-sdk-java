package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
