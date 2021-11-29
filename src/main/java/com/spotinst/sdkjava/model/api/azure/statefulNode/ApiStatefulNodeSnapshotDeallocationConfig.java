package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeSnapshotDeallocationConfig implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeallocate;

    public ApiStatefulNodeSnapshotDeallocationConfig() {
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
        private ApiStatefulNodeSnapshotDeallocationConfig statefulNodeSnapshotDeallocationConfig;

        private Builder() {
            this.statefulNodeSnapshotDeallocationConfig = new ApiStatefulNodeSnapshotDeallocationConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldDeallocate(final Boolean shouldDeallocate) {
            statefulNodeSnapshotDeallocationConfig.setShouldDeallocate(shouldDeallocate);
            return this;
        }

        public ApiStatefulNodeSnapshotDeallocationConfig build() {
            return statefulNodeSnapshotDeallocationConfig;
        }
    }

    @JsonIgnore
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }
}
