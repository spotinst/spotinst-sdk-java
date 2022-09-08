package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolloutSpecSpotDeployment {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     clusterId;
    private String                     namespace;
    private String                     name;

    private RolloutSpecSpotDeployment() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        isSet.add("clusterId");
        this.clusterId = clusterId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public static class Builder {
        private RolloutSpecSpotDeployment rolloutSpecSpotDeployment;

        private Builder() {
            this.rolloutSpecSpotDeployment = new RolloutSpecSpotDeployment();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            rolloutSpecSpotDeployment.setName(name);
            return this;
        }

        public Builder setClusterId(final String clusterId) {
            rolloutSpecSpotDeployment.setClusterId(clusterId);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            rolloutSpecSpotDeployment.setNamespace(namespace);
            return this;
        }

        public RolloutSpecSpotDeployment build() {
            return rolloutSpecSpotDeployment;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isClusterIdSet() {
        return isSet.contains("clusterId");
    }

    @JsonIgnore
    public boolean isNamespaceSet() {
        return isSet.contains("namespace");
    }
}