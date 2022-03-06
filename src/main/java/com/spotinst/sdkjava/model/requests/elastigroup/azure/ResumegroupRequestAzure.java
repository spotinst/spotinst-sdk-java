package com.spotinst.sdkjava.model.requests.elastigroup.azure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiResumeGroupProcessesAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ResumeGroupProcessesAzure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumegroupRequestAzure {

    @JsonProperty("processes")
    private List<ResumeGroupProcessesAzure> resumeGroup;
    private String                          groupId;

    private ResumegroupRequestAzure() {

    }

    public List<ResumeGroupProcessesAzure> getResumeGroup() {
        return resumeGroup;
    }

    public void setResumeGroup(List<ResumeGroupProcessesAzure> resumeGroup) {
        this.resumeGroup = resumeGroup;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static class Builder {
        private ResumegroupRequestAzure resumeGroupProcesses;

        private Builder() {
            this.resumeGroupProcesses = new ResumegroupRequestAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setResumeGroup(final List<ResumeGroupProcessesAzure> resumeGroup) {
            resumeGroupProcesses.setResumeGroup(resumeGroup);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            resumeGroupProcesses.setGroupId(groupId);
            return this;
        }

        public ResumegroupRequestAzure build() {
            return resumeGroupProcesses;
        }
    }

    public String toJson() {
        List<ApiResumeGroupProcessesAzure> apiResumeGroup = ElastigroupConverterAzure.toDal(resumeGroup);
        Map<String, List<ApiResumeGroupProcessesAzure>> resumeRequest = new HashMap<>();
        resumeRequest.put("processes", apiResumeGroup);

        return JsonMapper.toJson(resumeRequest);
    }
}
