package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiAdditionalIpConfigurationsAzure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/25/15.
 */
public class NetworkInterfaceAzure {

    // Partial Update support
    @JsonIgnore
    private Set<String>                              isSet;
    private Boolean                                  isPrimary;
    private String                                   subnetName;
    private Boolean                                  assignPublicIp;
    private String                                   publicIpSku;
    private Boolean                                  enableIPForwarding;
    private List<AdditionalIpConfigurationsAzure> additionalIpConfigurations;
    //todo add security group in future

    //region Constructor

    private NetworkInterfaceAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        isSet.add("isPrimary");
        this.isPrimary = isPrimary;
    }

    public List<AdditionalIpConfigurationsAzure> getAdditionalIpConfigurations() {
        return additionalIpConfigurations;
    }

    public void setAdditionalIpConfigurations(List<AdditionalIpConfigurationsAzure> additionalIpConfigurations) {
        isSet.add("additionalIpConfigurations");
        this.additionalIpConfigurations = additionalIpConfigurations;
    }

    public String getSubnetName() {
        return subnetName;
    }

    public void setSubnetName(String subnetName) {
        isSet.add("subnetName");
        this.subnetName = subnetName;
    }

    public Boolean getAssignPublicIp() {
        return assignPublicIp;
    }

    public void setAssignPublicIp(Boolean assignPublicIp) {
        isSet.add("assignPublicIp");
        this.assignPublicIp = assignPublicIp;
    }

    public Boolean getEnableIPForwarding() {
        return enableIPForwarding;
    }

    public void setEnableIPForwarding(Boolean enableIPForwarding) {
        isSet.add("enableIPForwarding");
        this.enableIPForwarding = enableIPForwarding;
    }

    public String getPublicIpSku() {
        return publicIpSku;
    }

    public void setPublicIpSku(String publicIpSku) {
        isSet.add("publicIpSku");
        this.publicIpSku = publicIpSku;
    }

    //region Builder class
    public static class Builder {
        private NetworkInterfaceAzure networkInterface;

        private Builder() {
            this.networkInterface = new NetworkInterfaceAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setEnableIPForwarding(final Boolean enableIPForwarding) {
            networkInterface.setEnableIPForwarding(enableIPForwarding);
            return this;
        }

        public Builder setAssignPublicIp(final Boolean assignPublicIp) {
            networkInterface.setAssignPublicIp(assignPublicIp);
            return this;
        }

        public Builder setIsPrimary(final Boolean isPrimary) {
            networkInterface.setIsPrimary(isPrimary);
            return this;
        }

        public Builder setPublicIpSku(final String publicIpSku) {
            networkInterface.setPublicIpSku(publicIpSku);
            return this;
        }

        public Builder setSubnetName(final String subnetName) {
            networkInterface.setSubnetName(subnetName);
            return this;
        }

        public Builder setAdditionalIpConfigurations(
                final List<AdditionalIpConfigurationsAzure> additionalIpConfigurations) {
            networkInterface.setAdditionalIpConfigurations(additionalIpConfigurations);
            return this;
        }

        public NetworkInterfaceAzure build() {
            // TODO : Validations
            return networkInterface;
        }
    }

    //endregion
    //region isSet methods
    // Is isPrimary Set boolean method
    @JsonIgnore
    public boolean isIsPrimarySet() {
        return isSet.contains("isPrimary");
    }

    // Is assignPublicIp Set boolean method
    @JsonIgnore
    public boolean isSetAssignPublicIpSet() {
        return isSet.contains("assignPublicIp");
    }


    // Is enableIPForwarding Set boolean method
    @JsonIgnore
    public boolean isEnableIPForwardingSet() {
        return isSet.contains("enableIPForwarding");
    }


    // Is additionalIpConfigurations Set boolean method
    @JsonIgnore
    public boolean isAdditionalIpConfigurationsSet() {
        return isSet.contains("additionalIpConfigurations");
    }

    // Is publicIpSku Set boolean method
    @JsonIgnore
    public boolean isPublicIpSkuSet() {
        return isSet.contains("publicIpSku");
    }

    // Is subnetName Set boolean method
    @JsonIgnore
    public boolean isSubnetNameSet() {
        return isSet.contains("subnetName");
    }


    //endregion
}
