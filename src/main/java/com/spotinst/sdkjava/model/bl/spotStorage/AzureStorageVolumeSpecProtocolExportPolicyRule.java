package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AzureStorageVolumeSpecProtocolExportPolicyRule {
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
    private AzureStorageVolumeSpecProtocolExportPolicyRule() {
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

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeSpecProtocolExportPolicyRule volumeSpecProtocolExportPolicyRule;
        //endregion


        private Builder() {
            this.volumeSpecProtocolExportPolicyRule = new AzureStorageVolumeSpecProtocolExportPolicyRule();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setIndex(final Integer index) {
            volumeSpecProtocolExportPolicyRule.setIndex(index);
            return this;
        }

        //region Build methods
        public Builder setAllowedClients(final String allowedClients) {
            volumeSpecProtocolExportPolicyRule.setAllowedClients(allowedClients);
            return this;
        }

        //region Build methods
        public Builder setAccess(final String access) {
            volumeSpecProtocolExportPolicyRule.setAccess(access);
            return this;
        }

        //region Build methods
        public Builder setRoot(final Boolean root) {
            volumeSpecProtocolExportPolicyRule.setRoot(root);
            return this;
        }

        //region Build methods
        public Builder setKerberosRuleAccesses(final List<String> kerberosRuleAccesses) {
            volumeSpecProtocolExportPolicyRule.setKerberosRuleAccesses(kerberosRuleAccesses);
            return this;
        }

        public AzureStorageVolumeSpecProtocolExportPolicyRule build() {
            // Validations
            return volumeSpecProtocolExportPolicyRule;
        }
        //endregion
    }
    //endregion

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
