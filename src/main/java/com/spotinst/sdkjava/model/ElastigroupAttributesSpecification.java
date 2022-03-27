package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupAttributesSpecification {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String      key;
    private String      value;
    //endregion

    //region Constructors
    private ElastigroupAttributesSpecification() {
        isSet = new HashSet<>();
    }
    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getKey() {
        return key;
    }

    public void setKey (String key) {
        isSet.add("key");
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String Value) {
        isSet.add("Value");
        this.value = Value;
    }

    //endregion
    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElastigroupAttributesSpecification tag = (ElastigroupAttributesSpecification) o;

        if (!key.equals(tag.key)) return false;
        return value.equals(tag.value);

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
    //region Builder class
    public static class Builder {
        private ElastigroupAttributesSpecification  tag;

        private Builder() {
            this.tag = new ElastigroupAttributesSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setkey (final String key){
            tag.setKey(key);
            return this;
        }

        public Builder setValue (final String value){
            tag.setValue(value);
            return this;
        }

        public ElastigroupAttributesSpecification build(){return tag;}

    }
    //endregion

    //region isSet methods
    // Is key Set boolean method
    @JsonIgnore
    public boolean isKeySet() {
        return isSet.contains("key");
    }

    // Is value Set boolean method
    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("Value");
    }

    //endregion
}
