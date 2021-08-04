package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiLaunchSpecResourceShieldedInstanceSpecification {

    private Set<String> isSet;
    private Boolean     enableSecureBoot;
    private Boolean     enableIntegrityMonitoring;

    public ApiLaunchSpecResourceShieldedInstanceSpecification(){ isSet = new HashSet<>();
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

    @JsonIgnore
    public Boolean isEnableSecureBootSet() {
        return isSet.contains("enableSecureBoot");
    }

    @JsonIgnore
    public Boolean isEnableIntegrityMonitoringSet() {
        return isSet.contains("enableIntegrityMonitoring");
    }

}
