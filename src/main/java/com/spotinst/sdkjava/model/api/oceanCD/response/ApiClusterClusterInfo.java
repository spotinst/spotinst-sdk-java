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
public class ApiClusterClusterInfo implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 kubernetesVersion;
    private String                 cloudProvider;
    private String                 kubernetesOrchestrator;

    private ApiClusterClusterInfo() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getKubernetesVersion() {
        return kubernetesVersion;
    }

    public void setKubernetesVersion(String kubernetesVersion) {
        isSet.add("kubernetesVersion");
        this.kubernetesVersion = kubernetesVersion;
    }

    public String getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        isSet.add("cloudProvider");
        this.cloudProvider = cloudProvider;
    }

    public String getKubernetesOrchestrator() {
        return kubernetesOrchestrator;
    }

    public void setKubernetesOrchestrator(String kubernetesOrchestrator) {
        isSet.add("kubernetesOrchestrator");
        this.kubernetesOrchestrator = kubernetesOrchestrator;
    }

    @JsonIgnore
    public boolean isKubernetesVersionSet() {
        return isSet.contains("kubernetesVersion");
    }

    @JsonIgnore
    public boolean isCloudProviderSet() {
        return isSet.contains("cloudProvider");
    }

    @JsonIgnore
    public boolean isKubernetesOrchestratorSet() {
        return isSet.contains("kubernetesOrchestrator");
    }
}