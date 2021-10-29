package com.spotinst.sdkjava.model.api.ocean.gke;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLaunchSpecResourceShieldedInstanceSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     enableSecureBoot;
    private Boolean     enableIntegrityMonitoring;

    public ApiLaunchSpecResourceShieldedInstanceSpecification(){ isSet = new HashSet<>();
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

    @JsonIgnore
    public Boolean isEnableSecureBootSet() {
        return isSet.contains("enableSecureBoot");
    }

    @JsonIgnore
    public Boolean isEnableIntegrityMonitoringSet() {
        return isSet.contains("enableIntegrityMonitoring");
    }

}
