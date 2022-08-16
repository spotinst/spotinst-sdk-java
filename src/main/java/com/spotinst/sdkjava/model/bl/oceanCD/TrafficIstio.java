package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficIstio {
    @JsonIgnore
    private Set<String>                               isSet;
    private List<IstioVirtualService>                virtualServices;
    private IstioDestinationRule                      destinationRule;

    private TrafficIstio() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<IstioVirtualService> getVirtualServices() {
        return virtualServices;
    }

    public void setVirtualServices(List<IstioVirtualService> virtualServices) {
        isSet.add("virtualServices");
        this.virtualServices = virtualServices;
    }

    public IstioDestinationRule getDestinationRule() {
        return destinationRule;
    }

    public void setDestinationRule(IstioDestinationRule destinationRule) {
        isSet.add("destinationRule");
        this.destinationRule = destinationRule;
    }

    public static class Builder {
        private TrafficIstio trafficIstio;

        private Builder() {
            this.trafficIstio = new TrafficIstio();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVirtualServices(final List<IstioVirtualService> virtualServices) {
            trafficIstio.setVirtualServices(virtualServices);
            return this;
        }

        public Builder setDestinationRule(final IstioDestinationRule destinationRule) {
            trafficIstio.setDestinationRule(destinationRule);
            return this;
        }

        public TrafficIstio build() {
            return trafficIstio;
        }
    }

    @JsonIgnore
    public boolean isVirtualServicesSet() {
        return isSet.contains("virtualServices");
    }

    @JsonIgnore
    public boolean isDestinationRuleSet() {
        return isSet.contains("destinationRule");
    }
}