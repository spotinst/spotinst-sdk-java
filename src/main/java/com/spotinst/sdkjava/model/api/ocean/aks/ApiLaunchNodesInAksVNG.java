package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiLaunchNodesInAksVNG implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                      isSet;
    private Integer                         amount;

    public ApiLaunchNodesInAksVNG() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        isSet.add("amount");
        this.amount = amount;
    }

    @JsonIgnore
    public boolean isAmountSet() {
        return isSet.contains("amount");
    }
}