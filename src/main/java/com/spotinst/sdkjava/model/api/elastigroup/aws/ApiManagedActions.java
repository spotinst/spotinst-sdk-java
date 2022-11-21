package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.BeanstalkPlatformUpdate;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiManagedActions implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private ApiBeanstalkPlatformUpdate      platformUpdate;
    //endregion

    //region Constructors
    public ApiManagedActions() {
        isSet = new HashSet<>();
    }
    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiBeanstalkPlatformUpdate getPlatformUpdate() {
        return platformUpdate;
    }

    public void setPlatformUpdate(ApiBeanstalkPlatformUpdate platformUpdate) {
        isSet.add("platformUpdate");
        this.platformUpdate = platformUpdate;
    }

    //endregion

    //region isSet methods
    // Is platformUpdate Set boolean method
    @JsonIgnore
    public boolean isPlatformUpdateSet() {
        return isSet.contains("platformUpdate");
    }
    //endregion
}
