package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterComputeConfiguration {
    @JsonIgnore
    private Set<String>                       isSet;
    private List<String>                      subnetIds;
    private ImportClusterLaunchSpecification  launchSpecification;

    private ImportClusterComputeConfiguration() {
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

    public ImportClusterLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ImportClusterLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public static class Builder {
        private ImportClusterComputeConfiguration compute;

        private Builder() {
            this.compute = new ImportClusterComputeConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            compute.setSubnetIds(subnetIds);
            return this;
        }

        public Builder setLaunchSpecification(final ImportClusterLaunchSpecification launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public ImportClusterComputeConfiguration build() {
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