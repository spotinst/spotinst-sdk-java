package com.spotinst.sdkjava.model.api.spotStorage;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAzureStorageVolume implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                     isSet;
    private String                          id;
    private String                          name;
    private String                          region;
    private ApiAzureStorageVolumeCapacity   capacity;
    private ApiAzureStorageVolumeThroughput throughput;
    private ApiAzureStorageVolumeSpec       volumeSpec;
    private ApiAzureStorageVolumeAutoResize autoResize;
    private String                          state;
    private Date                            createdAt;
    private Date                            updatedAt;
    //endregion

    //region Constructor
    public ApiAzureStorageVolume() {
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public ApiAzureStorageVolumeCapacity getCapacity() {
        return capacity;
    }

    public void setCapacity(ApiAzureStorageVolumeCapacity capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    public ApiAzureStorageVolumeThroughput getThroughput() {
        return throughput;
    }

    public void setThroughput(ApiAzureStorageVolumeThroughput throughput) {
        isSet.add("throughput");
        this.throughput = throughput;
    }

    public ApiAzureStorageVolumeSpec getVolumeSpec() {
        return volumeSpec;
    }

    public void setVolumeSpec(ApiAzureStorageVolumeSpec volumeSpec) {
        isSet.add("volumeSpec");
        this.volumeSpec = volumeSpec;
    }

    public ApiAzureStorageVolumeAutoResize getAutoResize() {
        return autoResize;
    }

    public void setAutoResize(ApiAzureStorageVolumeAutoResize autoResize) {
        isSet.add("autoResize");
        this.autoResize = autoResize;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }
    //endregion

    //region isSet methods
    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is description Set boolean method
    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    // Is capacity Set boolean method
    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

    // Is throughput Set boolean method
    @JsonIgnore
    public boolean isThroughputSet() {
        return isSet.contains("throughput");
    }

    // Is volumeSpec Set boolean method
    @JsonIgnore
    public boolean isVolumeSpecSet() {
        return isSet.contains("volumeSpec");
    }

    // Is autoResize Set boolean method
    @JsonIgnore
    public boolean isAutoResizeSet() {
        return isSet.contains("autoResize");
    }

    // Is state Set boolean method
    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

    // Is createdAt Set boolean method
    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    // Is updatedAt Set boolean method
    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }
    //endregion
}
