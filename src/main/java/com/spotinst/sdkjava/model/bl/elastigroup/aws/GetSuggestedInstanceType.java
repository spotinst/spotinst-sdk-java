package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Janetlin Kiruba
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class GetSuggestedInstanceType implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                     isSet;
    private String                                         region;
    private String                           baselineInstanceType;
    private RequiredVCpuRequiredMemoryGib           requiredVCpu;
    private RequiredVCpuRequiredMemoryGib      requiredMemoryGib;
    //endregion

    //region Constructor

    public GetSuggestedInstanceType() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getBaselineInstanceType() {
        return baselineInstanceType;
    }

    public void setBaselineInstanceType(String baselineInstanceType) {
        isSet.add("baselineInstanceType");
        this.baselineInstanceType = baselineInstanceType;
    }

    public RequiredVCpuRequiredMemoryGib getRequiredVCpu() {
        return requiredVCpu;
    }

    public void setRequiredVCpu(RequiredVCpuRequiredMemoryGib requiredVCpu) {
        isSet.add("requiredVCpu");
        this.requiredVCpu = requiredVCpu;
    }

    public RequiredVCpuRequiredMemoryGib getRequiredMemoryGib() {
        return requiredMemoryGib;
    }

    public void setRequiredMemoryGib(RequiredVCpuRequiredMemoryGib requiredMemoryGib) {
        isSet.add("requiredMemoryGib");
        this.requiredMemoryGib = requiredMemoryGib;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private GetSuggestedInstanceType suggestedInstanceType;
        //endregion


        private Builder() {
            this.suggestedInstanceType = new GetSuggestedInstanceType();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setRegion(final String region) {
            suggestedInstanceType.setRegion(region);
            return this;
        }

        public Builder setBaselineInstanceType(final String baselineInstanceType) {
            suggestedInstanceType.setBaselineInstanceType(baselineInstanceType);
            return this;
        }

        public Builder setRequiredVCpu(final RequiredVCpuRequiredMemoryGib requiredVCpu) {
            suggestedInstanceType.setRequiredVCpu(requiredVCpu);
            return this;
        }

        public Builder setRequiredMemoryGib(final RequiredVCpuRequiredMemoryGib requiredMemoryGib) {
            suggestedInstanceType.setRequiredMemoryGib(requiredMemoryGib);
            return this;
        }

        public GetSuggestedInstanceType build() {
            // Validations
            return suggestedInstanceType;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    // Is baselineInstanceType Set boolean method
    @JsonIgnore
    public boolean isBaselineInstanceTypeSet() {
        return isSet.contains("baselineInstanceType");
    }

    // Is requiredVCpu Set boolean method
    @JsonIgnore
    public boolean isRequiredVCpuSet() {
        return isSet.contains("requiredVCpu");
    }

    // Is requiredMemoryGib Set boolean method
    @JsonIgnore
    public boolean isRequiredMemoryGibSet() {
        return isSet.contains("requiredMemoryGib");
    }

    //endregion
}
