package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerOperatorResponse {
    //region Members
    private String name;
    private String mrScalerId;
    private String status;
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

    //region Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // endregion
    //endregion


}
