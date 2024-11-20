package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsCloneStrategy implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      originClusterId;
    private Boolean     includeSteps;
    private Integer     numberOfRetries;

    public ApiMrScalerAwsCloneStrategy() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOriginClusterId(){ return originClusterId;}

    public void setOriginClusterId(String originClusterId){
        isSet.add("originClusterId");
        this.originClusterId = originClusterId;
    }

    public Boolean getIncludeSteps(){ return includeSteps;}

    public void setIncludeSteps(Boolean includeSteps){
        isSet.add("includeSteps");
        this.includeSteps = includeSteps;
    }

    public Integer getNumberOfRetries(){ return numberOfRetries;}

    public void setNumberOfRetries(Integer numberOfRetries){
        isSet.add("numberOfRetries");
        this.numberOfRetries = numberOfRetries;
    }

    @JsonIgnore
    public Boolean isOriginClusterIdSet(){ return isSet.contains("originClusterId"); }

    @JsonIgnore
    public Boolean isIncludeStepsSet(){ return isSet.contains("includeSteps"); }

    @JsonIgnore
    public Boolean isNumberOfRetriesSet(){ return isSet.contains("numberOfRetries"); }
}
