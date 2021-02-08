package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupVmSizesAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiLaunchSpecAzure;

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
    private ApiSubnetsGcp                     subnets;
    private ApiLaunchSpecificationGcp         launchSpecification;
    private ApiInstanceTypesGcp               instanceTypes;
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

    public ApiSubnetsGcp getSubnets() {
        return subnets;
    }

    public void setSubnets(ApiSubnetsGcp subnets) {
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
    //endregion
}
