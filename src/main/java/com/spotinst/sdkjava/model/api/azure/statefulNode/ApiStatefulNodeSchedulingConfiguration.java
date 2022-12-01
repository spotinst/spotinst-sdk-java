package com.spotinst.sdkjava.model.api.azure.statefulNode;

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
public class ApiStatefulNodeSchedulingConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                          isSet;
    private List<ApiStatefulNodeTasksConfiguration> tasks;

    public ApiStatefulNodeSchedulingConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiStatefulNodeTasksConfiguration> getTasks() {
        return tasks;
    }

    public void setTasks(List<ApiStatefulNodeTasksConfiguration> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }

}
