package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKEShieldedInstanceConfig;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKEShieldedInstanceConfig {

    private Set<String> isSet;
    private boolean     enableSecureBoot;
    private boolean     enableIntegrityMonitoring;

    private ApiOceanGKEShieldedInstanceConfig(){isSet = new HashSet<>();
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
        private ApiOceanGKEShieldedInstanceConfig apiGkeShieldedInstanceConfig;

        private Builder() {
            this.apiGkeShieldedInstanceConfig = new ApiOceanGKEShieldedInstanceConfig();
        }

        public static ApiOceanGKEShieldedInstanceConfig.Builder get() {
            ApiOceanGKEShieldedInstanceConfig.Builder builder = new ApiOceanGKEShieldedInstanceConfig.Builder();
            return builder;
        }

        public ApiOceanGKEShieldedInstanceConfig.Builder setEnableSecureBoot(final boolean enableSecureBoot) {
            apiGkeShieldedInstanceConfig.setEnableSecureBoot(enableSecureBoot);
            return this;
        }

        public ApiOceanGKEShieldedInstanceConfig.Builder setEnableIntegrityMonitoring(final boolean enableIntegrityMonitoring) {
            apiGkeShieldedInstanceConfig.setEnableIntegrityMonitoring(enableIntegrityMonitoring);
            return this;
        }


        public ApiOceanGKEShieldedInstanceConfig build() {
            return apiGkeShieldedInstanceConfig;
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
