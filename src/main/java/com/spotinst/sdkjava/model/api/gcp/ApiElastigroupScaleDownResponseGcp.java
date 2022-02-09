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
    private List<ApiElastigroupScaleDownVictimInstancesPreemptiblesGcp>  victimPreemptiblesList;
    private List<ApiElastigroupScaleDownVictimInstancesPreemptiblesGcp> victimInstancesList;

    public ApiElastigroupScaleDownResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupScaleDownVictimInstancesPreemptiblesGcp> getVictimPreemptiblesList() {
        return victimPreemptiblesList;
    }

    public void setVictimPreemptibles(List<ApiElastigroupScaleDownVictimInstancesPreemptiblesGcp> victimPreemptiblesList) {
        isSet.add("victimPreemptiblesList");
        this.victimPreemptiblesList = victimPreemptiblesList;
    }

    public List<ApiElastigroupScaleDownVictimInstancesPreemptiblesGcp> getVictimInstancesList() {
        return victimInstancesList;
    }

    public void setVictimInstancesList(List<ApiElastigroupScaleDownVictimInstancesPreemptiblesGcp> victimInstancesList) {
        isSet.add("victimInstancesList");
        this.victimInstancesList = victimInstancesList;
    }

    @JsonIgnore
    public boolean isVictimPreemptiblesListSet() {
        return isSet.contains("victimPreemptiblesList");
    }

    @JsonIgnore
    public boolean isVictimInstancesListSet() {
        return isSet.contains("victimInstancesList");
    }

}
