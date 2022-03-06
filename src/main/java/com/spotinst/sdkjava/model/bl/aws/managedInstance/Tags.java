package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tags {

    @JsonIgnore
    private Set<String> isSet;
    private String      tagKey;
    private String      tagValue;

    private Tags() {
        isSet = new HashSet<>();
    }

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

    public static class Builder {
        private Tags tags;

        private Builder() {
            this.tags = new Tags();
        }

        public static Builder get() {
            return new Builder();
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
            return tags;
        }
    }

    @JsonIgnore
    public boolean isTagKeySet() {
        return isSet.contains("tagKey");
    }

    @JsonIgnore
    public boolean isTagValueSet() {
        return isSet.contains("tagValue");
    }
}
