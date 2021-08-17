package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiScheduling {

    @JsonIgnore
    private Set<String> isSet;
    private List<ApiTasks> tasks;

    public ApiScheduling() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiTasks> getTasks() {
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
