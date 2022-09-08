package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImportClusterVirtualNodeGroupTemplate {

    @JsonIgnore
    private Set<String>                isSet;
    private ImportClusterWhitelist     vmSizes;
    private List<String>               zones;

    private ImportClusterVirtualNodeGroupTemplate() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ImportClusterWhitelist getVmSizes() {
        return vmSizes;
    }

    public void setVmSizes(ImportClusterWhitelist vmSizes) {
        isSet.add("vmSizes");
        this.vmSizes = vmSizes;
    }

    public List<String> getZones() {
        return zones;
    }

    public void setZones(List<String> zones) {
        isSet.add("zones");
        this.zones = zones;
    }

    public static class Builder {
        private ImportClusterVirtualNodeGroupTemplate headroom;

        private Builder() {
            this.headroom = new ImportClusterVirtualNodeGroupTemplate();
        }

        public static ImportClusterVirtualNodeGroupTemplate.Builder get() {
            return new Builder();
        }

        public Builder setVmSizes(final ImportClusterWhitelist vmSizes) {
            headroom.setVmSizes(vmSizes);
            return this;
        }

        public Builder setZones(final List<String> zones) {
            headroom.setZones(zones);
            return this;
        }

        public ImportClusterVirtualNodeGroupTemplate build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isVmSizesSet() {return isSet.contains("vmSizes");}

    @JsonIgnore
    public boolean isZonesSet() {return isSet.contains("zones");}

}
