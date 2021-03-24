package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiLoadBalancersConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ApiLaunchSpecificationAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                  isSet;
    private List<ApiExtensionAks>        extensions;
    private ApiImageAks                  image;
    private ApiLoadBalancersConfig       loadBalancersConfig;
    private ApiLoginAks                  login;

    public ApiLaunchSpecificationAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    @JsonIgnore
    public boolean isYYYSet() {
        return isSet.contains("yyy");
    }
}
