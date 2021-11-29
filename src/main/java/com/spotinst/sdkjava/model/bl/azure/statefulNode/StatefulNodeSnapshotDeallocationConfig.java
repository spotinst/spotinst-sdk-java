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
public class StatefulNodeSnapshotDeallocationConfig {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeallocate;

    private StatefulNodeSnapshotDeallocationConfig() {
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

    public static class Builder {
        private StatefulNodeSnapshotDeallocationConfig statefulNodeSnapshotDeallocationConfig;

        private Builder() {
            this.statefulNodeSnapshotDeallocationConfig = new StatefulNodeSnapshotDeallocationConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldDeallocate(final Boolean shouldDeallocate) {
            statefulNodeSnapshotDeallocationConfig.setShouldDeallocate(shouldDeallocate);
            return this;
        }

        public StatefulNodeSnapshotDeallocationConfig build() {
            return statefulNodeSnapshotDeallocationConfig;
        }
    }

    @JsonIgnore
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }
}
