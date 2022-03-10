package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterTagAks {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    tagKey;
    private String                    tagValue;


    private ClusterTagAks() {
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

    @JsonIgnore
    public boolean isTagKeySet() {
        return isSet.contains("tagKey");
    }

    @JsonIgnore
    public boolean isTagValueSet() {
        return isSet.contains("tagValue");
    }

    public static class Builder {

        private ClusterTagAks clusterTagAks;

        private Builder() {
            this.clusterTagAks = new ClusterTagAks();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTagKey(final String tagKey) {
            clusterTagAks.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            clusterTagAks.setTagValue(tagValue);
            return this;
        }

        public ClusterTagAks build() {
            return clusterTagAks;
        }
    }
}
