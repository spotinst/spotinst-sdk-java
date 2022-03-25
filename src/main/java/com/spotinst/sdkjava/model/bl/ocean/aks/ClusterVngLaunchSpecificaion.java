package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClusterVngLaunchSpecificaion {

    @JsonIgnore
    private Set<String>            isSet;
    private List<ClusterTagAks> tags;
    private ClusterVngOsDisk    osDisk;

    private ClusterVngLaunchSpecificaion() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterTagAks> getTags() {
        return tags;
    }

    public void setTags(List<ClusterTagAks> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ClusterVngOsDisk getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ClusterVngOsDisk osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    public static class Builder {
        private ClusterVngLaunchSpecificaion launchSpec;

        private Builder() {
            this.launchSpec = new ClusterVngLaunchSpecificaion();
        }

        public static ClusterVngLaunchSpecificaion.Builder get() {
            return new Builder();
        }

        public ClusterVngLaunchSpecificaion.Builder setTags(final List<ClusterTagAks> tags) {
            launchSpec.setTags(tags);
            return this;
        }

        public ClusterVngLaunchSpecificaion.Builder setOsDisk(final ClusterVngOsDisk osDisk) {
            launchSpec.setOsDisk(osDisk);
            return this;
        }

        public ClusterVngLaunchSpecificaion build() {
            return launchSpec;
        }
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isOsDiskSet() {
        return isSet.contains("osDisk");
    }

}