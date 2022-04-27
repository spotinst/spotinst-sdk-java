package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeDiskPersistenceModeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodePersistenceConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                     isSet;
    private Boolean                                         shouldPersistOsDisk;
    private Boolean                                         shouldPersistDataDisks;
    private Boolean                                         shouldPersistNetwork;
    private AzureStatefulNodeDiskPersistenceModeEnum        dataDisksPersistenceMode;
    private AzureStatefulNodeDiskPersistenceModeEnum        osDiskPersistenceMode;

    public ApiStatefulNodePersistenceConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldPersistDataDisks() {
        return shouldPersistDataDisks;
    }

    public void setShouldPersistDataDisks(Boolean shouldPersistDataDisks) {
        isSet.add("shouldPersistDataDisks");
        this.shouldPersistDataDisks = shouldPersistDataDisks;
    }

    public Boolean getShouldPersistOsDisk() {
        return shouldPersistOsDisk;
    }

    public void setShouldPersistOsDisk(Boolean shouldPersistOsDisk) {
        isSet.add("shouldPersistOsDisk");
        this.shouldPersistOsDisk = shouldPersistOsDisk;
    }

    public Boolean getShouldPersistNetwork() {
        return shouldPersistNetwork;
    }

    public void setShouldPersistNetwork(Boolean shouldPersistNetwork) {
        isSet.add("shouldPersistNetwork");
        this.shouldPersistNetwork = shouldPersistNetwork;
    }

    public AzureStatefulNodeDiskPersistenceModeEnum getDataDisksPersistenceMode() {
        return dataDisksPersistenceMode;
    }

    public void setDataDisksPersistenceMode(AzureStatefulNodeDiskPersistenceModeEnum dataDisksPersistenceMode) {
        isSet.add("dataDisksPersistenceMode");
        this.dataDisksPersistenceMode = dataDisksPersistenceMode;
    }

    public AzureStatefulNodeDiskPersistenceModeEnum getOsDiskPersistenceMode() {
        return osDiskPersistenceMode;
    }

    public void setOsDiskPersistenceMode(AzureStatefulNodeDiskPersistenceModeEnum osDiskPersistenceMode) {
        isSet.add("osDiskPersistenceMode");
        this.osDiskPersistenceMode = osDiskPersistenceMode;
    }


    @JsonIgnore
    public boolean isShouldPersistOsDiskSet() {
        return isSet.contains("shouldPersistOsDisk");
    }

    @JsonIgnore
    public boolean isShouldPersistDataDisksSet() {
        return isSet.contains("shouldPersistDataDisks");
    }

    @JsonIgnore
    public boolean isShouldPersistNetworkSet() {
        return isSet.contains("shouldPersistNetwork");
    }

    @JsonIgnore
    public boolean isDataDisksPersistenceModeSet() {
        return isSet.contains("dataDisksPersistenceMode");
    }

    @JsonIgnore
    public boolean isOsDiskPersistenceModeSet() {
        return isSet.contains("osDiskPersistenceMode");
    }

}