package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiClusterNetworkInterfacesConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                     isSet;
    private String                                          network;
    private String                                          projectId;
    private List<ApiClusterAccessConfigsSpecification>      accessConfigs;
    private List<ApiClusterAliasIpRangesSpecification>      aliasIpRanges;

    //region Constructors
    public ApiClusterNetworkInterfacesConfiguration() {
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

    public List<ApiClusterAccessConfigsSpecification> getAccessConfigs() {
        return accessConfigs;
    }

    public void setAccessConfigs(List<ApiClusterAccessConfigsSpecification> accessConfigs) {
        isSet.add("accessConfigs");
        this.accessConfigs = accessConfigs;
    }

    public List<ApiClusterAliasIpRangesSpecification> getAliasIpRanges() {
        return aliasIpRanges;
    }

    public void setAliasIpRanges(List<ApiClusterAliasIpRangesSpecification> aliasIpRanges) {
        isSet.add("aliasIpRanges");
        this.aliasIpRanges = aliasIpRanges;
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
