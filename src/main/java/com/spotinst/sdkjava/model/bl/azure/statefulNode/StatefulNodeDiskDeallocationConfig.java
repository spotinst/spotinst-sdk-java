package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeDiskDeallocationConfig {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeallocate;
    private Integer     ttlInHours;

    private StatefulNodeDiskDeallocationConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Boolean getShouldDeallocate() {
        return shouldDeallocate;
    }

    public void setShouldDeallocate(Boolean shouldDeallocate) {
        isSet.add("shouldDeallocate");
        this.shouldDeallocate = shouldDeallocate;
    }

    public Integer getTtlInHours() {
        return ttlInHours;
    }

    public void setTtlInHours(Integer ttlInHours) {
        isSet.add("setTtlInHours");
        this.ttlInHours = ttlInHours;
    }


    @JsonIgnore
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }

    @JsonIgnore
    public boolean isTtlInHoursSet() {
        return isSet.contains("ttlInHours");
    }

    public static class Builder {
        private StatefulNodeDiskDeallocationConfig statefulNodeNetworkDeallocationConfig;

        private Builder() {
            this.statefulNodeNetworkDeallocationConfig = new StatefulNodeDiskDeallocationConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldDeallocate(final Boolean shouldDeallocate) {
            statefulNodeNetworkDeallocationConfig.setShouldDeallocate(shouldDeallocate);
            return this;
        }

        public Builder setTtlInHours(final Integer ttlInHours) {
            statefulNodeNetworkDeallocationConfig.setTtlInHours(ttlInHours);
            return this;
        }

        public StatefulNodeDiskDeallocationConfig build() {
            return statefulNodeNetworkDeallocationConfig;
        }
    }


}