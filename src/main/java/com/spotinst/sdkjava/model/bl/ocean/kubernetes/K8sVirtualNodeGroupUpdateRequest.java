package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.OceanK8sVirtalNodeGroupConverter;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiK8sVirtualNodeGroup;

import java.util.HashMap;
import java.util.Map;

public class K8sVirtualNodeGroupUpdateRequest {

    @JsonProperty("launchSpec")
    private K8sVirtualNodeGroup launchSpec;

    private K8sVirtualNodeGroupUpdateRequest() {
    }

    //Getters & Setters
    public K8sVirtualNodeGroup getVirtualNodeGroup() {
        return launchSpec;
    }

    public void setOceanLaunchSpecId(K8sVirtualNodeGroup launchSpec) {
        this.launchSpec = launchSpec;
    }

    //Builder class
    public static class Builder {
        private K8sVirtualNodeGroupUpdateRequest virtualNodeGroupUpdateRequest;

        private Builder() {
            this.virtualNodeGroupUpdateRequest = new K8sVirtualNodeGroupUpdateRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setVirtualNodeGroup(final K8sVirtualNodeGroup k8sVirtualNodeGroup) {
            virtualNodeGroupUpdateRequest.setOceanLaunchSpecId(k8sVirtualNodeGroup);
            return this;
        }

        public K8sVirtualNodeGroupUpdateRequest build() {
            return virtualNodeGroupUpdateRequest;
        }

    }

    //region Json methods
    public String toJson() {
        ApiK8sVirtualNodeGroup apiVirtualNodeGroupToUpdate = OceanK8sVirtalNodeGroupConverter.toDal(launchSpec);

        Map<String, ApiK8sVirtualNodeGroup> virtualNodeGroupRequest = new HashMap<>();
        virtualNodeGroupRequest.put("launchSpec", apiVirtualNodeGroupToUpdate);
        String virtualNodGroupJson = JsonMapper.toJson(virtualNodeGroupRequest);

        return virtualNodGroupJson;
    }
}
