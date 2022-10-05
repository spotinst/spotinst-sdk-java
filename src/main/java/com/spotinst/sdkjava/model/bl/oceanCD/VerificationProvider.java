package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationProvider {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private List<String>                              clusterIds;
    private VerificationProviderPrometheus            prometheus;
    private VerificationProviderDatadog               datadog;
    private VerificationProviderNewRelic              newRelic;
    private VerificationProviderCloudWatch            cloudWatch;

    private VerificationProvider() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public List<String> getClusterIds() {
        return clusterIds;
    }

    public void setClusterIds(List<String> clusterIds) {
        isSet.add("clusterIds");
        this.clusterIds = clusterIds;
    }

    public VerificationProviderPrometheus getPrometheus() {
        return prometheus;
    }

    public void setPrometheus(VerificationProviderPrometheus prometheus) {
        isSet.add("prometheus");
        this.prometheus = prometheus;
    }

    public VerificationProviderDatadog getDatadog() {
        return datadog;
    }

    public void setDatadog(VerificationProviderDatadog datadog) {
        isSet.add("datadog");
        this.datadog = datadog;
    }

    public VerificationProviderNewRelic getNewRelic() {
        return newRelic;
    }

    public void setNewRelic(VerificationProviderNewRelic newRelic) {
        isSet.add("newRelic");
        this.newRelic = newRelic;
    }

    public VerificationProviderCloudWatch getCloudWatch() {
        return cloudWatch;
    }

    public void setCloudWatch(VerificationProviderCloudWatch cloudWatch) {
        isSet.add("cloudWatch");
        this.cloudWatch = cloudWatch;
    }

    public static class Builder {
        private VerificationProvider verificationProvider;

        private Builder() {
            this.verificationProvider = new VerificationProvider();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            verificationProvider.setName(name);
            return this;
        }

        public Builder setClusterIds(final List<String> clusterIds) {
            verificationProvider.setClusterIds(clusterIds);
            return this;
        }

        public Builder setPrometheus(final VerificationProviderPrometheus prometheus) {
            verificationProvider.setPrometheus(prometheus);
            return this;
        }

        public Builder setDatadog(final VerificationProviderDatadog datadog) {
            verificationProvider.setDatadog(datadog);
            return this;
        }

        public Builder setNewRelic(final VerificationProviderNewRelic newRelic) {
            verificationProvider.setNewRelic(newRelic);
            return this;
        }

        public Builder setCloudWatch(final VerificationProviderCloudWatch cloudWatch) {
            verificationProvider.setCloudWatch(cloudWatch);
            return this;
        }

        public VerificationProvider build() {
            return verificationProvider;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isClusterIdsSet() {
        return isSet.contains("clusterIds");
    }

    @JsonIgnore
    public boolean isPrometheusSet() {
        return isSet.contains("prometheus");
    }

    @JsonIgnore
    public boolean isDatadogSet() {
        return isSet.contains("datadog");
    }

    @JsonIgnore
    public boolean isNewRelicSet() {
        return isSet.contains("newRelic");
    }

    @JsonIgnore
    public boolean isCloudWatchSet() {
        return isSet.contains("cloudWatch");
    }
}