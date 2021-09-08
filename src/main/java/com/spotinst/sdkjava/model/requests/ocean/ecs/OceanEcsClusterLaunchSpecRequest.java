package com.spotinst.sdkjava.model.requests.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.ecs.ApiClusterLaunchSpecification;
import com.spotinst.sdkjava.model.bl.ocean.ecs.ClusterLaunchSpecification;
import com.spotinst.sdkjava.model.converters.ocean.ecs.OceanEcsConverter;

import java.util.HashMap;
import java.util.Map;

public class OceanEcsClusterLaunchSpecRequest {
    @JsonProperty("launchSpec")
    private ClusterLaunchSpecification launchspec;
    private String                     oceanLaunchSpecId;

    private OceanEcsClusterLaunchSpecRequest() {
    }

    public ClusterLaunchSpecification getLaunchspec() {
        return launchspec;
    }

    public void setLaunchspec(ClusterLaunchSpecification launchspec) {
        this.launchspec = launchspec;
    }

    public String getOceanLaunchSpecId() {
        return oceanLaunchSpecId;
    }

    public void setOceanLaunchSpecId(String oceanLaunchSpecId) {
        this.oceanLaunchSpecId = oceanLaunchSpecId;
    }

    //region Builder class
    public static class Builder {
        private OceanEcsClusterLaunchSpecRequest launchSpecRequest;

        private Builder() {
            this.launchSpecRequest = new OceanEcsClusterLaunchSpecRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setLaunchSpec(final ClusterLaunchSpecification launchSpecification) {
            launchSpecRequest.setLaunchspec(launchSpecification);
            return this;
        }

        public Builder setOceanLaunchSpecId(final String oceanLaunchSpecId) {
            launchSpecRequest.setOceanLaunchSpecId(oceanLaunchSpecId);
            return this;
        }

        public OceanEcsClusterLaunchSpecRequest build() {
            return launchSpecRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiClusterLaunchSpecification apiLaunchSpecToCreate = OceanEcsConverter.toDal(launchspec);

        Map<String, ApiClusterLaunchSpecification> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", apiLaunchSpecToCreate);
        String launchSpecJson = JsonMapper.toJson(launchSpecRequest);

        return launchSpecJson;
    }
    //endregion
}
