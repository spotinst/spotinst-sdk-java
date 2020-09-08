package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScalingDimensionAzure {

    // Partial Update support
    @JsonIgnore
    private Set<String> isSet = new HashSet<>();
    private String      name;
    private String      value;
    private String      resourceGrodownName;    //TODO Itzik - please check
    private String      resourceName;


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    public String getResourceGrodownName() {
        return resourceGrodownName;
    }

    public void setResourceGrodownName(String resourceGrodownName) {
        isSet.add("resourceGrodownName");
        this.resourceGrodownName = resourceGrodownName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        isSet.add("resourceName");
        this.resourceName = resourceName;
    }

    //TODO Itzik - delete?
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ScalingDimensionAzure that = (ScalingDimensionAzure) o;

        if (!name.equals(that.name)) {
            return false;
        }
        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    //region Builder class
    public static class Builder {
        private ScalingDimensionAzure dimension;

        private Builder() {
            this.dimension = new ScalingDimensionAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            dimension.setName(name);
            return this;
        }

        public Builder setResourceGrodownName(final String resourceGrodownName) {
            dimension.setResourceGrodownName(resourceGrodownName);
            return this;
        }

        public Builder setResourceName(final String resourceName) {
            dimension.setResourceName(resourceName);
            return this;
        }

        public Builder setValue(final String value) {
            dimension.setValue(value);
            return this;
        }

        public ScalingDimensionAzure build() {
            // TODO : Validations
            return dimension;
        }
    }
    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceNameSet() {
        return isSet.contains("resourceName");
    }

    @JsonIgnore
    public boolean isResourceGrodownNameSet() {
        return isSet.contains("resourceGrodownName");
    }

    // Is value Set boolean method
    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }

    //endregion
}
