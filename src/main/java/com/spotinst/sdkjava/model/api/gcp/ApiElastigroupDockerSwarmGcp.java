package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupDockerSwarmGcp implements IPartialUpdateEntity {

        @JsonIgnore
        private Set<String> isSet;
        private String      masterHost;
        private Integer     masterPort;

        public ApiElastigroupDockerSwarmGcp() {
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

        @JsonIgnore
        public boolean isMasterHostSet() {
            return isSet.contains("masterHost");
        }

        @JsonIgnore
        public boolean isMasterPortSet() {
            return isSet.contains("masterPort");
        }
}
