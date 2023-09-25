package com.spotinst.sdkjava.model;

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
class ApiGroupCompute implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>         isSet;
    private ApiInstanceTypes    instanceTypes;
    private List<ApiPlacement>  availabilityZones;
    private String              product;
    private ApiLaunchSpec       launchSpecification;
    private List<String>        elasticIps;
    private List<ApiVolumePool> ebsVolumePool;
    private List<String>        preferredAvailabilityZones;
    private List<String> privateIps;
    private List<String> subnetIds;
    //endregion

    //region Constructor

    public ApiGroupCompute() {
        isSet = new HashSet<>();
    }
    //endregion


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiInstanceTypes getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(ApiInstanceTypes instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public List<ApiPlacement> getAvailabilityZones() {
        return availabilityZones;
    }

    public void setAvailabilityZones(List<ApiPlacement> availabilityZones) {
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

    public ApiLaunchSpec getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiLaunchSpec launchSpecification) {
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

    public List<ApiVolumePool> getEbsVolumePool() {
        return ebsVolumePool;
    }

    public void setEbsVolumePool(List<ApiVolumePool> ebsVolumePool) {
        isSet.add("ebsVolumePool");
        this.ebsVolumePool = ebsVolumePool;
    }

    public List<String> getPreferredAvailabilityZones() {
        return preferredAvailabilityZones;
    }

    public void setPreferredAvailabilityZones(List<String> preferredAvailabilityZones) {
        isSet.add("preferredAvailabilityZones");
        this.preferredAvailabilityZones = preferredAvailabilityZones;
    }

    public List<String> getPrivateIps() {
        return privateIps;
    }

    public void setPrivateIps(List<String> privateIps) {
        isSet.add("privateIps");
        this.privateIps = privateIps;
    }

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
    }

    //region isset methods

    // Is privateIps Set boolean method
    @JsonIgnore
    public boolean isPrivateIpsSet() {
        return isSet.contains("privateIps");
    }

    // Is subnetIds Set boolean method
    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
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

    // Is preferredAvailabilityZones Set boolean method
    @JsonIgnore
    public boolean isPreferredAvailabilityZonesSet() {
        return isSet.contains("preferredAvailabilityZones");
    }


    //endregion
}
