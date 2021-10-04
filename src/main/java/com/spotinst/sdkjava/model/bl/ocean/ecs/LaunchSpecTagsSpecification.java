package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecTagsSpecification {
    @JsonIgnore
    private Set<String> isSet;
    private String      tagKey;
    private String      tagValue;


    //region Constructors
    private LaunchSpecTagsSpecification() {
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

        private LaunchSpecTagsSpecification launchSpecTagsSpecification;

        private Builder() {
            this.launchSpecTagsSpecification = new LaunchSpecTagsSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTagKey(final String tagKey) {
            launchSpecTagsSpecification.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            launchSpecTagsSpecification.setTagValue(tagValue);
            return this;
        }

        public LaunchSpecTagsSpecification build() {
            return launchSpecTagsSpecification;
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

