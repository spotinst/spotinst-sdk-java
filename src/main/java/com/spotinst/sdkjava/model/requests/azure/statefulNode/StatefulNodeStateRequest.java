package com.spotinst.sdkjava.model.requests.azure.statefulNode;

public class StatefulNodeStateRequest {

    private String state;

    private StatefulNodeStateRequest() {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

        public Builder setState(final String state) {
            nodeStateRequest.setState(state);
            return this;
        }


        public StatefulNodeStateRequest build() {
            return nodeStateRequest;
        }

    }
    //endregion
}
