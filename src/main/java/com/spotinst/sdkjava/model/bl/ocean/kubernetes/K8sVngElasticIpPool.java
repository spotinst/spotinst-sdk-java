package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class K8sVngElasticIpPool {

    @JsonIgnore
    private Set<String>         isSet;
    private K8sVngTagSelector   tagSelector;

    private K8sVngElasticIpPool() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public K8sVngTagSelector getTagSelector() {
        return tagSelector;
    }

    public void setTagSelector(K8sVngTagSelector tagSelector) {
        isSet.add("tagSelector");
        this.tagSelector = tagSelector;
    }

    public static class Builder {
        private K8sVngElasticIpPool elasticIpPool;

        public Builder() {
            this.elasticIpPool = new K8sVngElasticIpPool();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTagSelector(K8sVngTagSelector tagSelector) {
            elasticIpPool.setTagSelector(tagSelector);
            return this;
        }

        public K8sVngElasticIpPool build() {
            return elasticIpPool;
        }
    }

    @JsonIgnore
    public boolean isTagSelectorSet() {
        return isSet.contains("tagSelector");
    }
}