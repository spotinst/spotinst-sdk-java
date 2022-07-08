package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImportClusterVirtualNodeGroupTemplateResponse {

    @JsonIgnore
    private Set<String>                          isSet;
    private ImportClusterWhitelist               vmSizes;
    private List<String>                         zones;
    private ImportClusterLaunchSpecificationAks  launchSpecification;

    public ImportClusterVirtualNodeGroupTemplateResponse() {
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

    public ImportClusterLaunchSpecificationAks getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ImportClusterLaunchSpecificationAks launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public static class Builder {
        private ImportClusterVirtualNodeGroupTemplateResponse headroom;

        private Builder() {
            this.headroom = new ImportClusterVirtualNodeGroupTemplateResponse();
        }

        public static ImportClusterVirtualNodeGroupTemplateResponse.Builder get() {
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

        public Builder setLaunchSpecification(final ImportClusterLaunchSpecificationAks launchSpecification) {
            headroom.setLaunchSpecification(launchSpecification);
            return this;
        }

        public ImportClusterVirtualNodeGroupTemplateResponse build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isVmSizesSet() {return isSet.contains("vmSizes");}

    @JsonIgnore
    public boolean isZonesSet() {return isSet.contains("zones");}

    @JsonIgnore
    public boolean isLaunchSpecificationSet() {return isSet.contains("launchSpecification");}

}
