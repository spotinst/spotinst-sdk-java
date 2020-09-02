package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.ElastigroupEbsVolumePool;
import com.spotinst.sdkjava.model.ElastigroupInstanceTypes;
import com.spotinst.sdkjava.model.ElastigroupLaunchSpecification;
import com.spotinst.sdkjava.model.Placement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupComputeConfigurationAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String product;
    private ElastigroupLaunchSpecificationAzure launchSpecification;
    private ElastigroupInstanceTypesAzure instanceTypes;
    private List<PlacementAzure> availabilityZones;
    private List<String> elasticIps;
    private List<ElastigroupEbsVolumePoolAzure> ebsVolumePool;
    //endregion

    //region Constructor

    private ElastigroupComputeConfigurationAzure() {
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

    public List<PlacementAzure> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<PlacementAzure> availabilityZones) {
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

    public ElastigroupLaunchSpecificationAzure getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ElastigroupLaunchSpecificationAzure launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ElastigroupInstanceTypesAzure getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ElastigroupInstanceTypesAzure instanceTypes) {
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

    public List<ElastigroupEbsVolumePoolAzure> getEbsVolumePool() {
        return ebsVolumePool;
    }

    public void setEbsVolumePool(List<ElastigroupEbsVolumePoolAzure> ebsVolumePool) {
        isSet.add("ebsVolumePool");
        this.ebsVolumePool = ebsVolumePool;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupComputeConfigurationAzure compute;

        private Builder() {
            this.compute = new ElastigroupComputeConfigurationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setProduct(final String product) {
            compute.setProduct(product);
            return this;
        }

        public Builder setAvailabilityZones(final List<PlacementAzure> availabilityZones) {
            compute.setAvailabilityZones(availabilityZones);
            return this;
        }

        public Builder setEbsVolumePools(final List<ElastigroupEbsVolumePoolAzure> volumePoolList) {
            compute.setEbsVolumePool(volumePoolList);
            return this;
        }

        public Builder setElasticIps(final List<String> elasticIps) {
            compute.setElasticIps(elasticIps);
            return this;
        }

        public Builder setInstanceTypes(final ElastigroupInstanceTypesAzure instanceTypes) {
            compute.setInstanceTypes(instanceTypes);
            return this;
        }

        public Builder setLaunchSpecification(final ElastigroupLaunchSpecificationAzure launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public ElastigroupComputeConfigurationAzure build() {
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