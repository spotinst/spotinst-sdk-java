package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;


public class K8sVngTagSelector {

    @JsonIgnore
    private Set<String> isSet;
    private String tagKey;
    private String tagValue;

    private K8sVngTagSelector(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        K8sVngTagSelector k8sVngTag = (K8sVngTagSelector) o;

        if (!tagKey.equals(k8sVngTag.tagKey)) return false;
        return tagValue.equals(k8sVngTag.tagValue);

    }

    @Override
    public int hashCode() {
        int result = tagKey.hashCode();
        result = 31 * result + tagValue.hashCode();
        return result;
    }

    public static class Builder {
        private K8sVngTagSelector tag;

        private Builder() {
            this.tag = new K8sVngTagSelector();
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

        public K8sVngTagSelector build() {
            return tag;
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