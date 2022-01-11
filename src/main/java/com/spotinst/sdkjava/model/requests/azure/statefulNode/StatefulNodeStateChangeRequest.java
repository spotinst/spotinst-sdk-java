package com.spotinst.sdkjava.model.requests.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.AzureStatefulNodeStateEnum;

import java.util.Set;

public class StatefulNodeStateChangeRequest {

    private Set<String>                isSet;
    private  AzureStatefulNodeStateEnum state;

    private StatefulNodeStateChangeRequest() {

    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public AzureStatefulNodeStateEnum getState() {
        return state;
    }

    public void setState(AzureStatefulNodeStateEnum state) {
        this.state = state;
    }

    //region Builder class
    public static class Builder {
        private StatefulNodeStateChangeRequest nodeStateRequest;

        private Builder() {
            this.nodeStateRequest = new StatefulNodeStateChangeRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setState(final AzureStatefulNodeStateEnum state) {
            nodeStateRequest.setState(state);
            return this;
        }

        public StatefulNodeStateChangeRequest build() {
            return nodeStateRequest;
        }

    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }
    //endregion
}
