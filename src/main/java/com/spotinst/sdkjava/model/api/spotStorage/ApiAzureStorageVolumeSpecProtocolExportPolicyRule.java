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
public class ApiAzureStorageVolumeSpecProtocolExportPolicyRule implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private Integer      index;
    private String       allowedClients;
    private String       access;
    private Boolean      root;
    private List<String> kerberosRuleAccesses;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeSpecProtocolExportPolicyRule() {
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        isSet.add("index");
        this.index = index;
    }

    public String getAllowedClients() {
        return allowedClients;
    }

    public void setAllowedClients(String allowedClients) {
        isSet.add("allowedClients");
        this.allowedClients = allowedClients;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        isSet.add("access");
        this.access = access;
    }

    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        isSet.add("root");
        this.root = root;
    }

    public List<String> getKerberosRuleAccesses() {
        return kerberosRuleAccesses;
    }

    public void setKerberosRuleAccesses(List<String> kerberosRuleAccesses) {
        isSet.add("kerberosRuleAccesses");
        this.kerberosRuleAccesses = kerberosRuleAccesses;
    }
    //end region

    //region isSet methods
    // Is index Set boolean method
    @JsonIgnore
    public boolean isIndexSet() {
        return isSet.contains("index");
    }

    // Is allowedClients Set boolean method
    @JsonIgnore
    public boolean isAllowedClientsSet() {
        return isSet.contains("allowedClients");
    }

    // Is access Set boolean method
    @JsonIgnore
    public boolean isAccessSet() {
        return isSet.contains("access");
    }

    // Is root Set boolean method
    @JsonIgnore
    public boolean isRootSet() {
        return isSet.contains("root");
    }

    // Is kerberosRuleAccesses Set boolean method
    @JsonIgnore
    public boolean isKerberosRuleAccessesSet() {
        return isSet.contains("kerberosRuleAccesses");
    }
    //endregion
}
