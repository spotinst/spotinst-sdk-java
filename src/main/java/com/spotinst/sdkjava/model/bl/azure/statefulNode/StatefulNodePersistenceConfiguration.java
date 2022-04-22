package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.AzureStatefulNodeDiskModeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodePersistenceConfiguration {
    @JsonIgnore
    private Set<String>                   isSet;
    private Boolean                       shouldPersistOsDisk;
    private Boolean                       shouldPersistDataDisks;
    private Boolean                       shouldPersistNetwork;
    private AzureStatefulNodeDiskModeEnum dataDisksPersistenceMode;
    private AzureStatefulNodeDiskModeEnum osDiskPersistenceMode;

    private StatefulNodePersistenceConfiguration() {
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

    public AzureStatefulNodeDiskModeEnum getDataDisksPersistenceMode() {
        return dataDisksPersistenceMode;
    }

    public void setDataDisksPersistenceMode(AzureStatefulNodeDiskModeEnum dataDisksPersistenceMode) {
        isSet.add("dataDisksPersistenceMode");
        this.dataDisksPersistenceMode = dataDisksPersistenceMode;
    }

    public AzureStatefulNodeDiskModeEnum getOsDiskPersistenceMode() {
        return osDiskPersistenceMode;
    }

    public void setOsDiskPersistenceMode(AzureStatefulNodeDiskModeEnum osDiskPersistenceMode) {
        isSet.add("osDiskPersistenceMode");
        this.osDiskPersistenceMode = osDiskPersistenceMode;
    }

    public static class Builder {
        private StatefulNodePersistenceConfiguration compute;

        private Builder() {
            this.compute = new StatefulNodePersistenceConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldPersistOsDisk(final Boolean shouldPersistOsDisk) {
            compute.setShouldPersistOsDisk(shouldPersistOsDisk);
            return this;
        }

        public Builder setShouldPersistDataDisks(final Boolean shouldPersistDataDisks) {
            compute.setShouldPersistDataDisks(shouldPersistDataDisks);
            return this;
        }

        public Builder setShouldPersistNetwork(final Boolean shouldPersistNetwork) {
            compute.setShouldPersistNetwork(shouldPersistNetwork);
            return this;
        }

        public Builder setDataDisksPersistenceMode(final AzureStatefulNodeDiskModeEnum dataDisksPersistenceMode) {
            compute.setDataDisksPersistenceMode(dataDisksPersistenceMode);
            return this;
        }

        public Builder setOsDiskPersistenceMode(final AzureStatefulNodeDiskModeEnum osDiskPersistenceMode) {
            compute.setOsDiskPersistenceMode(osDiskPersistenceMode);
            return this;
        }

        public StatefulNodePersistenceConfiguration build() {
            return compute;
        }
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