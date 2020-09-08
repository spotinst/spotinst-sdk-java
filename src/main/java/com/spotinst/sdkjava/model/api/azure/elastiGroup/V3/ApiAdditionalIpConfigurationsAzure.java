package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiAdditionalIpConfigurationsAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      privateIpAddressVersion;
    //endregion

    //region Constructors
    public ApiAdditionalIpConfigurationsAzure() {
        isSet = new HashSet<>();
    }
    ApiAdditionalIpConfigurationsAzure(String name, String privateIpAddressVersion) {
        isSet = new HashSet<>();
        this.setName(name);
        this.setPrivateIpAddressVersion(privateIpAddressVersion);
    }
    //endregion

    //region Getters & Setters
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
    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is privateIpAddressVersion Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressVersionSet() {
        return isSet.contains("privateIpAddressVersion");
    }
    //endregion
    }

