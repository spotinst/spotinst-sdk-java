package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficPingPong {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     pingService;
    private String                     pongService;

    private TrafficPingPong() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPingService() {
        return pingService;
    }

    public void setPingService(String pingService) {
        isSet.add("pingService");
        this.pingService = pingService;
    }

    public String getPongService() {
        return pongService;
    }

    public void setPongService(String pongService) {
        isSet.add("pongService");
        this.pongService = pongService;
    }

    public static class Builder {
        private TrafficPingPong trafficPingPong;

        private Builder() {
            this.trafficPingPong = new TrafficPingPong();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPingService(final String pingService) {
            trafficPingPong.setPingService(pingService);
            return this;
        }

        public Builder setPongService(final String pongService) {
            trafficPingPong.setPongService(pongService);
            return this;
        }

        public TrafficPingPong build() {
            return trafficPingPong;
        }
    }

    @JsonIgnore
    public boolean isPingServiceSet() {
        return isSet.contains("pingService");
    }

    @JsonIgnore
    public boolean isPongServiceSet() {
        return isSet.contains("pongService");
    }
}