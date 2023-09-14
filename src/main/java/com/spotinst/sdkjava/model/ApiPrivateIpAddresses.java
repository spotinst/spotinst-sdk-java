package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sobhana p on 9/12/2023.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiPrivateIpAddresses implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Boolean                   primary;
    private String                    privateIpAddress;
    //endregion

    //region Constructor
    private ApiPrivateIpAddresses() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        isSet.add("primary");
        this.primary = primary;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        isSet.add("primary");
        this.privateIpAddress = privateIpAddress;
    }

    //endregion

    //region isSet methods
    // Is primary Set boolean method
    @JsonIgnore
    public boolean isPrimarySet() {
        return isSet.contains("primary");
    }

    // Is privateIpAddress Set boolean method
    @JsonIgnore
    public boolean isPrivateIpAddressSet() {
        return isSet.contains("privateIpAddress");
    }

    //endregion
}
