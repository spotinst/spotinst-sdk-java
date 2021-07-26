package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKELaunchSpec;

import java.util.HashMap;
import java.util.Map;

public class OceanGKECreateLaunchSpecRequest {

    @JsonProperty("launchSpec")
    private OceanGKELaunchSpec oceanGKECreateLaunchSpecRes;

    public OceanGKELaunchSpec getOceanGKECreateLaunchSpecRes() {
        return oceanGKECreateLaunchSpecRes;
    }

    public void setOceanGKECreateLaunchSpecRes(OceanGKELaunchSpec oceanGKECreateLaunchSpecRes) {
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

        public Builder setOceanGKECreateLaunchSpec(final OceanGKELaunchSpec oceanGKECreateLaunchSpecRes) {
            oceanGKECreateLaunchSpecRequest.setOceanGKECreateLaunchSpecRes(oceanGKECreateLaunchSpecRes);
            return this;
        }

        public OceanGKECreateLaunchSpecRequest build() {
            return oceanGKECreateLaunchSpecRequest;
        }

    }

    public String toJson() {
        ApiOceanGKELaunchSpec apiOceanGKELaunchSpec = OceanGKELaunchSpecConverter.toDal(oceanGKECreateLaunchSpecRes);

        Map<String, ApiOceanGKELaunchSpec> createLaunchSpecRequest = new HashMap<>();
        createLaunchSpecRequest.put("launchSpec", apiOceanGKELaunchSpec);
        String retVal = JsonMapper.toJson(createLaunchSpecRequest);

        return retVal;
    }
}
