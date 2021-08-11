package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiScheduling {

    @JsonIgnore
    private Set<String> isSet;
    private List<ApiTasks> tasks;

    private ApiScheduling() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiTasks> tasks() {
        return tasks;
    }

    public void setTasks(List<ApiTasks> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }

}
