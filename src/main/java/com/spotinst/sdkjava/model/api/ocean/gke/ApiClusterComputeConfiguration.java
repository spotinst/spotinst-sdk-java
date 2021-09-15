package com.spotinst.sdkjava.model.api.ocean.gke;

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
public class ApiClusterComputeConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                         isSet;
    private List<String>                                        availabilityZones;
    private ApiLaunchSpecSpecification                          launchSpecification;
    private ApiClusterBackendServicesConfiguration              backendServices;
    private ApiClusterInstanceTypesConfiguration                instanceTypes;
    private List<ApiClusterNetworkInterfacesConfiguration>      networkInterfaces;
    private String                                              subnetName;

    public ApiClusterComputeConfiguration() {
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

    public ApiLaunchSpecSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiLaunchSpecSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ApiClusterBackendServicesConfiguration getBackendServices() {
        return backendServices;
    }

    public void setBackendServices(ApiClusterBackendServicesConfiguration backendServices) {
        isSet.add("backendServices");
        this.backendServices = backendServices;
    }

    public ApiClusterInstanceTypesConfiguration getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ApiClusterInstanceTypesConfiguration instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public List<ApiClusterNetworkInterfacesConfiguration> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<ApiClusterNetworkInterfacesConfiguration> networkInterfaces) {
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