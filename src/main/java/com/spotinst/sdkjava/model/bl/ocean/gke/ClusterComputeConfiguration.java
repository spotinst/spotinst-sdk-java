package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterComputeConfiguration {
    @JsonIgnore
    private Set<String>                                 isSet;
    private List<String>                                availabilityZones;
    private LaunchSpecSpecification                     launchSpecification;
    private List<ClusterBackendServicesConfiguration>   backendServices;
    private ClusterInstanceTypesConfiguration           instanceTypes;
    private List<ClusterNetworkInterfacesConfiguration> networkInterfaces;
    private String                                      subnetName;

    private ClusterComputeConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<String> availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public LaunchSpecSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(LaunchSpecSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public List<ClusterBackendServicesConfiguration> getBackendServices() {
        return backendServices;
    }

    public void setBackendServices(List<ClusterBackendServicesConfiguration> backendServices) {
        isSet.add("backendServices");
        this.backendServices = backendServices;
    }

    public ClusterInstanceTypesConfiguration getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ClusterInstanceTypesConfiguration instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public List<ClusterNetworkInterfacesConfiguration> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ClusterNetworkInterfacesConfiguration> networkInterfaces) {
        isSet.add("networkInterfaces");
        this.networkInterfaces = networkInterfaces;
    }

    public String getSubnetName() {
        return subnetName;
    }

    public void setSubnetName(String subnetName) {
        isSet.add("subnetName");
        this.subnetName = subnetName;
    }

    public static class Builder {
        private ClusterComputeConfiguration compute;

        private Builder() {
            this.compute = new ClusterComputeConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAvailabilityZones(final List<String> availabilityZones) {
            compute.setAvailabilityZones(availabilityZones);
            return this;
        }

        public Builder setSubnetName(final String subnetName) {
            compute.setSubnetName(subnetName);
            return this;
        }

        public Builder setLaunchSpecification(final LaunchSpecSpecification launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public Builder setBackendServices(final List<ClusterBackendServicesConfiguration> backendServices) {
            compute.setBackendServices(backendServices);
            return this;
        }

        public Builder setInstanceTypes(final ClusterInstanceTypesConfiguration instanceTypes) {
            compute.setInstanceTypes(instanceTypes);
            return this;
        }

        public Builder setNetworkInterfaces(final List<ClusterNetworkInterfacesConfiguration> networkInterfaces) {
            compute.setNetworkInterfaces(networkInterfaces);
            return this;
        }

        public ClusterComputeConfiguration build() {
            return compute;
        }
    }


    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    @JsonIgnore
    public boolean isAvailabilityZonesSet() {
        return isSet.contains("availabilityZones");
    }

    @JsonIgnore
    public boolean isSubnetNameSet() { return isSet.contains("subnetName"); }

    @JsonIgnore
    public boolean isBackendServicesSet() { return isSet.contains("backendServices"); }

    @JsonIgnore
    public boolean isInstanceTypesSet() { return isSet.contains("instanceTypes"); }

    @JsonIgnore
    public boolean isNetworkInterfacesSet() { return isSet.contains("networkInterfaces"); }

}