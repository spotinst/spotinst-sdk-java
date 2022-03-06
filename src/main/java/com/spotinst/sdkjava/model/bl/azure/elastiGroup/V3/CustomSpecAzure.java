package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CustomSpecAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String      resourceGroupName;
    private String      name;
    //endregion

    //region Constructors
    private CustomSpecAzure() {
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

    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomSpecAzure that = (CustomSpecAzure) o;
        return Objects.equals(resourceGroupName, that.resourceGroupName) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceGroupName, name);
    }
    //endregion

    //region Builder class
    public static class Builder {
        private CustomSpecAzure loginAzure;

        private Builder() {
            this.loginAzure = new CustomSpecAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setResourceGroupName(final String resourceGroupName) {
            loginAzure.setResourceGroupName(resourceGroupName);
            return this;
        }

        public Builder setName(final String name) {
            loginAzure.setName(name);
            return this;
        }

        public CustomSpecAzure build() {
            // TODO : Validations
            return loginAzure;
        }
    }
    //endregion

    //region isSet methods
    // Is resourceGroupName Set boolean method
    @JsonIgnore
    public boolean isResourceGroupNameSet() {
        return isSet.contains("resourceGroupName");
    }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
    //endregion
}
