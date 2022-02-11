package com.spotinst.sdkjava.model.api.gcp;

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
public class ApiElastigroupScaleUpResponseGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ApiElastigroupScaleUpNewInstancesGcp>     newPreemptibles;
    private List<ApiElastigroupScaleUpNewInstancesGcp>     newInstances;

    public ApiElastigroupScaleUpResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupScaleUpNewInstancesGcp> getNewPreemptibles() {
        return newPreemptibles;
    }

    public void setNewPreemptibles(List<ApiElastigroupScaleUpNewInstancesGcp> newPreemptibles) {
        isSet.add("newPreemptibles");
        this.newPreemptibles = newPreemptibles;
    }

    public List<ApiElastigroupScaleUpNewInstancesGcp> getNewInstances() {
        return newInstances;
    }

    public void setNewInstances(List<ApiElastigroupScaleUpNewInstancesGcp> newInstances) {
        isSet.add("newInstances");
        this.newInstances = newInstances;
    }

    @JsonIgnore
    public boolean isNewPreemptiblesSet() {
        return isSet.contains("newPreemptibles");
    }

    @JsonIgnore
    public boolean isNewInstancesSet() {
        return isSet.contains("newInstances");
    }

}
