package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
/**
 * @author: Saikumar Jalda
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupDeploymentTags {

    @JsonIgnore
    private Set<String> isSet;
    private String      tagKey;
    private String      tagValue;

    public ElastigroupDeploymentTags() {
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
        private ElastigroupDeploymentTags configTags;

        private Builder() {
            this.configTags = new ElastigroupDeploymentTags();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTagKey(final String tagKey) {
            configTags.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            configTags.setTagValue(tagValue);
            return this;
        }

        public ElastigroupDeploymentTags build() {
            return configTags;
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
