package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupThirdPartiesIntegrationGcp {

    @JsonIgnore
    private Set<String>                         isSet;
    private ElastigroupDockerSwarmGcp           dockerSwarm;
    private ElastigroupGkeConfigurationGcp      gke;

    private ElastigroupThirdPartiesIntegrationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupDockerSwarmGcp getDockerSwarm() {
        return dockerSwarm;
    }

    public void setDockerSwarm(ElastigroupDockerSwarmGcp dockerSwarm) {
        isSet.add("dockerSwarm");
        this.dockerSwarm = dockerSwarm;
    }

    public ElastigroupGkeConfigurationGcp getGke() {
        return gke;
    }

    public void setGke(ElastigroupGkeConfigurationGcp gke) {
        isSet.add("gke");
        this.gke = gke;
    }

    public static class Builder {
        private ElastigroupThirdPartiesIntegrationGcp thirdPartiesIntegrationGcp;

        private Builder() {
            this.thirdPartiesIntegrationGcp = new ElastigroupThirdPartiesIntegrationGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDockerSwarm(final ElastigroupDockerSwarmGcp dockerSwarm) {
            thirdPartiesIntegrationGcp.setDockerSwarm(dockerSwarm);
            return this;
        }

        public Builder setGke(final ElastigroupGkeConfigurationGcp gke) {
            thirdPartiesIntegrationGcp.setGke(gke);
            return this;
        }

        public ElastigroupThirdPartiesIntegrationGcp build() {
            return thirdPartiesIntegrationGcp;
        }
    }

    @JsonIgnore
    public boolean isDockerSwarmSet() {
        return isSet.contains("dockerSwarm");
    }

    @JsonIgnore
    public boolean isGkeSet() {
        return isSet.contains("gke");
    }
}
