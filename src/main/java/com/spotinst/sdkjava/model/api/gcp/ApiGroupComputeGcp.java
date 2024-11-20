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
public class ApiGroupComputeGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private List<String>                      availabilityZones;
    private List<ApiSubnetsGcp>               subnets;
    private ApiLaunchSpecificationGcp         launchSpecification;
    private ApiInstanceTypesGcp               instanceTypes;
    private ApiElastigroupHealthGcp           health;
    private List<String>                      preferredAvailabilityZones;
    private ApiElastigroupGpuGcp              gpu;
    //endregion

    //region Constructor
    public ApiGroupComputeGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
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

    public List<ApiSubnetsGcp> getSubnets() {
        return subnets;
    }

    public void setSubnets(List<ApiSubnetsGcp>  subnets) {
        isSet.add("subnets");
        this.subnets = subnets;
    }

    public ApiInstanceTypesGcp getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ApiInstanceTypesGcp instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public ApiLaunchSpecificationGcp getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiLaunchSpecificationGcp launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ApiElastigroupHealthGcp getHealth() {
        return health;
    }

    public void setHealth(ApiElastigroupHealthGcp health) {
        isSet.add("health");
        this.health = health;
    }

    public ApiElastigroupGpuGcp getGpu() {
        return gpu;
    }

    public void setGpu(ApiElastigroupGpuGcp gpu) {
        isSet.add("gpu");
        this.gpu = gpu;
    }

    public List<String> getPreferredAvailabilityZones() {
        return preferredAvailabilityZones;
    }

    public void setPreferredAvailabilityZones(List<String> preferredAvailabilityZones) {
        isSet.add("preferredAvailabilityZones");
        this.preferredAvailabilityZones = preferredAvailabilityZones;
    }
    //end region

    //region is set methods
    // Is availabilityZones Set boolean method
    @JsonIgnore
    public boolean isAvailabilityZonesSet() {
        return isSet.contains("availabilityZones");
    }

    // Is subnets Set boolean method
    @JsonIgnore
    public boolean isSubnetsSet() {
        return isSet.contains("subnets");
    }

    // Is instanceTypes Set boolean method
    @JsonIgnore
    public boolean isInstanceTypesSet() {
        return isSet.contains("instanceTypes");
    }

    // Is launchSpecification Set boolean method
    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    @JsonIgnore
    public boolean isHealthSet() { return isSet.contains("health"); }

    @JsonIgnore
    public boolean isGpuSet() { return isSet.contains("gpu"); }

    @JsonIgnore
    public boolean isPreferredAvailabilityZonesSet() { return isSet.contains("preferredAvailabilityZones"); }
    //endregion
}
