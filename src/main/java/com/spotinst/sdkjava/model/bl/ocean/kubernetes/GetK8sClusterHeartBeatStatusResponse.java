package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetK8sClusterHeartBeatStatusResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             status;
    private String                                             lastHeartbeat;

    public GetK8sClusterHeartBeatStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public String getLastHeartbeat() {
        return lastHeartbeat;
    }

    public void setLastHeartbeat(String lastHeartbeat) {
        isSet.add("lastHeartbeat");
        this.lastHeartbeat = lastHeartbeat;
    }

    public static class Builder {
        private GetK8sClusterHeartBeatStatusResponse elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new GetK8sClusterHeartBeatStatusResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public GetK8sClusterHeartBeatStatusResponse.Builder setStatus(final String status) {
            elastigroupGetDeploymentStatusInstances.setStatus(status);
            return this;
        }

        public GetK8sClusterHeartBeatStatusResponse.Builder setLastHeartbeat(final String lastHeartbeat) {
            elastigroupGetDeploymentStatusInstances.setLastHeartbeat(lastHeartbeat);
            return this;
        }

        public GetK8sClusterHeartBeatStatusResponse build() {
            return elastigroupGetDeploymentStatusInstances;
        }

    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isLastHeartbeatSet() {
        return isSet.contains("lastHeartbeat");
    }

}
