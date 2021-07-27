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
public class ApiAzureStorageVolumeSpec implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private ApiAzureStorageVolumeSpecNetwork  network;
    private ApiAzureStorageVolumeSpecProtocol protocol;
    private String                            serviceLevel;
    private List<ApiAzureStorageVolumeTag>    tags;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeSpec() {
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

    public ApiAzureStorageVolumeSpecNetwork getNetwork() {
        return network;
    }

    public void setNetwork(ApiAzureStorageVolumeSpecNetwork network) {
        isSet.add("network");
        this.network = network;
    }

    public ApiAzureStorageVolumeSpecProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(ApiAzureStorageVolumeSpecProtocol protocol) {
        isSet.add("protocol");
        this.protocol = protocol;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        isSet.add("serviceLevel");
        this.serviceLevel = serviceLevel;
    }

    public List<ApiAzureStorageVolumeTag> getTags() {
        return tags;
    }

    public void setTags(List<ApiAzureStorageVolumeTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }
    //end region

    //region isSet methods
    // Is network Set boolean method
    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    // Is protocol Set boolean method
    @JsonIgnore
    public boolean isProtocolSet() {
        return isSet.contains("protocol");
    }

    // Is serviceLevel Set boolean method
    @JsonIgnore
    public boolean isServiceLevelSet() {
        return isSet.contains("serviceLevel");
    }

    // Is tags Set boolean method
    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }
    //endregion
}
