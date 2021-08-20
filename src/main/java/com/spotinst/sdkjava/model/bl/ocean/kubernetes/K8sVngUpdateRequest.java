package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVngSpec;
import com.spotinst.sdkjava.model.converters.K8sVngConverter;

import java.util.HashMap;
import java.util.Map;

public class K8sVngUpdateRequest {

    @JsonProperty("launchSpec")
    private K8sVngSpec launchSpec;

    private K8sVngUpdateRequest() {
    }

    //Getters & Setters
    public K8sVngSpec getVngLaunchSpec() {
        return launchSpec;
    }

    public void setOceanLaunchSpecId(K8sVngSpec launchSpec) {
        this.launchSpec = launchSpec;
    }

    //Builder class
    public static class Builder {
        private K8sVngUpdateRequest k8sVngUpdateRequest;

        private Builder() {
            this.k8sVngUpdateRequest = new K8sVngUpdateRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setVngLaunchSpec(final K8sVngSpec launchSpec) {
            k8sVngUpdateRequest.setOceanLaunchSpecId(launchSpec);
            return this;
        }

        public K8sVngUpdateRequest build() {
            return k8sVngUpdateRequest;
        }

    }

    //region Json methods
    public String toJson() {
        ApiK8sVngSpec apiVirtualNodeGroupToUpdate = K8sVngConverter.toDal(launchSpec);

        Map<String, ApiK8sVngSpec> virtualNodeGroupRequest = new HashMap<>();
        virtualNodeGroupRequest.put("launchSpec", apiVirtualNodeGroupToUpdate);
        String virtualNodGroupJson = JsonMapper.toJson(virtualNodeGroupRequest);

        return virtualNodGroupJson;
    }
}
