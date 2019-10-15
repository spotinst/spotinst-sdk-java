package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiScheduling implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>            isSet;
    private List<ApiScheduledTask> tasks;

    //endregion

    //region Constructor
    public ApiScheduling() {
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

    public List<ApiScheduledTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ApiScheduledTask> tasks) {
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
