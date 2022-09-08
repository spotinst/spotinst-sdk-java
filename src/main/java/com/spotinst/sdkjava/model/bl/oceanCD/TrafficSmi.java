package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficSmi {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     rootService;
    private String                     trafficSplitName;

    private TrafficSmi() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getRootService() {
        return rootService;
    }

    public void setRootService(String rootService) {
        isSet.add("rootService");
        this.rootService = rootService;
    }

    public String getTrafficSplitName() {
        return trafficSplitName;
    }

    public void setTrafficSplitName(String trafficSplitName) {
        isSet.add("trafficSplitName");
        this.trafficSplitName = trafficSplitName;
    }

    public static class Builder {
        private TrafficSmi trafficSmi;

        private Builder() {
            this.trafficSmi = new TrafficSmi();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setRootService(final String rootService) {
            trafficSmi.setRootService(rootService);
            return this;
        }

        public Builder setTrafficSplitName(final String trafficSplitName) {
            trafficSmi.setTrafficSplitName(trafficSplitName);
            return this;
        }

        public TrafficSmi build() {
            return trafficSmi;
        }
    }

    @JsonIgnore
    public boolean isRootServiceSet() {
        return isSet.contains("rootService");
    }

    @JsonIgnore
    public boolean isTrafficSplitNameSet() {
        return isSet.contains("trafficSplitName");
    }
}