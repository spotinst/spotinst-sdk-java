package com.spotinst.sdkjava.model.api.spotStorage;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAzureStorageVolumeAutoResize implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                       isSet;
    private String                                            mode;
    private String                                            policyType;
    private List<ApiAzureStorageVolumeAutoResizeResizePolicy> resizePolicies;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeAutoResize() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        isSet.add("mode");
        this.mode = mode;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        isSet.add("policyType");
        this.policyType = policyType;
    }

    public List<ApiAzureStorageVolumeAutoResizeResizePolicy> getResizePolicies() {
        return resizePolicies;
    }

    public void setResizePolicies(List<ApiAzureStorageVolumeAutoResizeResizePolicy> resizePolicies) {
        isSet.add("resizePolicies");
        this.resizePolicies = resizePolicies;
    }
    //end region

    //region isSet methods

    // Is mode Set boolean method
    @JsonIgnore
    public boolean isModeSet() {
        return isSet.contains("mode");
    }

    // Is policyType Set boolean method
    @JsonIgnore
    public boolean isPolicyTypeSet() {
        return isSet.contains("policyType");
    }

    // Is resizePolicies Set boolean method
    @JsonIgnore
    public boolean isResizePoliciesSet() {
        return isSet.contains("resizePolicies");
    }
    //endregion
}
