package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiGroupComputeAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>         isSet;
    private ApiInstanceTypesAzure    instanceTypes;
    private List<ApiPlacementAzure>  availabilityZones;
    private String              product;
    private ApiLaunchSpecAzure       launchSpecification;
    private List<String>        elasticIps;
    private List<ApiVolumePoolAzure> ebsVolumePool;
    //endregion

    //region Constructor

    public ApiGroupComputeAzure() {
        isSet = new HashSet<>();
    }
    //endregion


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiInstanceTypesAzure getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ApiInstanceTypesAzure instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public List<ApiPlacementAzure> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<ApiPlacementAzure> availabilityZones) {
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

    public ApiLaunchSpecAzure getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiLaunchSpecAzure launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public List<String> getElasticIps() {
        return elasticIps;
    }

    public void setElasticIps(List<String> elasticIps) {
        isSet.add("elasticIps");
        this.elasticIps = elasticIps;
    }

    public List<ApiVolumePoolAzure> getEbsVolumePool() {
        return ebsVolumePool;
    }

    public void setEbsVolumePool(List<ApiVolumePoolAzure> ebsVolumePool) {
        isSet.add("ebsVolumePool");
        this.ebsVolumePool = ebsVolumePool;
    }
    //region isset methods

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
