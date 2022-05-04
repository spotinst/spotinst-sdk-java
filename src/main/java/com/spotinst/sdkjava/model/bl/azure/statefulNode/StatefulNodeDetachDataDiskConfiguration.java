package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeDetachDataDiskConfiguration {

    @JsonIgnore
    private Set<String>     isSet;
    private String          dataDiskName;
    private String          dataDiskResourceGroupName;
    private Boolean         shouldDeallocate;
    private Integer         ttlnHours;

    private StatefulNodeDetachDataDiskConfiguration() {
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

    public static class Builder {
        private StatefulNodeDetachDataDiskConfiguration detachDataDiskConfiguration;

        private Builder() {
            this.detachDataDiskConfiguration = new StatefulNodeDetachDataDiskConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDataDiskName(final String dataDiskName) {
            detachDataDiskConfiguration.setDataDiskName(dataDiskName);
            return this;
        }

        public Builder setDataDiskResourceGroupName(final String dataDiskResourceGroupName) {
            detachDataDiskConfiguration.setDataDiskResourceGroupName(dataDiskResourceGroupName);
            return this;
        }

        public Builder setShouldDeallocate(final Boolean shouldDeallocate) {
            detachDataDiskConfiguration.setShouldDeallocate(shouldDeallocate);
            return this;
        }

        public Builder setTtlnHours(final Integer ttlnHours) {
            detachDataDiskConfiguration.setTtlnHours(ttlnHours);
            return this;
        }

        public StatefulNodeDetachDataDiskConfiguration build() {
            return detachDataDiskConfiguration;
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
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }

    @JsonIgnore
    public boolean isTtlnHoursSet() {
        return isSet.contains("ttlnHours");
    }
}