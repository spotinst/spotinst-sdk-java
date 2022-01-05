package com.spotinst.sdkjava.model.requests.azure.statefulNode;

import com.spotinst.sdkjava.enums.AzureStatefulNodeStateEnum;

public class StatefulNodeStateRequest {

    private AzureStatefulNodeStateEnum state;

    private StatefulNodeStateRequest() {

    }

    public AzureStatefulNodeStateEnum getState() {
        return state;
    }

    public void setState(AzureStatefulNodeStateEnum state) {
        this.state = state;
    }

    //region Builder class
    public static class Builder {
        private StatefulNodeStateRequest nodeStateRequest;

        private Builder() {
            this.nodeStateRequest = new StatefulNodeStateRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setState(final AzureStatefulNodeStateEnum state) {
            nodeStateRequest.setState(state);
            return this;
        }

        public StatefulNodeStateRequest build() {
            return nodeStateRequest;
        }

    }
    //endregion
}
