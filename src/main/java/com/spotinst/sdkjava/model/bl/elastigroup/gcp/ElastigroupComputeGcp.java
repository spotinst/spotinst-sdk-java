package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupComputeGcp {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private List<String>                      availabilityZones;
    private ElastigroupLaunchSpecificationGcp launchSpecification;
    private List<ElastigroupSubnetsGcp>       subnets;
    private ElastigroupInstanceTypesGcp       instanceTypes;
    private ElastigroupHealthGcp              health;
    private List<String>                      preferredAvailabilityZones;
    private ElastigroupGpuGcp                 gpu;
    //endregion

    //region Constructor
    private ElastigroupComputeGcp() {
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

    public List<String> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<String> availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public List<ElastigroupSubnetsGcp> getSubnets() {
        return subnets;
    }

    public void setSubnets(List<ElastigroupSubnetsGcp> subnets) {
        isSet.add("subnets");
        this.subnets = subnets;
    }

    public ElastigroupInstanceTypesGcp getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ElastigroupInstanceTypesGcp instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public ElastigroupLaunchSpecificationGcp getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ElastigroupLaunchSpecificationGcp launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ElastigroupHealthGcp getHealth() {
        return health;
    }

    public void setHealth(ElastigroupHealthGcp health) {
        isSet.add("health");
        this.health = health;
    }

    public ElastigroupGpuGcp getGpu() {
        return gpu;
    }

    public void setGpu(ElastigroupGpuGcp gpu) {
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
//endregion

//region Builder class
public static class Builder {
    private ElastigroupComputeGcp compute;

    private Builder() {
        this.compute = new ElastigroupComputeGcp();
    }

    public static Builder get() {
        return new Builder();
    }

    public Builder setAvailabilityZones(final List<String> availabilityZones) {
        compute.setAvailabilityZones(availabilityZones);
        return this;
    }

    public Builder setLaunchSpecification(final ElastigroupLaunchSpecificationGcp launchSpecification) {
        compute.setLaunchSpecification(launchSpecification);
        return this;
    }

    public Builder setInstanceTypes(final ElastigroupInstanceTypesGcp instanceTypes) {
        compute.setInstanceTypes(instanceTypes);
        return this;
    }

    public Builder setSubnets(final List<ElastigroupSubnetsGcp> subnets) {
        compute.setSubnets(subnets);
        return this;
    }

    public Builder setHealth(ElastigroupHealthGcp health) {
        compute.setHealth(health);
        return this;
    }

    public Builder setGpu(ElastigroupGpuGcp gpu) {
        compute.setGpu(gpu);
        return this;
    }

    public Builder setPreferredAvailabilityZones(List<String> preferredAvailabilityZones) {
        compute.setPreferredAvailabilityZones(preferredAvailabilityZones);
        return this;
    }

    public ElastigroupComputeGcp build() {
        return compute;
    }
}
    //endregion

    //region isSet methods
    // Is availabilityZones Set boolean method
    @JsonIgnore
    public boolean isAvailabilityZonesSet() { return isSet.contains("availabilityZones"); }

    // Is subnets Set boolean method
    @JsonIgnore
    public boolean isSubnetsSet() { return isSet.contains("subnets"); }

    // Is instanceTypes Set boolean method
    @JsonIgnore
    public boolean isInstanceTypesSet() { return isSet.contains("instanceTypes"); }

    // Is launchSpecification Set boolean method
    @JsonIgnore
    public boolean isLaunchSpecificationSet() { return isSet.contains("launchSpecification"); }

    @JsonIgnore
    public boolean isHealthSet() { return isSet.contains("health"); }

    @JsonIgnore
    public boolean isGpuSet() { return isSet.contains("gpu"); }

    @JsonIgnore
    public boolean isPreferredAvailabilityZonesSet() { return isSet.contains("preferredAvailabilityZones"); }
    //endregion

}