package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiImportClusterComputeConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<String>                        subnetIds;
    private ApiImportClusterLaunchSpecification launchSpecification;

    private ApiImportClusterComputeConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
    }

    public ApiImportClusterLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiImportClusterLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public static class Builder {
        private ApiImportClusterComputeConfiguration compute;

        private Builder() {
            this.compute = new ApiImportClusterComputeConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            compute.setSubnetIds(subnetIds);
            return this;
        }

        public Builder setLaunchSpecification(final ApiImportClusterLaunchSpecification launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public ApiImportClusterComputeConfiguration build() {
            return compute;
        }
    }


    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }
}