package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficAmbassador {
    @JsonIgnore
    private Set<String>                isSet;
    private List<String>               mappings;

    private TrafficAmbassador() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getMappings() {
        return mappings;
    }

    public void setMappings(List<String> mappings) {
        isSet.add("mappings");
        this.mappings = mappings;
    }

    public static class Builder {
        private TrafficAmbassador trafficAmbassador;

        private Builder() {
            this.trafficAmbassador = new TrafficAmbassador();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMappings(final List<String> mappings) {
            trafficAmbassador.setMappings(mappings);
            return this;
        }

        public TrafficAmbassador build() {
            return trafficAmbassador;
        }
    }

    @JsonIgnore
    public boolean isMappingsSet() {
        return isSet.contains("mappings");
    }
}