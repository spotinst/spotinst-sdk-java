package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodePersistentConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldPersistRootDisk;
    private Boolean     shouldPersistDataDisks;
    private Boolean     shouldPersistPrivateIp;
    private String      dataDisksPersistenceMode;
    private String      osDiskPersistenceMode;

    private StatefulNodePersistentConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldPersistRootDisk() {
        return shouldPersistRootDisk;
    }

    public void setShouldPersistRootDisk(Boolean shouldPersistRootDisk) {
        isSet.add("shouldPersistRootDisk");
        this.shouldPersistRootDisk = shouldPersistRootDisk;
    }

    public Boolean getShouldPersistDataDisks() {
        return shouldPersistDataDisks;
    }

    public void setShouldPersistDataDisks(Boolean shouldPersistDataDisks) {
        isSet.add("shouldPersistDataDisks");
        this.shouldPersistDataDisks = shouldPersistDataDisks;
    }

    public Boolean getShouldPersistPrivateIp() {
        return shouldPersistPrivateIp;
    }

    public void setShouldPersistPrivateIp(Boolean shouldPersistPrivateIp) {
        isSet.add("shouldPersistPrivateIp");
        this.shouldPersistPrivateIp = shouldPersistPrivateIp;
    }

    public String getDataDisksPersistenceMode() {
        return dataDisksPersistenceMode;
    }

    public void setDataDisksPersistenceMode(String dataDisksPersistenceMode) {
        isSet.add("dataDisksPersistenceMode");
        this.dataDisksPersistenceMode = dataDisksPersistenceMode;
    }

    public String getOsDiskPersistenceMode() {
        return osDiskPersistenceMode;
    }

    public void setOsDiskPersistenceMode(String osDiskPersistenceMode) {
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

        public Builder setShouldPersistRootDisk(final Boolean shouldPersistRootDisk) {
            compute.setShouldPersistRootDisk(shouldPersistRootDisk);
            return this;
        }

        public Builder setShouldPersistDataDisks(final Boolean shouldPersistDataDisks) {
            compute.setShouldPersistDataDisks(shouldPersistDataDisks);
            return this;
        }

        public Builder setShouldPersistPrivateIp(final Boolean shouldPersistPrivateIp) {
            compute.setShouldPersistPrivateIp(shouldPersistPrivateIp);
            return this;
        }

        public Builder setDataDisksPersistenceMode(final String dataDisksPersistenceMode) {
            compute.setDataDisksPersistenceMode(dataDisksPersistenceMode);
            return this;
        }

        public Builder setOsDiskPersistenceMode(final String osDiskPersistenceMode) {
            compute.setOsDiskPersistenceMode(osDiskPersistenceMode);
            return this;
        }

        public StatefulNodePersistentConfiguration build() {
            return compute;
        }
    }


    @JsonIgnore
    public boolean isShouldPersistRootDiskSet() {
        return isSet.contains("shouldPersistRootDisk");
    }

    @JsonIgnore
    public boolean isShouldPersistDataDisksSet() {
        return isSet.contains("shouldPersistDataDisks");
    }

    @JsonIgnore
    public boolean isShouldPersistPrivateIpSet() {
        return isSet.contains("shouldPersistPrivateIp");
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