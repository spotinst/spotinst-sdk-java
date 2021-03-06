package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsScalingDimenation {
    //region Members
    private String name;
    private String value;

    //region Constructor
    public BlMrScalerAwsScalingDimenation() {
    }
    // endregion

    //region getters and setters
    // region name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    // region value
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    // endregion
    // endregion
}
