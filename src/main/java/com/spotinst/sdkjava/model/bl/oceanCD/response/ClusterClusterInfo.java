package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterClusterInfo {
    @JsonIgnore
    private Set<String>            isSet;
    private String                 kubernetesVersion;
    private String                 cloudProvider;
    private String                 kubernetesOrchestrator;

    private ClusterClusterInfo() {
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

    public static class Builder {
        private ClusterClusterInfo clusterClusterInfo;

        private Builder() {
            this.clusterClusterInfo = new ClusterClusterInfo();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setKubernetesVersion(final String kubernetesVersion) {
            clusterClusterInfo.setKubernetesVersion(kubernetesVersion);
            return this;
        }

        public Builder setCloudProvider(final String cloudProvider) {
            clusterClusterInfo.setCloudProvider(cloudProvider);
            return this;
        }

        public Builder setKubernetesOrchestrator(final String kubernetesOrchestrator) {
            clusterClusterInfo.setKubernetesOrchestrator(kubernetesOrchestrator);
            return this;
        }

        public ClusterClusterInfo build() {
            return clusterClusterInfo;
        }
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