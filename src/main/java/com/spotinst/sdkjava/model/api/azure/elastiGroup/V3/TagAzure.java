package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class TagAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String tagKey;
    private String tagValue;
    //endregion

    //region Constructors
    private TagAzure(){
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

    public String getTagKey() {
        return tagKey;
    }

    public void setTagKey(String tagKey) {
        isSet.add("tagKey");
        this.tagKey = tagKey;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        isSet.add("tagValue");
        this.tagValue = tagValue;
    }

    //endregion

    //region Object overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagAzure tag = (TagAzure) o;

        if (!tagKey.equals(tag.tagKey)) return false;
        return tagValue.equals(tag.tagValue);

    }

    @Override
    public int hashCode() {
        int result = tagKey.hashCode();
        result = 31 * result + tagValue.hashCode();
        return result;
    }
    //endregion
    //region Builder class
    public static class Builder {
        private TagAzure tag;

        private Builder() {
            this.tag = new TagAzure();
        }

        public static Builder get(){
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTagKey(final String tagKey) {
            tag.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            tag.setTagValue(tagValue);
            return this;
        }

        public TagAzure build() {
            // TODO : Validations
            return tag;
        }
    }
    //endregion

    //region isSet methods
    // Is tagKey Set boolean method
    @JsonIgnore
    public boolean isTagKeySet() {
        return isSet.contains("tagKey");
    }

    // Is tagValue Set boolean method
    @JsonIgnore
    public boolean isTagValueSet() {
        return isSet.contains("tagValue");
    }

    //endregion
}
