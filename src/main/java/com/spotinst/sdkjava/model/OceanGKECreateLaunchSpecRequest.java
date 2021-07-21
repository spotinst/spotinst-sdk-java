package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.model.bl.gcp.ElastigroupGcp;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKECreateLaunchSpecRes;

public class OceanGKECreateLaunchSpecRequest {

    @JsonProperty("group")
    private OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes;

    public OceanGKECreateLaunchSpecRes getOceanGKECreateLaunchSpecRes() {
        return oceanGKECreateLaunchSpecRes;
    }

    public void setOceanGKECreateLaunchSpecRes(OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes) {
        this.oceanGKECreateLaunchSpecRes = oceanGKECreateLaunchSpecRes;
    }

    private OceanGKECreateLaunchSpecRequest() {
    }

    public static class Builder {
        private OceanGKECreateLaunchSpecRequest oceanGKECreateLaunchSpecRequest;

        private Builder() {
            this.oceanGKECreateLaunchSpecRequest = new OceanGKECreateLaunchSpecRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setOceanGKECreateLaunchSpec(final OceanGKECreateLaunchSpecRes oceanGKECreateLaunchSpecRes) {
            oceanGKECreateLaunchSpecRequest.setOceanGKECreateLaunchSpecRes(oceanGKECreateLaunchSpecRes);
            return this;
        }

        public OceanGKECreateLaunchSpecRequest build() {
            return oceanGKECreateLaunchSpecRequest;
        }

    }
}
