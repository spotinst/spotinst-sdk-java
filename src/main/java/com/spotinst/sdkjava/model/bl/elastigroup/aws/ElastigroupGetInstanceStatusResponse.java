package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetInstanceStatusResponse {

    @JsonIgnore
    private Set<String>                                          isSet;
    private String                                               instanceId;
    private String                                               lifeCycleState;

    public ElastigroupGetInstanceStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getLifeCycleState() {
        return lifeCycleState;
    }

    public void setLifeCycleState(String lifeCycleState) {
        isSet.add("lifeCycleState");
        this.lifeCycleState = lifeCycleState;
    }

    public static class Builder {
        private ElastigroupGetInstanceStatusResponse elastigroupGetInstanceStatusResponse;

        private Builder() {
            this.elastigroupGetInstanceStatusResponse = new ElastigroupGetInstanceStatusResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupGetInstanceStatusResponse.Builder setInstanceId(final String instanceId) {
            elastigroupGetInstanceStatusResponse.setInstanceId(instanceId);
            return this;
        }

        public ElastigroupGetInstanceStatusResponse.Builder setLifeCycleState(final String lifeCycleState) {
            elastigroupGetInstanceStatusResponse.setLifeCycleState(lifeCycleState);
            return this;
        }

        public ElastigroupGetInstanceStatusResponse build() {
            return elastigroupGetInstanceStatusResponse;
        }

    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isLifeCycleStateSet() {
        return isSet.contains("lifeCycleState");
    }

}
