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
    private Integer     ttlInHours;

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

    public Integer getTtlInHours() {
        return ttlInHours;
    }

    public void setTtlInHours(Integer ttlInHours) {
        isSet.add("ttlInHours");
        this.ttlInHours = ttlInHours;
    }

    public static class Builder {
        private ApiStatefulNodeSnapshotDeallocationConfig statefulNodeSnapshotDeallocationConfig;

        private Builder() {
            this.statefulNodeSnapshotDeallocationConfig = new ApiStatefulNodeSnapshotDeallocationConfig();
        }

        public static Builder get() {
            return new Builder();
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
    public boolean isTtlInHoursSet() {
        return isSet.contains("ttlInHours");
    }

    @JsonIgnore
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }
}
