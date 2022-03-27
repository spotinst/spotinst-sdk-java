package com.spotinst.sdkjava.model.requests.ocean.gke;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.converters.ocean.gke.OceanGkeConverter;
import com.spotinst.sdkjava.model.api.ocean.gke.ApiLaunchSpecSpecification;
import com.spotinst.sdkjava.model.bl.ocean.gke.LaunchSpecSpecification;

import java.util.HashMap;
import java.util.Map;

public class LaunchSpecRequest {

    @JsonProperty("launchSpec")
    private LaunchSpecSpecification launchSpecSpecification;
    private String                  launchSpecId;

    public LaunchSpecSpecification getOceanGKECreateLaunchSpecRes() {
        return launchSpecSpecification;
    }

    public void setOceanGKECreateLaunchSpecRes(LaunchSpecSpecification launchSpecSpecification) {
        this.launchSpecSpecification = launchSpecSpecification;
    }

    public String getLaunchSpecId() {
        return launchSpecId;
    }

    public void setLaunchSpecId(String launchSpecId) {
        this.launchSpecId = launchSpecId;
    }

    private LaunchSpecRequest() {
    }

    public static class Builder {
        private LaunchSpecRequest launchSpecRequest;

        private Builder() {
            this.launchSpecRequest = new LaunchSpecRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOceanGKELaunchSpec(final LaunchSpecSpecification launchSpecSpecification) {
            launchSpecRequest.setOceanGKECreateLaunchSpecRes(launchSpecSpecification);
            return this;
        }


        public Builder setLaunchSpecId(final String launchSpecId) {
            launchSpecRequest.setLaunchSpecId(launchSpecId);
            return this;
        }
        public LaunchSpecRequest build() {
            return launchSpecRequest;
        }

    }

    public String toJson() {
        ApiLaunchSpecSpecification
                apiLaunchSpecSpecification = OceanGkeConverter.toDal(launchSpecSpecification);

        Map<String, ApiLaunchSpecSpecification> createLaunchSpecRequest = new HashMap<>();
        createLaunchSpecRequest.put("launchSpec", apiLaunchSpecSpecification);

        return JsonMapper.toJson(createLaunchSpecRequest);
    }
}
