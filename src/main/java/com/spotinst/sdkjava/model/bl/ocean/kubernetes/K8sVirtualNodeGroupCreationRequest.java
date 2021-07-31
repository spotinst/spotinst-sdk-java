package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.OceanK8sVirtalNodeGroupConverter;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVirtualNodeGroup;

import java.util.HashMap;
import java.util.Map;

public class K8sVirtualNodeGroupCreationRequest {
	
	@JsonProperty("launchSpec")
    private K8sVirtualNodeGroup launchSpec;

    private K8sVirtualNodeGroupCreationRequest() {
    }

    //region Getters & Setters
    public K8sVirtualNodeGroup getLaunchSpec() {
        return launchSpec;
    }

    public void setLaunchSpec(K8sVirtualNodeGroup launchSpec) {
        this.launchSpec = launchSpec;
    }
	
	public static class Builder {
        private K8sVirtualNodeGroupCreationRequest launchSpecCreationRequest;

        private Builder() {
            this.launchSpecCreationRequest = new K8sVirtualNodeGroupCreationRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setlaunchSpec(final K8sVirtualNodeGroup k8sVirtualNodeGroup) {
            launchSpecCreationRequest.setLaunchSpec(k8sVirtualNodeGroup);
            return this;
        }

        public K8sVirtualNodeGroupCreationRequest build() {
            return launchSpecCreationRequest;
        }

    }

    public String toJson() {
        ApiK8sVirtualNodeGroup apiLaunchSpecToCreate = OceanK8sVirtalNodeGroupConverter.toDal(launchSpec);

        Map<String, ApiK8sVirtualNodeGroup> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", apiLaunchSpecToCreate);
        String launchSpecJson = JsonMapper.toJson(launchSpecRequest);

        return launchSpecJson;
    }
}
