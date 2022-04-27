package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.K8sVngHttpTokensEnum;

import java.util.HashSet;
import java.util.Set;

public class K8sVngInstanceMetadataOptions {
    @JsonIgnore
    private Set<String>          isSet;
    private Integer              httpPutResponseHopLimit;
    private K8sVngHttpTokensEnum httpTokens;

    private K8sVngInstanceMetadataOptions() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getHttpPutResponseHopLimit() {
        return httpPutResponseHopLimit;
    }

    public void setHttpPutResponseHopLimit(Integer httpPutResponseHopLimit) {
        isSet.add("httpPutResponseHopLimit");
        this.httpPutResponseHopLimit = httpPutResponseHopLimit;
    }

    public K8sVngHttpTokensEnum getHttpTokens() {
        return httpTokens;
    }

    public void setHttpTokens(K8sVngHttpTokensEnum httpTokens) {
        isSet.add("httpTokens");
        this.httpTokens = httpTokens;
    }

    public static class Builder {
        private K8sVngInstanceMetadataOptions instanceMetadataOptions;

        private Builder() {
            this.instanceMetadataOptions = new K8sVngInstanceMetadataOptions();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHttpPutResponseHopLimit(final Integer httpPutResponseHopLimit) {
            instanceMetadataOptions.setHttpPutResponseHopLimit(httpPutResponseHopLimit);
            return this;
        }

        public Builder setHttpTokens(final K8sVngHttpTokensEnum httpTokens) {
            instanceMetadataOptions.setHttpTokens(httpTokens);
            return this;
        }

        public K8sVngInstanceMetadataOptions build() {
            return instanceMetadataOptions;
        }
    }

    @JsonIgnore
    public boolean isHttpPutResponseHopLimitSet() {
        return isSet.contains("httpPutResponseHopLimit");
    }

    @JsonIgnore
    public boolean isHttpTokensSet() {
        return isSet.contains("httpTokens");
    }
}
