package com.spotinst.sdkjava.model.api.spotStorage;

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
public class ApiAzureStorageVolumeCapacity implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     sizeGiB;
    private Integer     minSizeGiB;
    private Integer     maxSizeGiB;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeCapacity() {
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

    //region SizeGiB
    public Integer getSizeGiB() {
        return sizeGiB;
    }

    public void setSizeGiB(Integer sizeGiB) {
        isSet.add("sizeGiB");
        this.sizeGiB = sizeGiB;
    }
    //endregion

    //region MinSizeGiB
    public Integer getMinSizeGiB() {
        return minSizeGiB;
    }

    public void setMinSizeGiB(Integer minSizeGiB) {
        isSet.add("minSizeGiB");
        this.minSizeGiB = minSizeGiB;
    }
    //endregion

    //region MaxSizeGiB
    public Integer getMaxSizeGiB() {
        return maxSizeGiB;
    }

    public void setMaxSizeGiB(Integer maxSizeGiB) {
        isSet.add("maxSizeGiB");
        this.maxSizeGiB = maxSizeGiB;
    }
    //endregion


    //region isSet methods
    // Is sizeGiB Set boolean method
    @JsonIgnore
    public boolean isSizeGiBSet() {
        return isSet.contains("sizeGiB");
    }

    // Is minSizeGiB Set boolean method
    @JsonIgnore
    public boolean isMinSizeGiBSet() {
        return isSet.contains("minSizeGiB");
    }

    // Is maxSizeGiB Set boolean method
    @JsonIgnore
    public boolean isMaxSizeGiBSet() {
        return isSet.contains("maxSizeGiB");
    }

    //endregion
}
