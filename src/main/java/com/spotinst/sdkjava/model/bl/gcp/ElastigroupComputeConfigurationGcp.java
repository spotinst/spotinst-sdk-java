package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupLaunchSpecificationAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupVmSizesAzure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupComputeConfigurationGcp {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                       isSet;
    private List<String>                      availabilityZones;
    private ElastigroupLaunchSpecificationGcp launchSpecification;
    private ElastigroupSubnetsGcp             subnets;
    private ElastigroupInstanceTypesGcp       instanceTypes;
    //endregion

    //region Constructor
    private ElastigroupComputeConfigurationGcp() {
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

    public List<String>  getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<String>  availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public ElastigroupSubnetsGcp getSubnets() {
        return subnets;
    }

    public void setSubnets(ElastigroupSubnetsGcp subnets) {
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
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupComputeConfigurationGcp compute;

        private Builder() {
            this.compute = new ElastigroupComputeConfigurationGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAvailabilityZones(final List<String>  availabilityZones) {
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

        public Builder setSubnets(final ElastigroupSubnetsGcp subnets) {
            compute.setSubnets(subnets);
            return this;
        }

        public ElastigroupComputeConfigurationGcp build() {
            return compute;
        }
    }
    //endregion

    //region isSet methods
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
    //endregion

}