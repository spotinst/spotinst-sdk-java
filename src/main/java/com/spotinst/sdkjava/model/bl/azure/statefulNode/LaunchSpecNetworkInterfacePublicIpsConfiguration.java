package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecNetworkInterfacePublicIpsConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;

    //region Constructors
    private LaunchSpecNetworkInterfacePublicIpsConfiguration() {
        isSet = new HashSet<>();
    }
    //endregion

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

    public static class Builder {

        private LaunchSpecNetworkInterfacePublicIpsConfiguration publicIpsConfiguration;

        private Builder() {
            this.publicIpsConfiguration = new LaunchSpecNetworkInterfacePublicIpsConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            publicIpsConfiguration.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setName(final String name) {
            publicIpsConfiguration.setName(name);
            return this;
        }

        public LaunchSpecNetworkInterfacePublicIpsConfiguration build() {
            return publicIpsConfiguration;
        }
    }

    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
}

