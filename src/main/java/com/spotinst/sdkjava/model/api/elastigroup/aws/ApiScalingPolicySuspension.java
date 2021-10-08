package com.spotinst.sdkjava.model.api.elastigroup.aws;

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
public class ApiScalingPolicySuspension implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     ttlInMinutes;

    public ApiScalingPolicySuspension() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getTtlInMinutes() {
        return ttlInMinutes;
    }

    public void setTtlInMinutes(Integer ttlInMinutes) {
        isSet.add("ttlInMinutes");
        this.ttlInMinutes = ttlInMinutes;
    }

    @JsonIgnore
    public boolean isTtlInMinutesSet() {
        return isSet.contains("ttlInMinutes");
    }
}
