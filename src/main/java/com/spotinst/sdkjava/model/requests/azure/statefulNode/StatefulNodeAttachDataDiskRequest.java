package com.spotinst.sdkjava.model.requests.azure.statefulNode;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNodeAttachDataDiskConfiguration;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNodeAttachDataDiskConfiguration;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;

import java.util.HashMap;
import java.util.Map;

public class StatefulNodeAttachDataDiskRequest {

        private StatefulNodeAttachDataDiskConfiguration attachDataDisk;

        private StatefulNodeAttachDataDiskRequest(){
        }

        public StatefulNodeAttachDataDiskConfiguration getAttachDataDisk() {
            return attachDataDisk;
        }

        public void setAttachDataDisk(StatefulNodeAttachDataDiskConfiguration attachDataDisk) {
            this.attachDataDisk = attachDataDisk;
        }

        public static class Builder {
            private StatefulNodeAttachDataDiskRequest attachDiskRequest;

            private Builder() {
                this.attachDiskRequest = new StatefulNodeAttachDataDiskRequest();
            }

            public static Builder get() {
                Builder builder = new Builder();
                return builder;
            }

            public Builder setAttachDataDisk(final StatefulNodeAttachDataDiskConfiguration attachDataDisk) {
                attachDiskRequest.setAttachDataDisk(attachDataDisk);
                return this;
            }

            public StatefulNodeAttachDataDiskRequest build() {
                return attachDiskRequest;
            }

        }



        public String toJson() {
            ApiStatefulNodeAttachDataDiskConfiguration apiStatefulNodeToAttach = StatefulNodeConverter.toDal(attachDataDisk);
            Map<String, ApiStatefulNodeAttachDataDiskConfiguration> diskRequest             = new HashMap<>();
            String NodeJson = JsonMapper.toJson(diskRequest);
            return NodeJson;
        }
}
