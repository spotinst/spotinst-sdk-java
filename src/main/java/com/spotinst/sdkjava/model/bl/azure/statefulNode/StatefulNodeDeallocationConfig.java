package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeDeallocationConfig {

    @JsonIgnore
    private Set<String>         isSet;
    private Boolean             shouldTerminateVm;
    private DeallocationConfig  networkDeallocationConfig;
    private DeallocationConfig  diskDeallocationConfig;
    private DeallocationConfig  snapshotDeallocationConfig;
    private DeallocationConfig  publicIpDeallocationConfig;

    private StatefulNodeDeallocationConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldTerminateVm() {
        return shouldTerminateVm;
    }

    public void setShouldTerminateVm(Boolean shouldTerminateVm) {
        isSet.add("shouldTerminateVm");
        this.shouldTerminateVm = shouldTerminateVm;
    }

    public DeallocationConfig getNetworkDeallocationConfig() {
        return networkDeallocationConfig;
    }

    public void setNetworkDeallocationConfig(DeallocationConfig networkDeallocationConfig) {
        isSet.add("networkDeallocationConfig");
        this.networkDeallocationConfig = networkDeallocationConfig;
    }

    public DeallocationConfig getDiskDeallocationConfig() {
        return diskDeallocationConfig;
    }

    public void setDiskDeallocationConfig(DeallocationConfig diskDeallocationConfig) {
        isSet.add("diskDeallocationConfig");
        this.diskDeallocationConfig = diskDeallocationConfig;
    }

    public DeallocationConfig getSnapshotDeallocationConfig() {
        return snapshotDeallocationConfig;
    }

    public void setSnapshotDeallocationConfig(DeallocationConfig snapshotDeallocationConfig) {
        isSet.add("snapshotDeallocationConfig");
        this.snapshotDeallocationConfig = snapshotDeallocationConfig;
    }

    public DeallocationConfig getPublicIpDeallocationConfig() {
        return publicIpDeallocationConfig;
    }

    public void setPublicIpDeallocationConfig(DeallocationConfig publicIpDeallocationConfig) {
        isSet.add("publicIpDeallocationConfig");
        this.publicIpDeallocationConfig = publicIpDeallocationConfig;
    }

    public static class Builder {
        private StatefulNodeDeallocationConfig statefulNodeDeallocationConfig;

        private Builder() {
            this.statefulNodeDeallocationConfig = new StatefulNodeDeallocationConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldTerminateVms(final Boolean shouldTerminateVm) {
            statefulNodeDeallocationConfig.setShouldTerminateVm(shouldTerminateVm);
            return this;
        }

        public Builder setNetworkDeallocationConfig(final DeallocationConfig networkDeallocationConfig) {
            statefulNodeDeallocationConfig.setNetworkDeallocationConfig(networkDeallocationConfig);
            return this;
        }
        public Builder setDiskDeallocationConfig(final DeallocationConfig diskDeallocationConfig) {
            statefulNodeDeallocationConfig.setDiskDeallocationConfig(diskDeallocationConfig);
            return this;
        }

        public Builder setSnapshotDeallocationConfig(final DeallocationConfig snapshotDeallocationConfig) {
            statefulNodeDeallocationConfig.setSnapshotDeallocationConfig(snapshotDeallocationConfig);
            return this;
        }

        public Builder setPublicIpDeallocationConfig(final DeallocationConfig publicIpDeallocationConfig) {
            statefulNodeDeallocationConfig.setPublicIpDeallocationConfig(publicIpDeallocationConfig);
            return this;
        }


        public StatefulNodeDeallocationConfig build() {
            return statefulNodeDeallocationConfig;
        }
    }
    @JsonIgnore
    public boolean isShouldTerminateVmSet() {
        return isSet.contains("shouldTerminateVm");
    }

    @JsonIgnore
    public boolean isNetworkDeallocationConfigSet() {
        return isSet.contains("networkDeallocationConfig");
    }

    @JsonIgnore
    public boolean isDiskDeallocationConfigSet() {
        return isSet.contains("diskDeallocationConfig");
    }

    @JsonIgnore
    public boolean isSnapshotDeallocationConfigSet() {
        return isSet.contains("snapshotDeallocationConfig");
    }

    @JsonIgnore
    public boolean isPublicIpDeallocationConfigSet() {
        return isSet.contains("publicIpDeallocationConfig");
    }


}