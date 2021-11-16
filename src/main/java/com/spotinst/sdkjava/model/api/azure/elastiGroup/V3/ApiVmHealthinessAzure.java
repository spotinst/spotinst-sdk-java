package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.VmHealthStatusEnumAzure;
import com.spotinst.sdkjava.enums.VmLifeCycleEnumAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiVmHealthinessAzure implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>             isSet;
    private VmHealthStatusEnumAzure healthStatus;
    private VmLifeCycleEnumAzure    lifeCycle;
    private String                  vmName;

    public ApiVmHealthinessAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public VmHealthStatusEnumAzure getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(VmHealthStatusEnumAzure healthStatus) {
        isSet.add("healthStatus");
        this.healthStatus = healthStatus;
    }

    public VmLifeCycleEnumAzure getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(VmLifeCycleEnumAzure lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    @JsonIgnore
    public boolean isHealthStatusSet() {
        return isSet.contains("healthStatus");
    }

    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }
}
