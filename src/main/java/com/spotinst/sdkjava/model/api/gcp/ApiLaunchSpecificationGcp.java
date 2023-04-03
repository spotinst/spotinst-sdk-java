package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLaunchSpecificationGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ApiDisksGcp>                               disks;
    private List<ApiNetworkInterfacesGcp>                   networkInterfaces;
    private ApiElastigroupBackendServiceConfigGcp           backendServiceConfig;
    private String                                          instanceNamePrefix;
    private Boolean                                         ipForwarding;
    private List<ApiElastigroupMetadataGcp>                 metadata;
    private String                                          minCpuPlatform;
    private String                                          shutdownScript;
    private String                                          startupScript;
    private List<String>                                    tags;
    //endregion

    //region Constructor
    public ApiLaunchSpecificationGcp() {
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

    public List<ApiDisksGcp> getDisks() {
        return disks;
    }

    public void setDisks(List<ApiDisksGcp> disks) {
        isSet.add("disks");
        this.disks = disks;
    }

    public List<ApiNetworkInterfacesGcp> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiNetworkInterfacesGcp> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public ApiElastigroupBackendServiceConfigGcp getBackendServiceConfig() { return backendServiceConfig; }

    public void setBackendServiceConfig(ApiElastigroupBackendServiceConfigGcp backendServiceConfig) {
        isSet.add("backendServiceConfig");
        this.backendServiceConfig = backendServiceConfig;
    }

    public String getInstanceNamePrefix() { return instanceNamePrefix; }

    public void setInstanceNamePrefix(String instanceNamePrefix) {
        isSet.add("instanceNamePrefix");
        this.instanceNamePrefix = instanceNamePrefix;
    }

    public Boolean getIpForwarding() { return ipForwarding; }

    public void setIpForwarding(Boolean ipForwarding) {
        isSet.add("ipForwarding");
        this.ipForwarding = ipForwarding;
    }

    public String getMinCpuPlatform() { return minCpuPlatform; }

    public void setMinCpuPlatform(String minCpuPlatform) {
        isSet.add("minCpuPlatform");
        this.minCpuPlatform = minCpuPlatform;
    }

    public List<ApiElastigroupMetadataGcp> getMetadata() { return metadata; }

    public void setMetadata(List<ApiElastigroupMetadataGcp> metadata) {
        isSet.add("metadata");
        this.metadata = metadata;
    }

    public String getShutdownScript() { return shutdownScript; }

    public void setShutdownScript(String shutdownScript) {
        isSet.add("shutdownScript");
        this.shutdownScript = shutdownScript;
    }

    public String getStartupScript() { return startupScript; }

    public void setStartupScript(String startupScript) {
        isSet.add("startupScript");
        this.startupScript = startupScript;
    }

    public List<String> getTags() { return tags; }

    public void setTags(List<String> tags) {
        isSet.add("tags");
        this.tags = tags;
    }
    //endregion

    //region isSet methods
    // Is disks Set boolean method
    @JsonIgnore
    public boolean isDisksSet() {
        return isSet.contains("disks");
    }

    // Is networkInterfaces Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfacesSet() {
        return isSet.contains("networkInterfaces");
    }

    @JsonIgnore
    public boolean isBackendServiceConfigSet() { return isSet.contains("backendServiceConfig"); }

    @JsonIgnore
    public boolean isInstanceNamePrefixSet() { return isSet.contains("instanceNamePrefix"); }

    @JsonIgnore
    public boolean isIpForwardingSet() { return isSet.contains("ipForwarding"); }

    @JsonIgnore
    public boolean isMetadataSet() { return isSet.contains("metadata"); }

    @JsonIgnore
    public boolean isMinCpuPlatformSet() { return isSet.contains("minCpuPlatform"); }

    @JsonIgnore
    public boolean isShutdownScriptSet() { return isSet.contains("shutdownScript"); }

    @JsonIgnore
    public boolean isStartupScriptSet() { return isSet.contains("startupScript"); }

    @JsonIgnore
    public boolean isTagsSet() { return isSet.contains("tags"); }
    //endregion
}
