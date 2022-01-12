package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

public class LaunchSpecCustomConfiguration {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;
    //endregion

    //region Constructors
    private LaunchSpecCustomConfiguration() {
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

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        isSet.add("resourceGroupName");
        this.resourceGroupName = resourceGroupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private LaunchSpecCustomConfiguration customImageConfiguration;

        private Builder() {
            this.customImageConfiguration = new LaunchSpecCustomConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            customImageConfiguration.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setName(final String name) {
            customImageConfiguration.setName(name);
            return this;
        }

        public LaunchSpecCustomConfiguration build() {
            return customImageConfiguration;
        }
    }
    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
    //endregion
}
