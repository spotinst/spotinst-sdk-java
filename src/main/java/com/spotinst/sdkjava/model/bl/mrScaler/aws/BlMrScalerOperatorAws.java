package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerOperatorAws {

    //region Members
    private String        name;
    private BlMrScalerAws mrScaler;
    //endregion

    //region getters and setters
    // region Name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    // region mrScaler
    public BlMrScalerAws getMrScaler() {
        return mrScaler;
    }

    public void setMrScaler(BlMrScalerAws mrScaler) {
        this.mrScaler = mrScaler;
    }
    // endregion
    //endregion
}
