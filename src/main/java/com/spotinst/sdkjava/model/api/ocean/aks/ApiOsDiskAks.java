package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

public class ApiOsDiskAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>               isSet;
    private Integer                   sizeGB;


    public ApiOsDiskAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
    }

    @JsonIgnore
    public boolean isSizeGBSet() {
        return isSet.contains("sizeGB");
    }
}
