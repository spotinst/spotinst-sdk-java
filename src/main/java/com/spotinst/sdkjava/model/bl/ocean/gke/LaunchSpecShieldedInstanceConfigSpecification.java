package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecShieldedInstanceConfigSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     enableSecureBoot;
    private Boolean     enableIntegrityMonitoring;

    public LaunchSpecShieldedInstanceConfigSpecification(){ isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getEnableSecureBoot() {
        return enableSecureBoot;
    }

    public void setEnableSecureBoot(Boolean enableSecureBoot) {
        isSet.add("enableSecureBoot");
        this.enableSecureBoot = enableSecureBoot;
    }

    public Boolean getEnableIntegrityMonitoring() {
        return enableIntegrityMonitoring;
    }

    public void setEnableIntegrityMonitoring(Boolean enableIntegrityMonitoring) {
        isSet.add("enableIntegrityMonitoring");
        this.enableIntegrityMonitoring = enableIntegrityMonitoring;
    }


    public static class Builder {
        private LaunchSpecShieldedInstanceConfigSpecification gkeShieldedInstanceConfig;

        private Builder() {
            this.gkeShieldedInstanceConfig = new LaunchSpecShieldedInstanceConfigSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setEnableSecureBoot(final Boolean enableSecureBoot) {
            gkeShieldedInstanceConfig.setEnableSecureBoot(enableSecureBoot);
            return this;
        }

        public Builder setEnableIntegrityMonitoring(final Boolean enableIntegrityMonitoring) {
            gkeShieldedInstanceConfig.setEnableIntegrityMonitoring(enableIntegrityMonitoring);
            return this;
        }

        public LaunchSpecShieldedInstanceConfigSpecification build() {
            return gkeShieldedInstanceConfig;
        }
    }


    @JsonIgnore
    public Boolean isEnableSecureBootSet() {
        return isSet.contains("enableSecureBoot");
    }

    @JsonIgnore
    public Boolean isEnableIntegrityMonitoringSet() {
        return isSet.contains("enableIntegrityMonitoring");
    }

}
