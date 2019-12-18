package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlMrScalerAwsApplication {
    //region Members
    private String name;
    private String version;

    // endregion

    //region Constructor
    public BlMrScalerAwsApplication() {
    }
    // endregion


    // region methods
    // region name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    // region version
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    // endregion
    // endregion
}
