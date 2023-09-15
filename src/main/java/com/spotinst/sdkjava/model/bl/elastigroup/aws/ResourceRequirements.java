package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Anurag Sharma
 * @since: 14/08/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceRequirements {
    //region Members
    @JsonIgnore
    private Set<String>                                    isSet;
    private List<String>                excludedInstanceFamilies;
    private List<String>             excludedInstanceGenerations;
    private List<String>                   excludedInstanceTypes;
    private RequiredVCpuMemoryGpu                    requiredGpu;
    private RequiredVCpuMemoryGpu                 requiredMemory;
    private RequiredVCpuMemoryGpu                   requiredVCpu;
    //endregion

    //region Constructor

    public ResourceRequirements() {
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

    public List<String> getExcludedInstanceFamilies() {
        return excludedInstanceFamilies;
    }

    public void setExcludedInstanceFamilies(List<String> excludedInstanceFamilies) {
        isSet.add("excludedInstanceFamilies");
        this.excludedInstanceFamilies = excludedInstanceFamilies;
    }

    public List<String> getExcludedInstanceGenerations() {
        return excludedInstanceGenerations;
    }

    public void setExcludedInstanceGenerations(List<String> excludedInstanceGenerations) {
        isSet.add("excludedInstanceGenerations");
        this.excludedInstanceGenerations = excludedInstanceGenerations;
    }

    public List<String> getExcludedInstanceTypes() {
        return excludedInstanceTypes;
    }

    public void setExcludedInstanceTypes(List<String> excludedInstanceTypes) {
        isSet.add("excludedInstanceTypes");
        this.excludedInstanceTypes = excludedInstanceTypes;
    }

    public RequiredVCpuMemoryGpu getRequiredGpu() {
        return requiredGpu;
    }

    public void setRequiredGpu(RequiredVCpuMemoryGpu requirement) {
        isSet.add("requiredGpu");
        this.requiredGpu = requirement;
    }

    public RequiredVCpuMemoryGpu getRequiredMemory() {
        return requiredMemory;
    }

    public void setRequiredMemory(RequiredVCpuMemoryGpu requirement) {
        isSet.add("requiredMemory");
        this.requiredMemory = requirement;
    }

    public RequiredVCpuMemoryGpu getRequiredVCpu() {
        return requiredVCpu;
    }

    public void setRequiredVCpu(RequiredVCpuMemoryGpu requirement) {
        isSet.add("requiredVCpu");
        this.requiredVCpu = requirement;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private ResourceRequirements requirements;
        //endregion

        private Builder() {
            this.requirements = new ResourceRequirements();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setExcludedInstanceFamilies(final List<String> excluded) {
            requirements.setExcludedInstanceFamilies(excluded);
            return this;
        }

        public Builder setExcludedInstanceGenerations(final List<String> excluded) {
            requirements.setExcludedInstanceGenerations(excluded);
            return this;
        }

        public Builder setExcludedInstanceTypes(final List<String> excluded) {
            requirements.setExcludedInstanceTypes(excluded);
            return this;
        }

        public Builder setRequiredGpu(final RequiredVCpuMemoryGpu required) {
            requirements.setRequiredGpu(required);
            return this;
        }

        public Builder setRequiredMemory(final RequiredVCpuMemoryGpu required) {
            requirements.setRequiredMemory(required);
            return this;
        }

        public Builder setRequiredVCpu(final RequiredVCpuMemoryGpu required) {
            requirements.setRequiredVCpu(required);
            return this;
        }

        public ResourceRequirements build() {
            // Validations
            return requirements;
        }
        //endregion
    }
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
