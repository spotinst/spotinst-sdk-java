package com.spotinst.sdkjava.model.bl.azure.statefulNode;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeallocationConfig {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeallocate;
    private Integer     ttlInHours;

    public DeallocationConfig() {
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
        private DeallocationConfig deallocationConfig;

        private Builder() {
            this.deallocationConfig = new DeallocationConfig();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setShouldDeallocate(final Boolean shouldDeallocate) {
            deallocationConfig.setShouldDeallocate(shouldDeallocate);
            return this;
        }

        public Builder setTtlInHours(final Integer ttlInHours) {
            deallocationConfig.setTtlInHours(ttlInHours);
            return this;
        }

        public DeallocationConfig build() {
            return deallocationConfig;
        }
    }

    @JsonIgnore
    public boolean isShouldDeallocateSet() {
        return isSet.contains("shouldDeallocate");
    }

    @JsonIgnore
    public boolean isTtlInHoursSet() {
        return isSet.contains("ttlInHours");
    }
}
