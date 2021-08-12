package com.spotinst.sdkjava.model.api.ocean.ecs;

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
public class ApiClusterInstanceTypes implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> whitelist;
    private List<String> blacklist;

    public ApiClusterInstanceTypes() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(List<String> whitelist) {
        isSet.add("whitelist");
        this.whitelist = whitelist;
    }

    public List<String> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<String> blacklist) {
        isSet.add("blacklist");
        this.blacklist = blacklist;
    }

    @JsonIgnore
    public boolean isWhitelistSet() {
        return isSet.contains("whitelist");
    }

    @JsonIgnore
    public boolean isBlacklistSet() {
        return isSet.contains("blacklist");
    }
}
