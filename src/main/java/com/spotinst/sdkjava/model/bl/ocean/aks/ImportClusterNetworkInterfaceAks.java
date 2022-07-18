package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterNetworkInterfaceAks {
    @JsonIgnore
    private Set<String>                                       isSet;
    private boolean                                           isPrimary;
    private String                                            subnetName;
    private boolean                                           assignPublicIp;
    private ClusterSecurityGroupAks                           securityGroup;
    private boolean                                           enableIPForwarding;
    private String                                            publicIpSku;
    private List<ImportClusterAdditionalIpConfigurationsAksResponse>  additionalIpConfigurations;


    private ImportClusterNetworkInterfaceAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public boolean getAssignPublicIp() {
        return assignPublicIp;
    }

    public void setAssignPublicIp(boolean assignPublicIp) {
        isSet.add("assignPublicIp");
        this.assignPublicIp = assignPublicIp;
    }

    public boolean getEnableIPForwarding() {
        return enableIPForwarding;
    }

    public void setEnableIPForwarding(boolean enableIPForwarding) {
        isSet.add("enableIPForwarding");
        this.enableIPForwarding = enableIPForwarding;
    }

    public boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(boolean primary) {
        isSet.add("isPrimary");
        isPrimary = primary;
    }

    public ClusterSecurityGroupAks getSecurityGroup() {
        return securityGroup;
    }

    public void setSecurityGroup(ClusterSecurityGroupAks securityGroup) {
        isSet.add("securityGroup");
        this.securityGroup = securityGroup;
    }

    public String getSubnetName() {
        return subnetName;
    }

    public void setSubnetName(String subnetName) {
        isSet.add("subnetName");
        this.subnetName = subnetName;
    }

    public String getPublicIpSku() {
        return publicIpSku;
    }

    public void setPublicIpSku(String publicIpSku) {
        isSet.add("publicIpSku");
        this.publicIpSku = publicIpSku;
    }

    public List<ImportClusterAdditionalIpConfigurationsAksResponse> getAdditionalIpConfigurations() {
        return additionalIpConfigurations;
    }

    public void setAdditionalIpConfigurations(List<ImportClusterAdditionalIpConfigurationsAksResponse> additionalIpConfigurations) {
        isSet.add("additionalIpConfigurations");
        this.additionalIpConfigurations = additionalIpConfigurations;
    }

    @JsonIgnore
    public boolean isAdditionalIpConfigurationsSet() {
        return isSet.contains("additionalIpConfigurations");
    }

    @JsonIgnore
    public boolean isAssignPublicIpSet() {
        return isSet.contains("assignPublicIp");
    }

    @JsonIgnore
    public boolean isEnableIPForwardingSet() {
        return isSet.contains("enableIPForwarding");
    }

    @JsonIgnore
    public boolean isIsPrimarySet() {
        return isSet.contains("isPrimary");
    }

    @JsonIgnore
    public boolean isSecurityGroupSet() {
        return isSet.contains("securityGroup");
    }

    @JsonIgnore
    public boolean isSubnetNameSet() {
        return isSet.contains("subnetName");
    }

    @JsonIgnore
    public boolean isPublicIpSkuSet() {
        return isSet.contains("publicIpSku");
    }




    public static class Builder {

        private ImportClusterNetworkInterfaceAks clusterNetworkInterfaceAks;

        private Builder() {
            this.clusterNetworkInterfaceAks = new ImportClusterNetworkInterfaceAks();
        }

        public static Builder get() {
            return new Builder();
        }
        public Builder setAssignPublicIp(final boolean assignPublicIp) {
            clusterNetworkInterfaceAks.setAssignPublicIp(assignPublicIp);
            return this;
        }
        public Builder setEnableIPForwarding(final boolean enableIPForwarding) {
            clusterNetworkInterfaceAks.setEnableIPForwarding(enableIPForwarding);
            return this;
        }
        public Builder setSecurityGroup(final ClusterSecurityGroupAks securityGroup) {
            clusterNetworkInterfaceAks.setSecurityGroup(securityGroup);
            return this;
        }
        public Builder setSubnetName(final String subnetName) {
            clusterNetworkInterfaceAks.setSubnetName(subnetName);
            return this;
        }
        public Builder setIsPrimary(final boolean isPrimary) {
            clusterNetworkInterfaceAks.setIsPrimary(isPrimary);
            return this;
        }
        public Builder setPublicIpSku(final String publicIpSku){
            clusterNetworkInterfaceAks.setPublicIpSku(publicIpSku);
            return this;
        }
        public Builder setAdditionalIpConfigurations(final List<ImportClusterAdditionalIpConfigurationsAksResponse> additionalIpConfigurations){
            clusterNetworkInterfaceAks.setAdditionalIpConfigurations(additionalIpConfigurations);
            return this;
        }

        public ImportClusterNetworkInterfaceAks build() {
            return clusterNetworkInterfaceAks;
        }
    }
}
