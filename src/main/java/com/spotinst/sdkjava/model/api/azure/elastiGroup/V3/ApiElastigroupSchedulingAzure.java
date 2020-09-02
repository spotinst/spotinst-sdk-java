package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiElastigroupSchedulingAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private List<ApiElastigroupScheduledTaskAzure> tasks;

    //endregion

    //region Constructor
    public ApiElastigroupSchedulingAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupScheduledTaskAzure> getTasks() {
        return tasks;
    }

    public void setTasks(List<ApiElastigroupScheduledTaskAzure> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    //endregion
    //region isSet methods
    // Is tasks Set boolean method
    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }
    //endregion
}
