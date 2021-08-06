package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterComputeConfiguration {
    @JsonIgnore
    private Set<String>                       isSet;
    private List<String>                      subnetIds;
    private ClusterOptimizeImageConfiguration optimizeImage;
    private ClusterLaunchSpecification        launchSpecification;

    private ClusterComputeConfiguration() {
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

    public ClusterLaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ClusterLaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public ClusterOptimizeImageConfiguration getOptimizeImage() {
        return optimizeImage;
    }

    public void setOptimizeImage(ClusterOptimizeImageConfiguration optimizeImage) {
        isSet.add("optimizeImage");
        this.optimizeImage = optimizeImage;
    }

    public static class Builder {
        private ClusterComputeConfiguration compute;

        private Builder() {
            this.compute = new ClusterComputeConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            compute.setSubnetIds(subnetIds);
            return this;
        }

        public Builder setOptimizeImage(final ClusterOptimizeImageConfiguration optimizeImage) {
            compute.setOptimizeImage(optimizeImage);
            return this;
        }

        public Builder setLaunchSpecification(final ClusterLaunchSpecification launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public ClusterComputeConfiguration build() {
            return compute;
        }
    }


    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    @JsonIgnore
    public boolean isOptimizeImageSet() {
        return isSet.contains("optimizeImage");
    }

    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }
}