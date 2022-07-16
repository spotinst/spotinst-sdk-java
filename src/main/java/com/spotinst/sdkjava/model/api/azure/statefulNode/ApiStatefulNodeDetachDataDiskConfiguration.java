package com.spotinst.sdkjava.model.api.azure.statefulNode;

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
public class ApiStatefulNodeDetachDataDiskConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>     isSet;
    private String          dataDiskName;
    private String          dataDiskResourceGroupName;
    private Boolean         shouldDeallocate;
    private Integer         ttlnHours;

    public ApiStatefulNodeDetachDataDiskConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDataDiskName() {
        return dataDiskName;
    }

    public void setDataDiskName(String dataDiskName) {
        isSet.add("dataDiskName");
        this.dataDiskName = dataDiskName;
    }

    public String getDataDiskResourceGroupName() {
        return dataDiskResourceGroupName;
    }

    public void setDataDiskResourceGroupName(String dataDiskResourceGroupName) {
        isSet.add("dataDiskResourceGroupName");
        this.dataDiskResourceGroupName = dataDiskResourceGroupName;
    }

    public Boolean getShouldDeallocate() {
        return shouldDeallocate;
    }

    public void setShouldDeallocate(Boolean shouldDeallocate) {
        isSet.add("shouldDeallocate");
        this.shouldDeallocate = shouldDeallocate;
    }

    public Integer getTtlnHours() {
        return ttlnHours;
    }

    public void setTtlnHours(Integer ttlnHours) {
        isSet.add("ttlnHours");
        this.ttlnHours = ttlnHours;
    }

    @JsonIgnore
    public boolean isDataDiskNameSet() {
        return isSet.contains("dataDiskName");
    }

    @JsonIgnore
    public boolean isDataDiskResourceGroupNameSet() {
        return isSet.contains("dataDiskResourceGroupName");
    }

    @JsonIgnore
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }

    @JsonIgnore
    public boolean isTtlnHoursSet() {
        return isSet.contains("ttlnHours");
    }
}