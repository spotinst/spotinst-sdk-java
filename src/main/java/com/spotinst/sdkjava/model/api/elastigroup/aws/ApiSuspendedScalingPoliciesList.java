package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiSuspendedScalingPoliciesList implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                     isSet;
    private List<ApiSuspendedScalingPolicy> scalePolicySuspensions;

    public ApiSuspendedScalingPoliciesList() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiSuspendedScalingPolicy> getScalePolicySuspensions() {
        return scalePolicySuspensions;
    }

    public void setScalePolicySuspensions(List<ApiSuspendedScalingPolicy> scalePolicySuspensions) {
        isSet.add("scalePolicySuspensions");
        this.scalePolicySuspensions = scalePolicySuspensions;
    }

    @JsonIgnore
    public boolean isScalePolicySuspensionsSet() {
        return isSet.contains("scalePolicySuspensions");
    }
}
