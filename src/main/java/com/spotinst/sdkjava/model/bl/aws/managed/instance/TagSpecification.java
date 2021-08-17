package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagSpecification {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldTag;

    //endregion

    //region Constructor
    public TagSpecification() {
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

    public Boolean getShouldTag() {
        return shouldTag;
    }

    public void setShouldTag(Boolean shouldTag) {
        isSet.add("shouldTag");
        this.shouldTag = shouldTag;
    }

    //endregion

    //region Builder class
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
            // TODO : Validations
            return tagSpecification;
        }
    }
    //endregion

    //region Methods
    @JsonIgnore
    public boolean isShouldTagSet() {
        return isSet.contains("shouldTag");
    }

    //endregion
}
