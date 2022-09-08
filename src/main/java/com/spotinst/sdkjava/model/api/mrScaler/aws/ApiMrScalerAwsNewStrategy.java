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
public class ApiMrScalerAwsNewStrategy implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      releaseLabel;
    private Integer     numberOfRetries;
    // endregion

    //region Constructor
    public ApiMrScalerAwsNewStrategy() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getReleaseLabel(){ return releaseLabel; }

    public void setReleaseLabel(String releaseLabel){
        isSet.add("releaseLabel");
        this.releaseLabel = releaseLabel;
    }

    public Integer getNumberOfRetries(){ return numberOfRetries;}

    public void setNumberOfRetries(Integer numberOfRetries){
        isSet.add("numberOfRetries");
        this.numberOfRetries = numberOfRetries;
    }

    @JsonIgnore
    public Boolean isNumberOfRetriesSet(){ return isSet.contains("numberOfRetries"); }

    @JsonIgnore
    public Boolean isReleaseLabelSet(){ return isSet.contains("releaseLabel"); }
}
