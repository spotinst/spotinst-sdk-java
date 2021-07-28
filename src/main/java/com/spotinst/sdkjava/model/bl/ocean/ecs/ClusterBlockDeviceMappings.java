package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterBlockDeviceMappings {
    //region Members
    @JsonIgnore
    private Set<String>             isSet;
    private String                  deviceName;
    private ClusterEbsSpecification ebs;

    private ClusterBlockDeviceMappings() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        isSet.add("deviceName");
        this.deviceName = deviceName;
    }

    public ClusterEbsSpecification getEbs() {
        return ebs;
    }

    public void setEbs(ClusterEbsSpecification ebs) {
        isSet.add("ebs");
        this.ebs = ebs;
    }

    public static class Builder {

        private ClusterBlockDeviceMappings clusterBlockDeviceMappings;

        private Builder() {
            this.clusterBlockDeviceMappings = new ClusterBlockDeviceMappings();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDeviceName(final String deviceName) {
            clusterBlockDeviceMappings.setDeviceName(deviceName);
            return this;
        }

        public Builder setEbs(final ClusterEbsSpecification ebs) {
            clusterBlockDeviceMappings.setEbs(ebs);
            return this;
        }

        public ClusterBlockDeviceMappings build() {
            return clusterBlockDeviceMappings;
        }
    }

    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    public boolean isEbsSet() {
        return isSet.contains("ebs");
    }
}
