package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class LaunchSpecTagsSepcification {
    @JsonIgnore
    private Set<String> isSet;
    private String      tagKey;
    private String      tagValue;


    //region Constructors
    private LaunchSpecTagsSepcification() {
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

    public static class Builder {

        private LaunchSpecTagsSepcification launchSpecTagsSepcification;

        private Builder() {
            this.launchSpecTagsSepcification = new LaunchSpecTagsSepcification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTagKey(final String tagKey) {
            launchSpecTagsSepcification.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            launchSpecTagsSepcification.setTagValue(tagValue);
            return this;
        }

        public LaunchSpecTagsSepcification build() {
            return launchSpecTagsSepcification;
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

