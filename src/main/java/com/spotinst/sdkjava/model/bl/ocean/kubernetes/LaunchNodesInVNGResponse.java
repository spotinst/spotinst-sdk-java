package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaunchNodesInVNGResponse {
    @JsonIgnore
    private Set<String>                  isSet;
    private String                       launchSpecId;
    private List<NewInstances>			 newInstances;

    private LaunchNodesInVNGResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getLaunchSpecId() {
        return launchSpecId;
    }

    public void setLaunchSpecId(String launchSpecId) {
        isSet.add("launchSpecId");
        this.launchSpecId = launchSpecId;
    }

    public List<NewInstances> getNewInstances() {
        return newInstances;
    }

    public void setNewInstances (List<NewInstances> newInstances) {
        isSet.add("newInstances");
        this.newInstances = newInstances;
    }

    public static class Builder {
        private LaunchNodesInVNGResponse launchSpecification;

        private Builder() {
            this.launchSpecification = new LaunchNodesInVNGResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setLaunchSpecId(final String launchSpecId) {
            launchSpecification.setLaunchSpecId(launchSpecId);
            return this;
        }

        public Builder setNewInstances(final List<NewInstances> newInstances) {
            launchSpecification.setNewInstances(newInstances);
            return this;
        }

        public LaunchNodesInVNGResponse build() {
            // Validations
            return launchSpecification;
        }
    }

    @JsonIgnore
    public boolean isLaunchSpecIdSet() {
        return isSet.contains("launchSpecId");
    }

    @JsonIgnore
    public boolean isNewInstancesSet() {
        return isSet.contains("newInstances");
    }
}