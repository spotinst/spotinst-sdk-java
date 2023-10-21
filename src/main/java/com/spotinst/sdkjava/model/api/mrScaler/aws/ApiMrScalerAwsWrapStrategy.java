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
public class ApiMrScalerAwsWrapStrategy implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      sourceClusterId;

    public ApiMrScalerAwsWrapStrategy() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getSourceClusterId(){ return sourceClusterId; }

    public void setSourceClusterId(String sourceClusterId){
        isSet.add("sourceClusterId");
        this.sourceClusterId = sourceClusterId;
    }

    @JsonIgnore
    public Boolean isSourceClusterIdSet(){ return isSet.contains("sourceClusterId"); }
}
