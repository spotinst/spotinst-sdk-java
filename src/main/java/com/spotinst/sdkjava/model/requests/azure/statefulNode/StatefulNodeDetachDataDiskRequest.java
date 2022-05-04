package com.spotinst.sdkjava.model.requests.azure.statefulNode;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNodeDetachDataDiskConfiguration;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNodeDetachDataDiskConfiguration;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;

import java.util.HashMap;
import java.util.Map;

public class StatefulNodeDetachDataDiskRequest {

    private StatefulNodeDetachDataDiskConfiguration detachDataDisk;

    private StatefulNodeDetachDataDiskRequest(){
    }

    public StatefulNodeDetachDataDiskConfiguration getDetachDataDisk() {
        return detachDataDisk;
    }

    public void setDetachDataDisk(StatefulNodeDetachDataDiskConfiguration detachDataDisk) {
        this.detachDataDisk = detachDataDisk;
    }

    public static class Builder {
        private StatefulNodeDetachDataDiskRequest detachDataDiskRequest;

        private Builder() {
            this.detachDataDiskRequest = new StatefulNodeDetachDataDiskRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDetachDataDisk(final StatefulNodeDetachDataDiskConfiguration detachDataDisk) {
            detachDataDiskRequest.setDetachDataDisk(detachDataDisk);
            return this;
        }

        public StatefulNodeDetachDataDiskRequest build() {
            return detachDataDiskRequest;
        }

    }


    public String toJson() {
        ApiStatefulNodeDetachDataDiskConfiguration apiStatefulNodeToDetach = StatefulNodeConverter.toDal(detachDataDisk);
        Map<String, ApiStatefulNodeDetachDataDiskConfiguration> diskRequest             = new HashMap<>();
        return JsonMapper.toJson(diskRequest);
    }
}
