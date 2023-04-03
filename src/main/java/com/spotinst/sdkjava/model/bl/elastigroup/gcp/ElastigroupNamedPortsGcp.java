package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupNamedPortsGcp {

    @JsonIgnore
    private Set<String>     isSet;
    private String          name;
    private List<String>    ports;

    private ElastigroupNamedPortsGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getPorts() {
        return ports;
    }

    public void setPorts(List<String> ports) {
        isSet.add("ports");
        this.ports = ports;
    }

    public String getName() { return name; }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public static class Builder {
        private ElastigroupNamedPortsGcp namedPorts;

        private Builder() {
            this.namedPorts = new ElastigroupNamedPortsGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            namedPorts.setName(name);
            return this;
        }

        public Builder setPorts(final List<String> ports) {
            namedPorts.setPorts(ports);
            return this;
        }

        public ElastigroupNamedPortsGcp build() {
            return namedPorts;
        }
    }

    @JsonIgnore
    public boolean isNameSet() { return isSet.contains("name"); }

    @JsonIgnore
    public boolean isPortsSet() { return isSet.contains("ports"); }
}
