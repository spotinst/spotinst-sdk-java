package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tags {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      tagKey;
    private String      tagValue;


    //region Constructor

    private Tags() {
        isSet = new HashSet<>();
    }

    //endregion

    //region Setters&Getters
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

    //region Builder class
    public static class Builder {
        private Tags tags;

        private Builder() {
            this.tags = new Tags();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTagKey(final String tagKey) {
            tags.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            tags.setTagValue(tagValue);
            return this;
        }

        public Tags build() {
            // TODO : Validations
            return tags;
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
