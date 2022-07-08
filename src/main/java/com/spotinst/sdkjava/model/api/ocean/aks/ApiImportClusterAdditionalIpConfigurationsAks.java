package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiImportClusterAdditionalIpConfigurationsAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    name;
    private String                    privateIpAddressVersion;

    public ApiImportClusterAdditionalIpConfigurationsAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getPrivateIpAddressVersion() {
        return privateIpAddressVersion;
    }

    public void setPrivateIpAddressVersion(String privateIpAddressVersion) {
        isSet.add("privateIpAddressVersion");
        this.privateIpAddressVersion = privateIpAddressVersion;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isPrivateIpAddressVersionSet() {
        return isSet.contains("privateIpAddressVersion");
    }
}
