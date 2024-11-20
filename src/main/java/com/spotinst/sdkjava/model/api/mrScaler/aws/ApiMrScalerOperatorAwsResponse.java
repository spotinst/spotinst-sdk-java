package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.AwsMrScalerStateEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerOperatorAwsResponse {
    @JsonIgnore
    private Set<String>          isSet;
    private String               name;
    private String               mrScalerId;
    private AwsMrScalerStateEnum state;

    public ApiMrScalerOperatorAwsResponse() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        isSet.add("mrScalerId");
        this.mrScalerId = mrScalerId;
    }

    public AwsMrScalerStateEnum getState() {
        return state;
    }

    public void setState(AwsMrScalerStateEnum state) {
        isSet.add("state");
        this.state = state;
    }

    @JsonIgnore
    public Boolean isNameSet(){
        return isSet.contains("name");
    }

    @JsonIgnore
    public Boolean isMrScalerIdSet(){
        return isSet.contains("mrScalerId");
    }

    @JsonIgnore
    public Boolean isStateSet(){
        return isSet.contains("state");
    }

}
