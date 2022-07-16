package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ImportResponse {

    @JsonIgnore
    private Set<String>              isSet;
    private String                   migrationId;
    private String                   managedInstanceId;
    private ImportDataResponse       data;
    private String                   state;

    private ImportResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMigrationId() {
        return migrationId;
    }

    public void setMigrationId(String migrationId) {
        isSet.add("migrationId");
        this.migrationId = migrationId;
    }

    public String getManagedInstanceId() {
        return managedInstanceId;
    }

    public void setManagedInstanceId(String managedInstanceId) {
        isSet.add("managedInstanceId");
        this.managedInstanceId = managedInstanceId;
    }

    public ImportDataResponse getData() {
        return data;
    }

    public void setData(ImportDataResponse data) {
        isSet.add("data");
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }


    public static class Builder {
        private ImportResponse importBuilder;

        private Builder() {
            this.importBuilder = new ImportResponse();
        }

        public Builder setMigrationId(final String migrationId) {
            importBuilder.setMigrationId(migrationId);
            return this;
        }

        public Builder setManagedInstanceId(final String managedInstanceId) {
            importBuilder.setManagedInstanceId(managedInstanceId);
            return this;
        }

        public Builder setData(final ImportDataResponse data) {
            importBuilder.setData(data);
            return this;
        }

        public Builder setState(final String state) {
            importBuilder.setState(state);
            return this;
        }


        public static Builder get() {
            return new Builder();
        }

        public ImportResponse build() {
            return importBuilder;
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
    public boolean isDatSet() {
        return isSet.contains("data");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

}
