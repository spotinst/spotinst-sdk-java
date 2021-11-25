package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.AzureDiskModeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodePersistentConfiguration {
    @JsonIgnore
    private Set<String>       isSet;
    private Boolean           shouldPersistOsDisk;
    private Boolean           shouldPersistDataDisks;
    private Boolean           shouldPersistNetwork;
    private AzureDiskModeEnum dataDisksPersistenceMode;
    private AzureDiskModeEnum osDiskPersistenceMode;

    private StatefulNodePersistentConfiguration() {
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

    public AzureDiskModeEnum getDataDisksPersistenceMode() {
        return dataDisksPersistenceMode;
    }

    public void setDataDisksPersistenceMode(AzureDiskModeEnum dataDisksPersistenceMode) {
        isSet.add("dataDisksPersistenceMode");
        this.dataDisksPersistenceMode = dataDisksPersistenceMode;
    }

    public AzureDiskModeEnum getOsDiskPersistenceMode() {
        return osDiskPersistenceMode;
    }

    public void setOsDiskPersistenceMode(AzureDiskModeEnum osDiskPersistenceMode) {
        isSet.add("osDiskPersistenceMode");
        this.osDiskPersistenceMode = osDiskPersistenceMode;
    }

    public static class Builder {
        private StatefulNodePersistentConfiguration compute;

        private Builder() {
            this.compute = new StatefulNodePersistentConfiguration();
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

        public Builder setDataDisksPersistenceMode(final AzureDiskModeEnum dataDisksPersistenceMode) {
            compute.setDataDisksPersistenceMode(dataDisksPersistenceMode);
            return this;
        }

        public Builder setOsDiskPersistenceMode(final AzureDiskModeEnum osDiskPersistenceMode) {
            compute.setOsDiskPersistenceMode(osDiskPersistenceMode);
            return this;
        }

        public StatefulNodePersistentConfiguration build() {
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