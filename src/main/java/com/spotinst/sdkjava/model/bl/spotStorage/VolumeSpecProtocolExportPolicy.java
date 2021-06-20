package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VolumeSpecProtocolExportPolicy {
    //region Members
    @JsonIgnore
    private Set<String>                              isSet;
    private List<VolumeSpecProtocolExportPolicyRule> rules;
    //endregion

    //region Constructor
    private VolumeSpecProtocolExportPolicy() {
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

    public List<VolumeSpecProtocolExportPolicyRule> getRules() {
        return rules;
    }

    public void setRules(List<VolumeSpecProtocolExportPolicyRule> rules) {
        isSet.add("rules");
        this.rules = rules;
    }
    //end region

    //region Builder class
    public static class Builder {
        //region Members
        private VolumeSpecProtocolExportPolicy volumeSpecProtocolExportPolicy;
        //endregion


        private Builder() {
            this.volumeSpecProtocolExportPolicy = new VolumeSpecProtocolExportPolicy();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setRules(final List<VolumeSpecProtocolExportPolicyRule> rules) {
            volumeSpecProtocolExportPolicy.setRules(rules);
            return this;
        }

        public VolumeSpecProtocolExportPolicy build() {
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
