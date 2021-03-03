package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupLaunchSpecificationGcp {
    //region Members
    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ElastigroupDisksGcp>                       disks;
    private List<ElastigroupNetworkInterfacesGcp>           networkInterfaces;
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
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupLaunchSpecificationGcp launchSpecification;

        private Builder() {
            this.launchSpecification = new ElastigroupLaunchSpecificationGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDisks(final List<ElastigroupDisksGcp> disks) {
            launchSpecification.setDisks(disks);
            return this;
        }

        public Builder setNetworkInterfaces(final List<ElastigroupNetworkInterfacesGcp> networkInterfaces) {
            launchSpecification.setNetworkInterfaces(networkInterfaces);
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
    //endregion
}