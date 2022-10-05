package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderCloudWatch {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    duration;
    private List<CloudWatchMetricDataQueries>         metricDataQueries;

    private ProviderCloudWatch() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        isSet.add("duration");
        this.duration = duration;
    }

    public List<CloudWatchMetricDataQueries> getMetricDataQueries() {
        return metricDataQueries;
    }

    public void setMetricDataQueries(List<CloudWatchMetricDataQueries> metricDataQueries) {
        isSet.add("metricDataQueries");
        this.metricDataQueries = metricDataQueries;
    }

    public static class Builder {
        private ProviderCloudWatch providerCloudWatch;

        private Builder() {
            this.providerCloudWatch = new ProviderCloudWatch();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMetricDataQueries(final List<CloudWatchMetricDataQueries> metricDataQueries) {
            providerCloudWatch.setMetricDataQueries(metricDataQueries);
            return this;
        }

        public Builder setDuration(final String duration) {
            providerCloudWatch.setDuration(duration);
            return this;
        }

        public ProviderCloudWatch build() {
            return providerCloudWatch;
        }
    }

    @JsonIgnore
    public boolean isMetricDataQueriesSet() {
        return isSet.contains("metricDataQueries");
    }

    @JsonIgnore
    public boolean isDurationSet() {
        return isSet.contains("duration");
    }
}