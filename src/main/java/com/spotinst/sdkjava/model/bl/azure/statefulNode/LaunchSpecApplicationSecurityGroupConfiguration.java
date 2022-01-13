package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecApplicationSecurityGroupConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;

    //region Constructors
    private LaunchSpecApplicationSecurityGroupConfiguration() {
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

        private LaunchSpecApplicationSecurityGroupConfiguration securityGroupConfiguration;

        private Builder() {
            this.securityGroupConfiguration = new LaunchSpecApplicationSecurityGroupConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            securityGroupConfiguration.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setName(final String name) {
            securityGroupConfiguration.setName(name);
            return this;
        }

        public LaunchSpecApplicationSecurityGroupConfiguration build() {
            return securityGroupConfiguration;
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

