package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GetMigrationStatus {

    @JsonIgnore
    private Set<String> isSet;
    private String      migrationId;
    private String      managedInstanceId;
    private String      instanceId;
    private String      state;
    private String      stateDescription;

    private GetMigrationStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getMigrationId() {
        return migrationId;
    }

    public void setMigrationId(String migrationId) {
        this.migrationId = migrationId;
    }

    public String getManagedInstanceId() {
        return managedInstanceId;
    }

    public void setManagedInstanceId(String managedInstanceId) {
        this.managedInstanceId = managedInstanceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public static class Builder {
        private GetMigrationStatus getMigrationStatus;

        private Builder() {
            this.getMigrationStatus = new GetMigrationStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setInstanceId(final String instanceId) {
            getMigrationStatus.setInstanceId(instanceId);
            return this;
        }

        public Builder setMigrationId(final String migrationId) {
            getMigrationStatus.setMigrationId(migrationId);
            return this;
        }

        public Builder setManagedInstanceId(final String managedInstanceId) {
            getMigrationStatus.setManagedInstanceId(managedInstanceId);
            return this;
        }

        public Builder setState(final String state) {
            getMigrationStatus.setState(state);
            return this;
        }

        public Builder setStateDescription(final String stateDescription) {
            getMigrationStatus.setStateDescription(stateDescription);
            return this;
        }

        public GetMigrationStatus build() {
            return getMigrationStatus;
        }
    }


    @JsonIgnore
    public boolean isMigrationIdSet() {
        return isSet.contains("migrationId");
    }

    @JsonIgnore
    public boolean isManagedInstanceIdSet() {
        return isSet.contains("managedInstanceId");
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

