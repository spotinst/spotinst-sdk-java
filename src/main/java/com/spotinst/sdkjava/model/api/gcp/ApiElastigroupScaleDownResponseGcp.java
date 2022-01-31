package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupScaleDownVictimInstancesListGcp;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupScaleDownVictimPreemptiblesListGcp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupScaleDownResponseGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ApiElastigroupScaleDownVictimPreemptiblesListGcp>  victimPreemptiblesList;
    private List<ApiElastigroupScaleDownVictimInstancesListGcp> victimInstancesList;

    public ApiElastigroupScaleDownResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupScaleDownVictimPreemptiblesListGcp> getVictimPreemptibles() {
        return victimPreemptiblesList;
    }

    public void setVictimPreemptibles(List<ApiElastigroupScaleDownVictimPreemptiblesListGcp> victimPreemptiblesList) {
        isSet.add("victimPreemptiblesList");
        this.victimPreemptiblesList = victimPreemptiblesList;
    }

    public List<ApiElastigroupScaleDownVictimInstancesListGcp> getVictimInstancesList() {
        return victimInstancesList;
    }

    public void setVictimInstancesList(List<ApiElastigroupScaleDownVictimInstancesListGcp> victimInstancesList) {
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
