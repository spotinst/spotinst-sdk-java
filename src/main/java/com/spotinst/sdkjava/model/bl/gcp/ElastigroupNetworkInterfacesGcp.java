package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupNetworkInterfacesGcp {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String network;
    private String projectId;
    //endregion

    //region Constructors
    private ElastigroupNetworkInterfacesGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //region ProjectId
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        isSet.add("projectId");
        this.projectId = projectId;
    }
    //endregion

    //region Network
    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        isSet.add("network");
        this.network = network;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupNetworkInterfacesGcp instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupNetworkInterfacesGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setNetwork(final String networkType) {
            instanceTypes.setNetwork(networkType);
            return this;
        }

        public Builder setProjectId(final String projectIdType) {
            instanceTypes.setProjectId(projectIdType);
            return this;
        }

        public ElastigroupNetworkInterfacesGcp build() {
            return instanceTypes;
        }
    }
    //endregion

    //region isSet methods
    // Is network Set boolean method
    @JsonIgnore
    public boolean isNetworkSet() { return isSet.contains("network"); }

    // Is projectId Set boolean method
    @JsonIgnore
    public boolean isProjectIdSet() { return isSet.contains("projectId"); }
    //endregion
}
