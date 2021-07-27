package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;


public class ElastigroupTargetGroupConfigTag {
    @JsonIgnore
    private Set<String> isSet;
    private String tagKey;
    private String tagValue;

    //region Constructor

    private ElastigroupTargetGroupConfigTag() {
        isSet = new HashSet<>();
    }
    //endregion

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

    //region Builder class
    public static class Builder {
        private ElastigroupTargetGroupConfigTag itfTags;

        private Builder() {
            this.itfTags = new ElastigroupTargetGroupConfigTag();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTagKey(final String tagKey) {
            itfTags.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            itfTags.setTagValue(tagValue);
            return this;
        }

        public ElastigroupTargetGroupConfigTag build() {
            return itfTags;
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
