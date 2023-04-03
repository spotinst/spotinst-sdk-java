package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupDockerSwarmGcp {

    @JsonIgnore
    private Set<String> isSet;
    private String      masterHost;
    private Integer     masterPort;

    private ElastigroupDockerSwarmGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMasterHost() {
        return masterHost;
    }

    public void setMasterHost(String masterHost) {
        isSet.add("masterHost");
        this.masterHost = masterHost;
    }

    public Integer getMasterPort() {
        return masterPort;
    }

    public void setMasterPort(Integer masterPort) {
        isSet.add("masterPort");
        this.masterPort = masterPort;
    }

    public static class Builder {
        private ElastigroupDockerSwarmGcp dockerSwarmGcp;

        private Builder() {
            this.dockerSwarmGcp = new ElastigroupDockerSwarmGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMasterHost(final String masterHost) {
            dockerSwarmGcp.setMasterHost(masterHost);
            return this;
        }

        public Builder setMasterPort(final Integer masterPort) {
            dockerSwarmGcp.setMasterPort(masterPort);
            return this;
        }

        public ElastigroupDockerSwarmGcp build() {
            return dockerSwarmGcp;
        }
    }

    @JsonIgnore
    public boolean isMasterHostSet() {
        return isSet.contains("masterHost");
    }

    @JsonIgnore
    public boolean isMasterPortSet() {
        return isSet.contains("masterPort");
    }
}
