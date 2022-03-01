package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeImportStatusResponse {

    @JsonIgnore
    private Set<String>                          isSet;
    private String                               statefulImportId;
    private String                               statefulNodeId;
    private String                               vmName;
    private String                               state;

    private NodeImportStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getStatefulImportId() {
        return statefulImportId;
    }

    public void setStatefulImportId(String statefulImportId) {
        isSet.add("statefulImportId");
        this.statefulImportId = statefulImportId;
    }

    public String getStatefulNodeId() {
        return statefulNodeId;
    }

    public void setStatefulNodeId(String statefulNodeId) {
        isSet.add("statefulNodeId");
        this.statefulNodeId = statefulNodeId;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    public static class Builder {
        private NodeImportStatusResponse importStatus;

        private Builder() {
            this.importStatus = new NodeImportStatusResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setStatefulImportId(final String statefulImportId) {
            importStatus.setStatefulImportId(statefulImportId);
            return this;
        }

        public Builder setStatefulNodeId(final String statefulNodeId) {
            importStatus.setStatefulNodeId(statefulNodeId);
            return this;
        }

        public Builder setVmName(final String vmName) {
            importStatus.setVmName(vmName);
            return this;
        }

        public Builder setState(final String state) {
            importStatus.setState(state);
            return this;
        }

        public NodeImportStatusResponse build() {
            return importStatus;
        }
    }
    @JsonIgnore
    public boolean isStatefulImportIdSet() {
        return isSet.contains("statefulImportId");
    }

    @JsonIgnore
    public boolean isStatefulNodeIdSet() {
        return isSet.contains("statefulNodeId");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

}
