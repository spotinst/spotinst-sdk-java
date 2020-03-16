package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/26/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiNetworkInterface implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      description;
    private Integer     deviceIndex;
    private Integer     secondaryPrivateIpAddressCount;
    private Boolean     associatePublicIpAddress;
    private Boolean     deleteOnTermination;
    private String      networkInterfaceId;
    //endregion

    //region Constructor

    public ApiNetworkInterface() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public Integer getDeviceIndex() {
        return deviceIndex;
    }

    public void setDeviceIndex(Integer deviceIndex) {
        isSet.add("deviceIndex");
        this.deviceIndex = deviceIndex;
    }

    public Integer getSecondaryPrivateIpAddressCount() {
        return secondaryPrivateIpAddressCount;
    }

    public void setSecondaryPrivateIpAddressCount(Integer secondaryPrivateIpAddressCount) {
        isSet.add("secondaryPrivateIpAddressCount");
        this.secondaryPrivateIpAddressCount = secondaryPrivateIpAddressCount;
    }

    public Boolean getAssociatePublicIpAddress() {
        return associatePublicIpAddress;
    }

    public void setAssociatePublicIpAddress(Boolean associatePublicIpAddress) {
        isSet.add("associatePublicIpAddress");
        this.associatePublicIpAddress = associatePublicIpAddress;
    }

    public Boolean getDeleteOnTermination() {
        return deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean deleteOnTermination) {
        isSet.add("deleteOnTermination");
        this.deleteOnTermination = deleteOnTermination;
    }

    public String getNetworkInterfaceId() {
        return networkInterfaceId;
    }

    public void setNetworkInterfaceId(String networkInterfaceId) {
        isSet.add("networkInterfaceId");
        this.networkInterfaceId = networkInterfaceId;
    }
    //endregion

    //region isSet methods

    // Is description Set boolean method
    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }


    // Is deviceIndex Set boolean method
    @JsonIgnore
    public boolean isDeviceIndexSet() {
        return isSet.contains("deviceIndex");
    }


    // Is secondaryPrivateIpAddressCount Set boolean method
    @JsonIgnore
    public boolean isSecondaryPrivateIpAddressCountSet() {
        return isSet.contains("secondaryPrivateIpAddressCount");
    }


    // Is associatePublicIpAddress Set boolean method
    @JsonIgnore
    public boolean isAssociatePublicIpAddressSet() {
        return isSet.contains("associatePublicIpAddress");
    }


    // Is deleteOnTermination Set boolean method
    @JsonIgnore
    public boolean isDeleteOnTerminationSet() {
        return isSet.contains("deleteOnTermination");
    }

    // Is networkInterfaceId Set boolean method
    @JsonIgnore
    public boolean isNetworkInterfaceIdSet() {
        return isSet.contains("networkInterfaceId");
    }


    //endregion
}
