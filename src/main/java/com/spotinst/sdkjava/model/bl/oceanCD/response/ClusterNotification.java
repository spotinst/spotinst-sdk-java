package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterNotification {
    @JsonIgnore
    private Set<String>            isSet;
    private Integer                minutesWithoutHeartbeat;
    private List<String>           providers;

    private ClusterNotification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMinutesWithoutHeartbeat() {
        return minutesWithoutHeartbeat;
    }

    public void setMinutesWithoutHeartbeat(Integer minutesWithoutHeartbeat) {
        isSet.add("minutesWithoutHeartbeat");
        this.minutesWithoutHeartbeat = minutesWithoutHeartbeat;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        isSet.add("providers");
        this.providers = providers;
    }

    public static class Builder {
        private ClusterNotification clusterNotification;

        private Builder() {
            this.clusterNotification = new ClusterNotification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMinutesWithoutHeartbeat(final Integer minutesWithoutHeartbeat) {
            clusterNotification.setMinutesWithoutHeartbeat(minutesWithoutHeartbeat);
            return this;
        }

        public Builder setProviders(final List<String> providers) {
            clusterNotification.setProviders(providers);
            return this;
        }

        public ClusterNotification build() {
            return clusterNotification;
        }
    }

    @JsonIgnore
    public boolean isMinutesWithoutHeartbeatSet() {
        return isSet.contains("minutesWithoutHeartbeat");
    }

    @JsonIgnore
    public boolean isProvidersSet() {
        return isSet.contains("providers");
    }
}