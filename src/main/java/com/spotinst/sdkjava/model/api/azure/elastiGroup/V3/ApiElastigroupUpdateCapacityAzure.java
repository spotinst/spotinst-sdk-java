package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupUpdateCapacityAzure {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     minimum;
    private Integer     maximum;
    private Integer     target;

    public ApiElastigroupUpdateCapacityAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        isSet.add("minimum");
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        isSet.add("maximum");
        this.maximum = maximum;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        isSet.add("target");
        this.target = target;
    }

    @JsonIgnore
    public boolean isMinimumSet() {
        return isSet.contains("minimum");
    }

    @JsonIgnore
    public boolean isMaximumSet() {
        return isSet.contains("maximum");
    }

    @JsonIgnore
    public boolean isTargetSet() {
        return isSet.contains("target");
    }

}
