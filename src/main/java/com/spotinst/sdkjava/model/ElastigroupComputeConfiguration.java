package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupComputeConfiguration {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String product;
    private ElastigroupLaunchSpecification launchSpecification;
    private ElastigroupInstanceTypes instanceTypes;
    private List<Placement> availabilityZones;
    private List<String> elasticIps;   ///
    private List<ElastigroupEbsVolumePool> ebsVolumePool;
    //endregion

    //region Constructor

    private ElastigroupComputeConfiguration() {
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

    public List<Placement> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<Placement> availabilityZones) {
        isSet.add("availabilityZones");
        this.availabilityZones = availabilityZones;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        isSet.add("product");
        this.product = product;
    }

    public ElastigroupLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ElastigroupLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ElastigroupInstanceTypes getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ElastigroupInstanceTypes instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public List<String> getElasticIps() {
        return elasticIps;
    }

    public void setElasticIps(List<String> elasticIps) {
        isSet.add("elasticIps");
        this.elasticIps = elasticIps;
    }

    public List<ElastigroupEbsVolumePool> getEbsVolumePool() {
        return ebsVolumePool;
    }

    public void setEbsVolumePool(List<ElastigroupEbsVolumePool> ebsVolumePool) {
        isSet.add("ebsVolumePool");
        this.ebsVolumePool = ebsVolumePool;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupComputeConfiguration compute;

        private Builder() {
            this.compute = new ElastigroupComputeConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setProduct(final String product) {
            compute.setProduct(product);
            return this;
        }

        public Builder setAvailabilityZones(final List<Placement> availabilityZones) {
            compute.setAvailabilityZones(availabilityZones);
            return this;
        }

        public Builder setEbsVolumePools(final List<ElastigroupEbsVolumePool> volumePoolList) {
            compute.setEbsVolumePool(volumePoolList);
            return this;
        }

        public Builder setElasticIps(final List<String> elasticIps) {
            compute.setElasticIps(elasticIps);
            return this;
        }

        public Builder setInstanceTypes(final ElastigroupInstanceTypes instanceTypes) {
            compute.setInstanceTypes(instanceTypes);
            return this;
        }

        public Builder setLaunchSpecification(final ElastigroupLaunchSpecification launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public ElastigroupComputeConfiguration build() {
            // TODO : Validations
            return compute;
        }
    }
    //endregion

    //region isSet methods
    // Is product Set boolean method
    @JsonIgnore
    public boolean isProductSet() {
        return isSet.contains("product");
    }

    // Is launchSpecification Set boolean method
    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }


    // Is instanceTypes Set boolean method
    @JsonIgnore
    public boolean isInstanceTypesSet() {
        return isSet.contains("instanceTypes");
    }


    // Is availabilityZones Set boolean method
    @JsonIgnore
    public boolean isAvailabilityZonesSet() {
        return isSet.contains("availabilityZones");
    }


    // Is elasticIps Set boolean method
    @JsonIgnore
    public boolean isElasticIpsSet() {
        return isSet.contains("elasticIps");
    }

    // Is ebsVolumePool Set boolean method
    @JsonIgnore
    public boolean isEbsVolumePoolSet() {
        return isSet.contains("ebsVolumePool");
    }


    //endregion

}