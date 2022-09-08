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
public class ApiMrScalerOperatorAws implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>    isSet;
    private String         name;
    private ApiMrScalerAws mrScaler;

    public ApiMrScalerOperatorAws() {
        isSet = new HashSet<>();
    }

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

    public ApiMrScalerAws getMrScaler() {
        return mrScaler;
    }

    public void setMrScaler(ApiMrScalerAws mrScaler) {

        isSet.add("mrScaler");
        this.mrScaler = mrScaler;
    }

    @JsonIgnore
    public Boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public Boolean isMrScalerSet() {
        return isSet.contains("mrScaler");
    }
}
