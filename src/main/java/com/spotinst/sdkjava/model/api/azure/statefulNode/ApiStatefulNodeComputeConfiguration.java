package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeComputeConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                         isSet;
    private String                              os;
    private ApiStatefulNodeVmSizesConfiguration vmSizes;
    private List<String>                        zones;
    private String                              preferredZone;
    private ApiStatefulNodeLaunchSpecification  launchSpecification;
    private ApiStatefulNodeLoadBalancersConfig  loadBalancersConfig;

    private ApiStatefulNodeComputeConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        isSet.add("os");
        this.os = os;
    }

    public ApiStatefulNodeVmSizesConfiguration getVmSizes() {
        return vmSizes;
    }

    public void setVmSizes(ApiStatefulNodeVmSizesConfiguration vmSizes) {
        isSet.add("vmSizes");
        this.vmSizes = vmSizes;
    }

    public List<String> getZones() {
        return zones;
    }

    public void setZones(List<String> zones) {
        isSet.add("zones");
        this.zones = zones;
    }

    public String getPreferredZone() {
        return preferredZone;
    }

    public void setPreferredZone(String preferredZone) {
        isSet.add("preferredZone");
        this.preferredZone = preferredZone;
    }

    public ApiStatefulNodeLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiStatefulNodeLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ApiStatefulNodeLoadBalancersConfig getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(ApiStatefulNodeLoadBalancersConfig loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    @JsonIgnore
    public boolean isOsSet() {
        return isSet.contains("os");
    }

    @JsonIgnore
    public boolean isVmSizesSet() {
        return isSet.contains("vmSizes");
    }

    @JsonIgnore
    public boolean isZonesSet() {
        return isSet.contains("zones");
    }

    @JsonIgnore
    public boolean isPreferredZoneSet() {
        return isSet.contains("preferredZone");
    }

    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    @JsonIgnore
    public boolean isLoadBalancersConfigSet() {
        return isSet.contains("loadBalancersConfig");
    }

}