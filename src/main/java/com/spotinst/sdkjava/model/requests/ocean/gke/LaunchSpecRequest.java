package com.spotinst.sdkjava.model.requests.ocean.gke;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.converters.ocean.gke.OceanGKELaunchSpecConverter;
import com.spotinst.sdkjava.model.api.ocean.gke.ApiLaunchSpecSpecification;
import com.spotinst.sdkjava.model.bl.ocean.gke.LaunchSpecSpecification;

import java.util.HashMap;
import java.util.Map;

public class LaunchSpecRequest {

    @JsonProperty("launchSpec")
    private LaunchSpecSpecification launchSpecSpecification;

    public LaunchSpecSpecification getOceanGKECreateLaunchSpecRes() {
        return launchSpecSpecification;
    }

    public void setOceanGKECreateLaunchSpecRes(LaunchSpecSpecification launchSpecSpecification) {
        this.launchSpecSpecification = launchSpecSpecification;
    }

    private LaunchSpecRequest() {
    }

    public static class Builder {
        private LaunchSpecRequest launchSpecRequest;

        private Builder() {
            this.launchSpecRequest = new LaunchSpecRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setOceanGKELaunchSpec(final LaunchSpecSpecification launchSpecSpecification) {
            launchSpecRequest.setOceanGKECreateLaunchSpecRes(launchSpecSpecification);
            return this;
        }

        public LaunchSpecRequest build() {
            return launchSpecRequest;
        }

    }

    public String toJson() {
        ApiLaunchSpecSpecification
                apiLaunchSpecSpecification = OceanGKELaunchSpecConverter.toDal(launchSpecSpecification);

        Map<String, ApiLaunchSpecSpecification> createLaunchSpecRequest = new HashMap<>();
        createLaunchSpecRequest.put("launchSpec", apiLaunchSpecSpecification);
        String retVal = JsonMapper.toJson(createLaunchSpecRequest);

        return retVal;
    }
}
