package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAzureAksClusterHeartBeatStatusResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             status;
    private String                                             lastHeartbeat;

    public GetAzureAksClusterHeartBeatStatusResponse() {
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
        private GetAzureAksClusterHeartBeatStatusResponse elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new GetAzureAksClusterHeartBeatStatusResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public GetAzureAksClusterHeartBeatStatusResponse.Builder setStatus(final String status) {
            elastigroupGetDeploymentStatusInstances.setStatus(status);
            return this;
        }

        public GetAzureAksClusterHeartBeatStatusResponse.Builder setLastHeartbeat(final String lastHeartbeat) {
            elastigroupGetDeploymentStatusInstances.setLastHeartbeat(lastHeartbeat);
            return this;
        }

        public GetAzureAksClusterHeartBeatStatusResponse build() {
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
