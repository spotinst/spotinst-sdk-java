package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupGetImportStatefulStatusResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             statefulMigrationId;
    private String                                             groupId;
    private String                                             instanceId;
    private String                                             state;
    private String                                             stateDescription;

    public ApiElastigroupGetImportStatefulStatusResponse() {
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
        this.stateDescription = stateDescription;
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
