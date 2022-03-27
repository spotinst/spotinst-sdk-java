package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterNetworkInterfacesConfiguration {

    @JsonIgnore
    private Set<String>                                 isSet;
    private String                                      network;
    private String                                      projectId;
    private List<ClusterAccessConfigsSpecification>     accessConfigs;
    private List<ClusterAliasIpRangesSpecification>     aliasIpRanges;

    //region Constructors
    private ClusterNetworkInterfacesConfiguration() {
        isSet = new HashSet<>();
    }

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        isSet.add("projectId");
        this.projectId = projectId;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        isSet.add("network");
        this.network = network;
    }

    public List<ClusterAccessConfigsSpecification>  getAccessConfigs() {
        return accessConfigs;
    }

    public void setAccessConfigs(List<ClusterAccessConfigsSpecification>  accessConfigs) {
        isSet.add("accessConfigs");
        this.accessConfigs = accessConfigs;
    }

    public List<ClusterAliasIpRangesSpecification> getAliasIpRanges() {
        return aliasIpRanges;
    }

    public void setAliasIpRanges(List<ClusterAliasIpRangesSpecification> aliasIpRanges) {
        isSet.add("aliasIpRanges");
        this.aliasIpRanges = aliasIpRanges;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ClusterNetworkInterfacesConfiguration networkInterfaces;

        private Builder() {
            this.networkInterfaces = new ClusterNetworkInterfacesConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setNetwork(final String networkType) {
            networkInterfaces.setNetwork(networkType);
            return this;
        }

        public Builder setProjectId(final String projectIdType) {
            networkInterfaces.setProjectId(projectIdType);
            return this;
        }

        public Builder setAccessConfigs(final List<ClusterAccessConfigsSpecification> accessConfigs) {
            networkInterfaces.setAccessConfigs(accessConfigs);
            return this;
        }

        public Builder setAliasIpRanges(final List<ClusterAliasIpRangesSpecification> aliasIpRanges) {
            networkInterfaces.setAliasIpRanges(aliasIpRanges);
            return this;
        }
        public ClusterNetworkInterfacesConfiguration build() {
            return networkInterfaces;
        }
    }
    //endregion

    @JsonIgnore
    public boolean isNetworkSet() { return isSet.contains("network"); }

    @JsonIgnore
    public boolean isProjectIdSet() { return isSet.contains("projectId"); }

    @JsonIgnore
    public boolean isAccessConfigsSet() { return isSet.contains("accessConfigs"); }

    @JsonIgnore
    public boolean isAliasIpRangesSet() { return isSet.contains("aliasIpRanges"); }

}
