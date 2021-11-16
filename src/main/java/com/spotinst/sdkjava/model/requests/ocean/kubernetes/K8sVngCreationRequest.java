package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVngSpec;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.K8sVngSpec;
import com.spotinst.sdkjava.model.converters.K8sVngConverter;

import java.util.HashMap;
import java.util.Map;

public class K8sVngCreationRequest {
	
	@JsonProperty("launchSpec")
    private K8sVngSpec vngLaunchSpec;

    private K8sVngCreationRequest() {
    }

    //region Getters & Setters
    public K8sVngSpec getVngLaunchSpec() {
        return vngLaunchSpec;
    }

    public void setVngLaunchSpec(K8sVngSpec vngLaunchSpec) {
        this.vngLaunchSpec = vngLaunchSpec;
    }
	
	public static class Builder {
        private K8sVngCreationRequest launchSpecCreationRequest;

        private Builder() {
            this.launchSpecCreationRequest = new K8sVngCreationRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setVngLaunchSpec(final K8sVngSpec k8sVirtualNodeGroup) {
            launchSpecCreationRequest.setVngLaunchSpec(k8sVirtualNodeGroup);
            return this;
        }

        public K8sVngCreationRequest build() {
            return launchSpecCreationRequest;
        }

    }

    public String toJson() {
        ApiK8sVngSpec apiLaunchSpecToCreate = K8sVngConverter.toDal(vngLaunchSpec);

        Map<String, ApiK8sVngSpec> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", apiLaunchSpecToCreate);
        String launchSpecJson = JsonMapper.toJson(launchSpecRequest);

        return launchSpecJson;
    }
}
