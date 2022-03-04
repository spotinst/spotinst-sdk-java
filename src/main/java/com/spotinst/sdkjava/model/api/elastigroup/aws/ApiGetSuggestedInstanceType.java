package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Janetlin Kiruba
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGetSuggestedInstanceType implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                    isSet;
    private String                                        region;
    private String                           baselineInstanceType;
    private ApiRequiredVCpuRequiredMemoryGib         requiredVCpu;
    private ApiRequiredVCpuRequiredMemoryGib    requiredMemoryGib;
    //endregion

    //region Constructor

    public ApiGetSuggestedInstanceType() {
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

    public ApiRequiredVCpuRequiredMemoryGib getRequiredVCpu() {
        return requiredVCpu;
    }

    public void setRequiredVCpu(ApiRequiredVCpuRequiredMemoryGib requiredVCpu) {
        isSet.add("requiredVCpu");
        this.requiredVCpu = requiredVCpu;
    }

    public ApiRequiredVCpuRequiredMemoryGib getRequiredMemoryGib() {
        return requiredMemoryGib;
    }

    public void setRequiredMemoryGib(ApiRequiredVCpuRequiredMemoryGib requiredMemoryGib) {
        isSet.add("requiredMemoryGib");
        this.requiredMemoryGib = requiredMemoryGib;
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
