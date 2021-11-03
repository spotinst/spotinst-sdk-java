package com.spotinst.sdkjava.model.requests.elastigroup.azure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiSuspendgroupProcessesAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.SuspendGroupProcessesAzure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuspendgroupRequestAzure {

    @JsonProperty("processes")
    private List<SuspendGroupProcessesAzure> suspendGroup;
    private String                           groupId;

    private SuspendgroupRequestAzure() {

    }

    public List<SuspendGroupProcessesAzure> getSuspendGroup() {
        return suspendGroup;
    }

    public void setSuspendGroup(List<SuspendGroupProcessesAzure> suspendGroup) {
        this.suspendGroup = suspendGroup;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static class Builder {
        private SuspendgroupRequestAzure suspendGroupProcesses;

        private Builder() {
            this.suspendGroupProcesses = new SuspendgroupRequestAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setSuspendGroup(final List<SuspendGroupProcessesAzure> suspendGroup) {
            suspendGroupProcesses.setSuspendGroup(suspendGroup);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            suspendGroupProcesses.setGroupId(groupId);
            return this;
        }

        public SuspendgroupRequestAzure build() {
            return suspendGroupProcesses;
        }
    }

    public String toJson() {
        List<ApiSuspendgroupProcessesAzure> apiSuspendGroup = ElastigroupConverterAzure.toDalForSuspendProcess(suspendGroup);
        Map<String, List<ApiSuspendgroupProcessesAzure>> suspendRequest = new HashMap<>();
        suspendRequest.put("processes", apiSuspendGroup);
        String suspendGroupJson = JsonMapper.toJson(suspendRequest);

        return suspendGroupJson;
    }
}
