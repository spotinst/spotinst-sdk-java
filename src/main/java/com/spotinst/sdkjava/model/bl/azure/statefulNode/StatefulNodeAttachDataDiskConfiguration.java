package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeDiskTypeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeAttachDataDiskConfiguration {

    @JsonIgnore
    private Set<String>                     isSet;
    private String                          dataDiskName;
    private String                          dataDiskResourceGroupName;
    private Integer                         lun;
    private Integer                         sizeGB;
    private AzureStatefulNodeDiskTypeEnum   storageAccountType;
    private String                          zone;

    private StatefulNodeAttachDataDiskConfiguration() {
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

    public AzureStatefulNodeDiskTypeEnum getStorageAccountType() {
        return storageAccountType;
    }

    public void setStorageAccountType(AzureStatefulNodeDiskTypeEnum storageAccountType) {
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

    public static class Builder {
        private StatefulNodeAttachDataDiskConfiguration attachDataDiskConfiguration;

        private Builder() {
            this.attachDataDiskConfiguration = new StatefulNodeAttachDataDiskConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDataDiskName(final String dataDiskName) {
            attachDataDiskConfiguration.setDataDiskName(dataDiskName);
            return this;
        }

        public Builder setDataDiskResourceGroupName(final String dataDiskResourceGroupName) {
            attachDataDiskConfiguration.setDataDiskResourceGroupName(dataDiskResourceGroupName);
            return this;
        }

        public Builder setLun(final Integer lun) {
            attachDataDiskConfiguration.setLun(lun);
            return this;
        }

        public Builder setSizeGB(final Integer sizeGB) {
            attachDataDiskConfiguration.setSizeGB(sizeGB);
            return this;
        }

        public Builder setStorageAccountType(final AzureStatefulNodeDiskTypeEnum storageAccountType) {
            attachDataDiskConfiguration.setStorageAccountType(storageAccountType);
            return this;
        }

        public Builder setZone(final String zone){
            attachDataDiskConfiguration.setZone(zone);
            return this;
        }

        public StatefulNodeAttachDataDiskConfiguration build() {
            return attachDataDiskConfiguration;
        }
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
