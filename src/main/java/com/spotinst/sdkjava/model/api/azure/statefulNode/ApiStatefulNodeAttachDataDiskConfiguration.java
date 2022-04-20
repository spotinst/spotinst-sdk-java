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
public class ApiStatefulNodeAttachDataDiskConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String          dataDiskName;
    private String          dataDiskResourceGroupName;
    private Integer         lun;
    private Integer         sizeGB;
    private String          storageAccountType;
    private String          zone;

    public ApiStatefulNodeAttachDataDiskConfiguration() {
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

    public Integer getLun() {
        return lun;
    }

    public void setLun(Integer lun) {
        isSet.add("lun");
        this.lun = lun;
    }

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
    }

    public String getStorageAccountType() {
        return storageAccountType;
    }

    public void setStorageAccountType(String storageAccountType) {
        isSet.add("storageAccountType");
        this.storageAccountType = storageAccountType;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        isSet.add("zone");
        this.zone = zone;
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
    public boolean isLunSet() {
        return isSet.contains("lun");
    }

    @JsonIgnore
    public boolean isSizeGBSet() {
        return isSet.contains("sizeGB");
    }

    @JsonIgnore
    public boolean isStorageAccountTypeSet() {
        return isSet.contains("storageAccountType");
    }

    @JsonIgnore
    public boolean isZoneSet() { return isSet.contains("zone"); }

}
