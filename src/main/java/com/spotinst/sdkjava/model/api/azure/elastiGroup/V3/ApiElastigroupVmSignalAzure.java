package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.ElastigroupVmSignalEnumAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupVmSignalAzure implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private ElastigroupVmSignalEnumAzure signalType;
    private String                       vmName;

    public ApiElastigroupVmSignalAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupVmSignalEnumAzure getSignalType() {
        return signalType;
    }

    public void setSignalType(ElastigroupVmSignalEnumAzure signalType) {
        isSet.add("signalType");
        this.signalType = signalType;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }


    @JsonIgnore
    public boolean isSignalTypeSet() {
        return isSet.contains("signalType");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }
}
