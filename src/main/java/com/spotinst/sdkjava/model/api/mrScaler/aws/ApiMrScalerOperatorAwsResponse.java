package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AwsMrScalerStateEnum;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerOperatorAwsResponse {
    //region Members
    @JsonIgnore
    private Set<String>          isSet;
    private String               name;
    private String               mrScalerId;
    private AwsMrScalerStateEnum state;
    //endregion

    //region Constructor
    public ApiMrScalerOperatorAwsResponse() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    //region Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean isNameSet(){
        return isSet.contains("name");
    }
    //endregion

    //region MrScalerId
    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        isSet.add("mrScalerId");
        this.mrScalerId = mrScalerId;
    }

    public Boolean isMrScalerIdSet(){
        return isSet.contains("mrScalerId");
    }
    //endregion

    //region State
    public AwsMrScalerStateEnum getState() {
        return state;
    }

    public void setState(AwsMrScalerStateEnum state) {
        isSet.add("state");
        this.state = state;
    }

    public Boolean isStateSet(){
        return isSet.contains("state");
    }
    //endregion
    //endregion
}
