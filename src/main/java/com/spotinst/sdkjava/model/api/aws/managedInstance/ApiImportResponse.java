package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiImportResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>              isSet;
    private String                   migrationId;
    private String                   managedInstanceId;
    private ApiImportDataResponse    data;
    private String                   state;

    public ApiImportResponse() {
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

    public ApiImportDataResponse getData() {
        return data;
    }

    public void setData(ApiImportDataResponse data) {
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

    @JsonIgnore
    public boolean isMigrationIdSet() {
        return isSet.contains("migrationId");
    }

    @JsonIgnore
    public boolean isManagedInstanceIdSet() {
        return isSet.contains("managedInstanceId");
    }

    @JsonIgnore
    public boolean isDataSet() {
        return isSet.contains("data");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

}
