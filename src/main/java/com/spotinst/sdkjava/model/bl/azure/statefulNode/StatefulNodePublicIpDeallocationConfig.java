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
public class StatefulNodePublicIpDeallocationConfig {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeallocate;
    private Integer     ttlInHours;

    private StatefulNodePublicIpDeallocationConfig() {
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
        private StatefulNodePublicIpDeallocationConfig statefulNodePublicDeallocationConfig;

        private Builder() {
            this.statefulNodePublicDeallocationConfig = new StatefulNodePublicIpDeallocationConfig();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setShouldDeallocate(final Boolean shouldDeallocate) {
            statefulNodePublicDeallocationConfig.setShouldDeallocate(shouldDeallocate);
            return this;
        }

        public Builder setTtlInHours(final Integer ttlInHours) {
            statefulNodePublicDeallocationConfig.setTtlInHours(ttlInHours);
            return this;
        }

        public StatefulNodePublicIpDeallocationConfig build() {
            return statefulNodePublicDeallocationConfig;
        }
    }

    @JsonIgnore
    public boolean isShouldDeallocateSet() { return isSet.contains("shouldDeallocate");  }

    @JsonIgnore
    public boolean isTtlInHoursSet() {
        return isSet.contains("ttlInHours");
    }
}
