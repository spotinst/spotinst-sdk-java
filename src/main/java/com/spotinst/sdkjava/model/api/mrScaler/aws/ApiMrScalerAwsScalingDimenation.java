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
public class ApiMrScalerAwsScalingDimenation implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      value;

    public ApiMrScalerAwsScalingDimenation() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        isSet.add("name");
        this.name = name;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        isSet.add("value");
        this.value = value;
    }

    @JsonIgnore
    public Boolean isNameSet(){
        return isSet.contains("name");
    }

    @JsonIgnore
    public Boolean isValueSet(){
        return isSet.contains("value");
    }
}
