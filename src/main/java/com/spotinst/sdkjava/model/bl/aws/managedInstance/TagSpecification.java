package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldTag;

    public TagSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldTag() {
        return shouldTag;
    }

    public void setShouldTag(Boolean shouldTag) {
        isSet.add("shouldTag");
        this.shouldTag = shouldTag;
    }

    public static class Builder {
        private TagSpecification tagSpecification;

        private Builder() {
            this.tagSpecification = new TagSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldTag(final Boolean shouldTag) {
            tagSpecification.setShouldTag(shouldTag);
            return this;
        }

        public TagSpecification build() {
            return tagSpecification;
        }
    }

    @JsonIgnore
    public boolean isShouldTagSet() {
        return isSet.contains("shouldTag");
    }
}
