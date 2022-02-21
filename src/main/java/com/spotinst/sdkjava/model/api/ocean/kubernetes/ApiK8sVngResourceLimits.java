package com.spotinst.sdkjava.model.api.ocean.kubernetes;

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
public class ApiK8sVngResourceLimits implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private Integer                    maxInstanceCount;
    private Integer                    minInstanceCount;

    public ApiK8sVngResourceLimits() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMaxInstanceCount() {
        return maxInstanceCount;
    }

    public void setMaxInstanceCount(Integer maxInstanceCount) {
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    public Integer getMinInstanceCount() {
        return minInstanceCount;
    }

    public void setMinInstanceCount(Integer minInstanceCount) {
        isSet.add("minInstanceCount");
        this.minInstanceCount = minInstanceCount;
    }

    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }

    @JsonIgnore
    public boolean isMinInstanceCountSet() {
        return isSet.contains("minInstanceCount");
    }
}
