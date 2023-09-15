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
 * Created by Anurag Sharma on 14/8/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiResourceRequirements implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                       isSet;
    private List<String>                   excludedInstanceFamilies;
    private List<String>                excludedInstanceGenerations;
    private List<String>                      excludedInstanceTypes;
    private ApiRequiredVCpuMemoryGpu                    requiredGpu;
    private ApiRequiredVCpuMemoryGpu                 requiredMemory;
    private ApiRequiredVCpuMemoryGpu                   requiredVCpu;
    //endregion

    //region Constructor

    public ApiResourceRequirements() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getExcludedInstanceFamilies() {
        return excludedInstanceFamilies;
    }

    public void setExcludedInstanceFamilies(List<String> excluded) {
        isSet.add("excludedInstanceFamilies");
        this.excludedInstanceFamilies = excluded;
    }

    public List<String> getExcludedInstanceGenerations() {
        return excludedInstanceGenerations;
    }

    public void setExcludedInstanceGenerations(List<String> excluded) {
        isSet.add("excludedInstanceGenerations");
        this.excludedInstanceGenerations = excluded;
    }

    public List<String> getExcludedInstanceTypes() {
        return excludedInstanceTypes;
    }

    public void setExcludedInstanceTypes(List<String> excluded) {
        isSet.add("excludedInstanceTypes");
        this.excludedInstanceTypes = excluded;
    }

    public ApiRequiredVCpuMemoryGpu getRequiredGpu() {
        return requiredGpu;
    }

    public void setRequiredGpu(ApiRequiredVCpuMemoryGpu required) {
        isSet.add("requiredGpu");
        this.requiredGpu = required;
    }

    public ApiRequiredVCpuMemoryGpu getRequiredMemory() {
        return requiredMemory;
    }

    public void setRequiredMemory(ApiRequiredVCpuMemoryGpu required) {
        isSet.add("requiredMemory");
        this.requiredMemory = required;
    }

    public ApiRequiredVCpuMemoryGpu getRequiredVCpu() {
        return requiredVCpu;
    }

    public void setRequiredVCpu(ApiRequiredVCpuMemoryGpu required) {
        isSet.add("requiredVCpu");
        this.requiredVCpu = required;
    }

    //endregion

    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isExcludedInstanceFamiliesSet() {
        return isSet.contains("excludedInstanceFamilies");
    }

    @JsonIgnore
    public boolean isExcludedInstanceGenerationsSet() {
        return isSet.contains("excludedInstanceGenerations");
    }

    @JsonIgnore
    public boolean isExcludedInstanceTypesSet() {
        return isSet.contains("excludedInstanceTypes");
    }

    @JsonIgnore
    public boolean isRequiredGpuSet() {
        return isSet.contains("requiredGpu");
    }

    @JsonIgnore
    public boolean isRequiredMemorySet() {
        return isSet.contains("requiredMemory");
    }

    @JsonIgnore
    public boolean isRequiredVCpuSet() {
        return isSet.contains("requiredVCpu");
    }

    //endregion
}
