package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupSchedulingConfigurationAzure {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private List<TasksConfigurationAzure> tasks;
    //endregion

    //region Constructor

    private ElastigroupSchedulingConfigurationAzure() {
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

    public List<TasksConfigurationAzure> getTasks() {
        return tasks;
    }

    public void setTasks(List<TasksConfigurationAzure> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupSchedulingConfigurationAzure scheduling;

        private Builder() {
            this.scheduling = new ElastigroupSchedulingConfigurationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTasks(final List<TasksConfigurationAzure> tasks) {
            scheduling.setTasks(tasks);
            return this;
        }

        public ElastigroupSchedulingConfigurationAzure build() {
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
