package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupLaunchSpecificationGcp {
    //region Members
    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ElastigroupDisksGcp>                       disks;
    private List<ElastigroupNetworkInterfacesGcp>           networkInterfaces;
    private ElastigroupBackendServiceConfigGcp              backendServiceConfig;
    private String                                          instanceNamePrefix;
    private Boolean                                         ipForwarding;
    private List<ElastigroupMetadataGcp>                    metadata;
    private String                                          minCpuPlatform;
    private String                                          shutdownScript;
    private String                                          startupScript;
    private List<String>                                    tags;
    //endregion

    //region Constructor
    private ElastigroupLaunchSpecificationGcp() {
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

    public List<ElastigroupDisksGcp> getDisks() {
        return disks;
    }

    public void setDisks(List<ElastigroupDisksGcp> disks) {
        isSet.add("disks");
        this.disks = disks;
    }

    public List<ElastigroupNetworkInterfacesGcp> getNetworkInterfaces() { return networkInterfaces; }

    public void setNetworkInterfaces(List<ElastigroupNetworkInterfacesGcp> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public ElastigroupBackendServiceConfigGcp getBackendServiceConfig() { return backendServiceConfig; }

    public void setBackendServiceConfig(ElastigroupBackendServiceConfigGcp backendServiceConfig) {
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

    public List<ElastigroupMetadataGcp> getMetadata() { return metadata; }

    public void setMetadata(List<ElastigroupMetadataGcp> metadata) {
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

    //region Builder class
    public static class Builder {
        private ElastigroupLaunchSpecificationGcp launchSpecification;

        private Builder() {
            this.launchSpecification = new ElastigroupLaunchSpecificationGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDisks(final List<ElastigroupDisksGcp> disks) {
            launchSpecification.setDisks(disks);
            return this;
        }

        public Builder setNetworkInterfaces(final List<ElastigroupNetworkInterfacesGcp> networkInterfaces) {
            launchSpecification.setNetworkInterfaces(networkInterfaces);
            return this;
        }

        public Builder setBackendServiceConfig(final ElastigroupBackendServiceConfigGcp backendServiceConfig) {
            launchSpecification.setBackendServiceConfig(backendServiceConfig);
            return this;
        }

        public Builder setInstanceNamePrefix(final String instanceNamePrefix) {
            launchSpecification.setInstanceNamePrefix(instanceNamePrefix);
            return this;
        }

        public Builder setIpForwarding(final Boolean ipForwarding) {
            launchSpecification.setIpForwarding(ipForwarding);
            return this;
        }

        public Builder setMetadata(final List<ElastigroupMetadataGcp> metadata) {
            launchSpecification.setMetadata(metadata);
            return this;
        }

        public Builder setMinCpuPlatform(final String minCpuPlatform) {
            launchSpecification.setMinCpuPlatform(minCpuPlatform);
            return this;
        }

        public Builder setShutdownScript(final String shutdownScript) {
            launchSpecification.setShutdownScript(shutdownScript);
            return this;
        }

        public Builder setStartupScript(final String startupScript) {
            launchSpecification.setStartupScript(startupScript);
            return this;
        }

        public Builder setTags(final List<String> tags) {
            launchSpecification.setTags(tags);
            return this;
        }

        public ElastigroupLaunchSpecificationGcp build() {
            return launchSpecification;
        }
    }
    //endregion

    //region isSet methods
    // Is disks Set boolean method
    @JsonIgnore
    public boolean isDisksSet() { return isSet.contains("disks"); }

    // Is networkInterfaces Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfacesSet() { return isSet.contains("networkInterfaces"); }

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