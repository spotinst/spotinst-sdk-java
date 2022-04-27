package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupSchedulingConfiguration {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private List<TasksConfiguration> tasks;
    //endregion

    //region Constructor

    private ElastigroupSchedulingConfiguration() {
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

    public List<TasksConfiguration> getTasks() {
        return tasks;
    }

    public void setTasks(List<TasksConfiguration> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupSchedulingConfiguration scheduling;

        private Builder() {
            this.scheduling = new ElastigroupSchedulingConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTasks(final List<TasksConfiguration> tasks) {
            scheduling.setTasks(tasks);
            return this;
        }

        public ElastigroupSchedulingConfiguration build() {
            return scheduling;
        }
    }
    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }
    //endregion
}
