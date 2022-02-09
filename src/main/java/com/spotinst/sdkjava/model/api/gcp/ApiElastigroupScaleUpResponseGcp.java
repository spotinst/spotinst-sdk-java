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
    private List<ApiElastigroupScaleUpNewInstancesPreemptiblesGcp>  newPreemptiblesList;
    private List<ApiElastigroupScaleUpNewInstancesPreemptiblesGcp>     newInstancesList;

    public ApiElastigroupScaleUpResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupScaleUpNewInstancesPreemptiblesGcp> getNewPreemptiblesList() {
        return newPreemptiblesList;
    }

    public void setNewPreemptibles(List<ApiElastigroupScaleUpNewInstancesPreemptiblesGcp> newPreemptiblesList) {
        isSet.add("newPreemptiblesList");
        this.newPreemptiblesList = newPreemptiblesList;
    }

    public List<ApiElastigroupScaleUpNewInstancesPreemptiblesGcp> getNewInstancesList() {
        return newInstancesList;
    }

    public void setNewInstances(List<ApiElastigroupScaleUpNewInstancesPreemptiblesGcp> newInstancesList) {
        isSet.add("newInstancesList");
        this.newInstancesList = newInstancesList;
    }

    @JsonIgnore
    public boolean isNewPreemptiblesSet() {
        return isSet.contains("newPreemptiblesList");
    }

    @JsonIgnore
    public boolean isNewInstancesSet() {
        return isSet.contains("newInstancesList");
    }

}
