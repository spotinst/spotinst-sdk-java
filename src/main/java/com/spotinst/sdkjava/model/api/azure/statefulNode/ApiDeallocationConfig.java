package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDeallocationConfig implements IPartialUpdateEntity {


    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeallocate;
    private Integer     ttlInHours;

    public ApiDeallocationConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldDeallocate() {
        return shouldDeallocate;
    }

    public void setShouldDeallocate(Boolean shouldDeallocate) {
        isSet.add("shouldDeallocate");
        this.shouldDeallocate = shouldDeallocate;
    }

    public Integer getTtlInHours() {
        return ttlInHours;
    }

    public void setTtlInHours(Integer ttlInHours) {
        isSet.add("ttlInHours");
        this.ttlInHours = ttlInHours;
    }

    @JsonIgnore
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }

    @JsonIgnore
    public boolean isTtlInHoursSet() {
        return isSet.contains("ttlInHours");
    }
}
