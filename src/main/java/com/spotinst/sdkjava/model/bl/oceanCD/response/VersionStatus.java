package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VersionStatus {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         version;
    private String                         k8sService;
    private Integer                        trafficPercentage;
    private VersionStatusReplicas          replicas;

    private VersionStatus() {
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

    public VersionStatusReplicas getReplicas() {
        return replicas;
    }

    public void setReplicas(VersionStatusReplicas replicas) {
        isSet.add("replicas");
        this.replicas = replicas;
    }

    public static class Builder {
        private VersionStatus versionStatus;

        private Builder() {
            this.versionStatus = new VersionStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVersion(final String version) {
            versionStatus.setVersion(version);
            return this;
        }

        public Builder setK8sService(final String k8sService) {
            versionStatus.setK8sService(k8sService);
            return this;
        }

        public Builder setTrafficPercentage(final Integer trafficPercentage) {
            versionStatus.setTrafficPercentage(trafficPercentage);
            return this;
        }

        public Builder setReplicas(final VersionStatusReplicas replicas) {
            versionStatus.setReplicas(replicas);
            return this;
        }

        public VersionStatus build() {
            return versionStatus;
        }
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