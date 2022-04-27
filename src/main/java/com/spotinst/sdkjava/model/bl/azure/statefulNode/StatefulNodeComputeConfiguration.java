package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeOsEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeComputeConfiguration {

    @JsonIgnore
    private Set<String>                      isSet;
    private AzureStatefulNodeOsEnum          os;
    private StatefulNodeVmSizesConfiguration vmSizes;
    private List<String>                     zones;
    private String                           preferredZone;
    private StatefulNodeLaunchSpecification  launchSpecification;
    private StatefulNodeLoadBalancersConfig  loadBalancersConfig;

    private StatefulNodeComputeConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public AzureStatefulNodeOsEnum getOs() {
        return os;
    }

    public void setOs(AzureStatefulNodeOsEnum os) {
        isSet.add("os");
        this.os = os;
    }

    public StatefulNodeVmSizesConfiguration getVmSizes() {
        return vmSizes;
    }

    public void setVmSizes(StatefulNodeVmSizesConfiguration vmSizes) {
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

    public StatefulNodeLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(StatefulNodeLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public StatefulNodeLoadBalancersConfig getLoadBalancersConfig() {
        return loadBalancersConfig;
    }

    public void setLoadBalancersConfig(StatefulNodeLoadBalancersConfig loadBalancersConfig) {
        isSet.add("loadBalancersConfig");
        this.loadBalancersConfig = loadBalancersConfig;
    }

    public static class Builder {
        private StatefulNodeComputeConfiguration statefulNodeCompute;

        private Builder() {
            this.statefulNodeCompute = new StatefulNodeComputeConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setOs(final AzureStatefulNodeOsEnum os) {
            statefulNodeCompute.setOs(os);
            return this;
        }

        public Builder setVmSizes(final StatefulNodeVmSizesConfiguration vmSizes) {
            statefulNodeCompute.setVmSizes(vmSizes);
            return this;
        }

        public Builder setZones(final List<String> zones) {
            statefulNodeCompute.setZones(zones);
            return this;
        }

        public Builder setPreferredZone(final String preferredZone) {
            statefulNodeCompute.setPreferredZone(preferredZone);
            return this;
        }

        public Builder setLaunchSpecification(final StatefulNodeLaunchSpecification launchSpecification) {
            statefulNodeCompute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public Builder setLoadBalancersConfig(final StatefulNodeLoadBalancersConfig loadBalancersConfig) {
            statefulNodeCompute.setLoadBalancersConfig(loadBalancersConfig);
            return this;
        }


        public StatefulNodeComputeConfiguration build() {
            return statefulNodeCompute;
        }
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