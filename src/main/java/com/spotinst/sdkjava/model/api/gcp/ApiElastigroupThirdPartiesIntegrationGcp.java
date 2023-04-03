package com.spotinst.sdkjava.model.api.gcp;

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
public class ApiElastigroupThirdPartiesIntegrationGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                         isSet;
    private ApiElastigroupDockerSwarmGcp        dockerSwarm;
    private ApiElastigroupGkeConfigurationGcp   gke;

    public ApiElastigroupThirdPartiesIntegrationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiElastigroupDockerSwarmGcp getDockerSwarm() {
        return dockerSwarm;
    }

    public void setDockerSwarm(ApiElastigroupDockerSwarmGcp dockerSwarm) {
        isSet.add("dockerSwarm");
        this.dockerSwarm = dockerSwarm;
    }

    public ApiElastigroupGkeConfigurationGcp getGke() {
        return gke;
    }

    public void setGke(ApiElastigroupGkeConfigurationGcp gke) {
        isSet.add("gke");
        this.gke = gke;
    }

    @JsonIgnore
    public boolean isDockerSwarmSet() {
        return isSet.contains("dockerSwarm");
    }

    @JsonIgnore
    public boolean isGkeSet() {
        return isSet.contains("gke");
    }
}
