package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiClusterSchedulingConfiguration implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                 isSet;
    private List<ApiClusterTasksConfiguration>          tasks;
    private ApiClusterShutdownHoursSpecification        shutdownHours;

    public ApiClusterSchedulingConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiClusterTasksConfiguration> getTasks() {
        return tasks;
    }

    public void setTasks(List<ApiClusterTasksConfiguration> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    public ApiClusterShutdownHoursSpecification getShutdownHours() {
        return shutdownHours;
    }

    public void setShutdownHours(ApiClusterShutdownHoursSpecification shutdownHours) {
        isSet.add("shutdownHours");
        this.shutdownHours = shutdownHours;
    }

    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }

    @JsonIgnore
    public boolean isShutdownHoursSet() {
        return isSet.contains("shutdownHours");
    }
}
