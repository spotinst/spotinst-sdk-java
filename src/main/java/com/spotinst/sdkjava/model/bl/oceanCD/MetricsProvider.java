package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsProvider {
    @JsonIgnore
    private Set<String>                               isSet;
    private ProviderPrometheus                        prometheus;
    private ProviderDatadog                           datadog;
    private ProviderNewRelic                          newRelic;
    private ProviderCloudWatch                        cloudWatch;
    private ProviderWeb                               web;

    private MetricsProvider() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ProviderPrometheus getPrometheus() {
        return prometheus;
    }

    public void setPrometheus(ProviderPrometheus prometheus) {
        isSet.add("prometheus");
        this.prometheus = prometheus;
    }

    public ProviderDatadog getDatadog() {
        return datadog;
    }

    public void setDatadog(ProviderDatadog datadog) {
        isSet.add("datadog");
        this.datadog = datadog;
    }

    public ProviderNewRelic getNewRelic() {
        return newRelic;
    }

    public void setNewRelic(ProviderNewRelic newRelic) {
        isSet.add("newRelic");
        this.newRelic = newRelic;
    }

    public ProviderCloudWatch getCloudWatch() {
        return cloudWatch;
    }

    public void setCloudWatch(ProviderCloudWatch cloudWatch) {
        isSet.add("cloudWatch");
        this.cloudWatch = cloudWatch;
    }

    public ProviderWeb getWeb() {
        return web;
    }

    public void setWeb(ProviderWeb web) {
        isSet.add("web");
        this.web = web;
    }

    public static class Builder {
        private MetricsProvider metricsProvider;

        private Builder() {
            this.metricsProvider = new MetricsProvider();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPrometheus(final ProviderPrometheus prometheus) {
            metricsProvider.setPrometheus(prometheus);
            return this;
        }

        public Builder setNewRelic(final ProviderNewRelic newRelic) {
            metricsProvider.setNewRelic(newRelic);
            return this;
        }

        public Builder setDatadog(final ProviderDatadog datadog) {
            metricsProvider.setDatadog(datadog);
            return this;
        }

        public Builder setWeb(final ProviderWeb web) {
            metricsProvider.setWeb(web);
            return this;
        }

        public Builder setCloudWatch(final ProviderCloudWatch cloudWatch) {
            metricsProvider.setCloudWatch(cloudWatch);
            return this;
        }

        public MetricsProvider build() {
            return metricsProvider;
        }
    }

    @JsonIgnore
    public boolean isWebSet() {
        return isSet.contains("web");
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