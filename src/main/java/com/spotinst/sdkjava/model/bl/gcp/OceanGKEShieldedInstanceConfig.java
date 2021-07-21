package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class OceanGKEShieldedInstanceConfig {


    private Set<String> isSet;
    private boolean     enableSecureBoot;
    private boolean     enableIntegrityMonitoring;

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public boolean getEnableSecureBoot() {
        return enableSecureBoot;
    }

    public void setEnableSecureBoot(boolean enableSecureBoot) {
        isSet.add("enableSecureBoot");
        this.enableSecureBoot = enableSecureBoot;
    }

    public boolean getEnableIntegrityMonitoring() {
        return enableIntegrityMonitoring;
    }

    public void setEnableIntegrityMonitoring(boolean enableIntegrityMonitoring) {
        isSet.add("enableIntegrityMonitoring");
        this.enableIntegrityMonitoring = enableIntegrityMonitoring;
    }


    public static class Builder {
        private OceanGKEShieldedInstanceConfig gkeShieldedInstanceConfig;

        private Builder() {
            this.gkeShieldedInstanceConfig = new OceanGKEShieldedInstanceConfig();
        }

        public static OceanGKEShieldedInstanceConfig.Builder get() {
            OceanGKEShieldedInstanceConfig.Builder builder = new OceanGKEShieldedInstanceConfig.Builder();
            return builder;
        }

        public OceanGKEShieldedInstanceConfig.Builder setEnableSecureBoot(final boolean enableSecureBoot) {
            gkeShieldedInstanceConfig.setEnableSecureBoot(enableSecureBoot);
            return this;
        }

        public OceanGKEShieldedInstanceConfig.Builder setEnableIntegrityMonitoring(final boolean enableIntegrityMonitoring) {
            gkeShieldedInstanceConfig.setEnableIntegrityMonitoring(enableIntegrityMonitoring);
            return this;
        }


        public OceanGKEShieldedInstanceConfig build() {
            return gkeShieldedInstanceConfig;
        }
    }


    @JsonIgnore
    public boolean isEnableSecureBootSet() {
        return isSet.contains("enableSecureBoot");
    }

    @JsonIgnore
    public boolean isEnableIntegrityMonitoringSet() {
        return isSet.contains("enableIntegrityMonitoring");
    }

}
