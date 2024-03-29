package com.spotinst.sdkjava.model.api.oceanCD.response;

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
public class ApiVersionStatus implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         version;
    private String                         k8sService;
    private Integer                        trafficPercentage;
    private ApiVersionStatusReplicas       replicas;

    private ApiVersionStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        isSet.add("version");
        this.version = version;
    }

    public String getK8sService() {
        return k8sService;
    }

    public void setK8sService(String k8sService) {
        isSet.add("k8sService");
        this.k8sService = k8sService;
    }

    public Integer getTrafficPercentage() {
        return trafficPercentage;
    }

    public void setTrafficPercentage(Integer trafficPercentage) {
        isSet.add("trafficPercentage");
        this.trafficPercentage = trafficPercentage;
    }

    public ApiVersionStatusReplicas getReplicas() {
        return replicas;
    }

    public void setReplicas(ApiVersionStatusReplicas replicas) {
        isSet.add("replicas");
        this.replicas = replicas;
    }

    @JsonIgnore
    public boolean isVersionSet() {
        return isSet.contains("version");
    }

    @JsonIgnore
    public boolean isK8sServiceSet() {
        return isSet.contains("k8sService");
    }

    @JsonIgnore
    public boolean isTrafficPercentageSet() {
        return isSet.contains("trafficPercentage");
    }

    @JsonIgnore
    public boolean isReplicasSet() {
        return isSet.contains("replicas");
    }
}