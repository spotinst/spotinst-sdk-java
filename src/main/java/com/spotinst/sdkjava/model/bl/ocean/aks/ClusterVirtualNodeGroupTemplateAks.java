package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterVirtualNodeGroupTemplateAks {
    @JsonIgnore
    private Set<String>                          isSet;
    private ClusterLaunchSpecificationAks        launchSpecification;


    private ClusterVirtualNodeGroupTemplateAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ClusterLaunchSpecificationAks getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ClusterLaunchSpecificationAks launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    public static class Builder {

        private ClusterVirtualNodeGroupTemplateAks clusterVirtualNodeGroupTemplateAks;

        private Builder() {
            this.clusterVirtualNodeGroupTemplateAks = new ClusterVirtualNodeGroupTemplateAks();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setLaunchSpecification(final ClusterLaunchSpecificationAks launchSpecification) {
            clusterVirtualNodeGroupTemplateAks.setLaunchSpecification(launchSpecification);
            return this;
        }

        public ClusterVirtualNodeGroupTemplateAks build() {
            return clusterVirtualNodeGroupTemplateAks;
        }
    }

}
