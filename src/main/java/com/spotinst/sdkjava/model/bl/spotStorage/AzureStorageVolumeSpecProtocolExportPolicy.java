package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AzureStorageVolumeSpecProtocolExportPolicy {
    //region Members
    @JsonIgnore
    private Set<String>                                          isSet;
    private List<AzureStorageVolumeSpecProtocolExportPolicyRule> rules;
    //endregion

    //region Constructor
    private AzureStorageVolumeSpecProtocolExportPolicy() {
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

    public List<AzureStorageVolumeSpecProtocolExportPolicyRule> getRules() {
        return rules;
    }

    public void setRules(List<AzureStorageVolumeSpecProtocolExportPolicyRule> rules) {
        isSet.add("rules");
        this.rules = rules;
    }
    //end region

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeSpecProtocolExportPolicy volumeSpecProtocolExportPolicy;
        //endregion


        private Builder() {
            this.volumeSpecProtocolExportPolicy = new AzureStorageVolumeSpecProtocolExportPolicy();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setRules(final List<AzureStorageVolumeSpecProtocolExportPolicyRule> rules) {
            volumeSpecProtocolExportPolicy.setRules(rules);
            return this;
        }

        public AzureStorageVolumeSpecProtocolExportPolicy build() {
            // Validations
            return volumeSpecProtocolExportPolicy;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is rules Set boolean method
    @JsonIgnore
    public boolean isRulesSet() {
        return isSet.contains("rules");
    }
    //endregion
}
