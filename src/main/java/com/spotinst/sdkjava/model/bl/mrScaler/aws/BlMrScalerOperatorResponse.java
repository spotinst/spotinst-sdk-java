package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.AwsMrScalerStateEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerOperatorResponse {
    //region Members
    private String               name;
    private String               mrScalerId;
    private AwsMrScalerStateEnum state;
    //endregion

    //region getters and setters
    // region Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    // region MrScalerId
    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        this.mrScalerId = mrScalerId;
    }
    // endregion

    //region State
    public AwsMrScalerStateEnum getState() {
        return state;
    }

    public void setState(AwsMrScalerStateEnum state) {
        this.state = state;
    }
    // endregion
    //endregion


}
