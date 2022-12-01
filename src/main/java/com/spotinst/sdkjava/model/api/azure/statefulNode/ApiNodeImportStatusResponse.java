package com.spotinst.sdkjava.model.api.azure.statefulNode;

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
public class ApiNodeImportStatusResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                          isSet;
    private String                               statefulImportId;
    private String                               statefulNodeId;
    private String                               vmName;
    private String                               state;

    public ApiNodeImportStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getStatefulImportId() {
        return statefulImportId;
    }

    public void setStatefulImportId(String statefulImportId) {
        isSet.add("statefulImportId");
        this.statefulImportId = statefulImportId;
    }

    public String getStatefulNodeId() {
        return statefulNodeId;
    }

    public void setStatefulNodeId(String statefulNodeId) {
        isSet.add("statefulNodeId");
        this.statefulNodeId = statefulNodeId;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    @JsonIgnore
    public boolean isStatefulImportIdSet() {
        return isSet.contains("statefulImportId");
    }

    @JsonIgnore
    public boolean isStatefulNodeIdSet() {
        return isSet.contains("statefulNodeId");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

}
