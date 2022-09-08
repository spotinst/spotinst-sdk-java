package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.k8sClusterRollOldVmsStatusEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAksInitiateRollResponseOldVms implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                     isSet;
    private String                         vmName;
    private k8sClusterRollOldVmsStatusEnum status;


    public ApiAksInitiateRollResponseOldVms() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public k8sClusterRollOldVmsStatusEnum getStatus() {
        return status;
    }

    public void setStatus(k8sClusterRollOldVmsStatusEnum status) {
        isSet.add("status");
        this.status = status;
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("setVmName");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }
}