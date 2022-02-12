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
public class ApiElastigroupScaleDownResponseGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ApiElastigroupScaleDownVictimGcp>  victimPreemptibles;
    private List<ApiElastigroupScaleDownVictimGcp> victimInstances;

    public ApiElastigroupScaleDownResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupScaleDownVictimGcp> getVictimPreemptibles() {
        return victimPreemptibles;
    }

    public void setVictimPreemptibles(List<ApiElastigroupScaleDownVictimGcp> victimPreemptibles) {
        isSet.add("victimPreemptibles");
        this.victimPreemptibles = victimPreemptibles;
    }

    public List<ApiElastigroupScaleDownVictimGcp> getVictimInstances() {
        return victimInstances;
    }

    public void setVictimInstances(List<ApiElastigroupScaleDownVictimGcp> victimInstances) {
        isSet.add("victimInstances");
        this.victimInstances = victimInstances;
    }

    @JsonIgnore
    public boolean isVictimPreemptiblesSet() {
        return isSet.contains("victimPreemptibles");
    }

    @JsonIgnore
    public boolean isVictimInstancesSet() {
        return isSet.contains("victimInstances");
    }

}
