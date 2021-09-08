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
public class ApiAzureStorageVolumeSpecProtocolExportPolicy implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                             isSet;
    private List<ApiAzureStorageVolumeSpecProtocolExportPolicyRule> rules;

    //endregion

    //region Constructor
    public ApiAzureStorageVolumeSpecProtocolExportPolicy() {
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

    public List<ApiAzureStorageVolumeSpecProtocolExportPolicyRule> getRules() {
        return rules;
    }

    public void setRules(List<ApiAzureStorageVolumeSpecProtocolExportPolicyRule> rules) {
        isSet.add("rules");
        this.rules = rules;
    }
    //end region

    //region isSet methods
    // Is rules Set boolean method
    @JsonIgnore
    public boolean isRulesSet() {
        return isSet.contains("rules");
    }
    //endregion
}
