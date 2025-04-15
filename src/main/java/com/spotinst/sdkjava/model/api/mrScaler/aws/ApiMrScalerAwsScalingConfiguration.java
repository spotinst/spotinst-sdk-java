package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsScalingConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private List<ApiMrScalerAwsScalingPolicy> up;
    private List<ApiMrScalerAwsScalingPolicy> down;

    public ApiMrScalerAwsScalingConfiguration() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiMrScalerAwsScalingPolicy> getUp(){
        return up;
    }

    public void setUp(List<ApiMrScalerAwsScalingPolicy> up){
        isSet.add("up");
        this.up = up;
    }

    public List<ApiMrScalerAwsScalingPolicy> getDown(){
        return down;
    }

    public void setDown(List<ApiMrScalerAwsScalingPolicy> down){
        isSet.add("down");
        this.down = down;
    }

    @JsonIgnore
    public Boolean isUpSet(){
        return isSet.contains("up");
    }

    @JsonIgnore
    public Boolean isDownSet(){
        return isSet.contains("down");
    }
}
