package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetImportStatefulStatusResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             statefulMigrationId;
    private String                                             groupId;
    private String                                             instanceId;
    private String                                             state;
    private String                                             stateDescription;

    public ElastigroupGetImportStatefulStatusResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getStatefulMigrationId() {
        return statefulMigrationId;
    }

    public void setStatefulMigrationId(String statefulMigrationId) {
        isSet.add("statefulMigrationId");
        this.statefulMigrationId = statefulMigrationId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        isSet.add("stateDescription");
        this.state = stateDescription;
    }

    public static class Builder {
        private ElastigroupGetImportStatefulStatusResponse elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new ElastigroupGetImportStatefulStatusResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupGetImportStatefulStatusResponse.Builder setStatefulMigrationId(final String statefulMigrationId) {
            elastigroupGetDeploymentStatusInstances.setStatefulMigrationId(statefulMigrationId);
            return this;
        }

        public ElastigroupGetImportStatefulStatusResponse.Builder setGroupId(final String groupId) {
            elastigroupGetDeploymentStatusInstances.setGroupId(groupId);
            return this;
        }

        public ElastigroupGetImportStatefulStatusResponse.Builder setState(final String state) {
            elastigroupGetDeploymentStatusInstances.setState(state);
            return this;
        }

        public Builder setInstanceId(final String instanceId) {
            elastigroupGetDeploymentStatusInstances.setInstanceId(instanceId);
            return this;
        }

        public ElastigroupGetImportStatefulStatusResponse.Builder setStateDescription(final String stateDescription) {
            elastigroupGetDeploymentStatusInstances.setStateDescription(stateDescription);
            return this;
        }

        public ElastigroupGetImportStatefulStatusResponse build() {
            return elastigroupGetDeploymentStatusInstances;
        }

    }

    @JsonIgnore
    public boolean isStatefulMigrationIdSet() {
        return isSet.contains("statefulMigrationId");
    }

    @JsonIgnore
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isStateDescriptionSet() {
        return isSet.contains("stateDescription");
    }

}
