package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScalingDimension {

    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String name;
    private String value;

    //region Constructor

    private ScalingDimension() {
        isSet = new HashSet<>();
    }
    //endregion


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

    private void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScalingDimension that = (ScalingDimension) o;

        if (!name.equals(that.name)) return false;
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
        private ScalingDimension dimension;

        private Builder() {
            this.dimension = new ScalingDimension();
        }

        public static Builder get(){
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            dimension.setName(name);
            return this;
        }

        public Builder setValue(final String value) {
            dimension.setValue(value);
            return this;
        }

        public ScalingDimension build() {
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

    // Is value Set boolean method
    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }

    //endregion
}
