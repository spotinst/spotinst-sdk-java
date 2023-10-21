package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupSchedulingGcp {

    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ElastigroupScheduleTasksConfigurationGcp>  tasks;

    private ElastigroupSchedulingGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupScheduleTasksConfigurationGcp> getTasks() {
        return tasks;
    }

    public void setTasks(List<ElastigroupScheduleTasksConfigurationGcp> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    public static class Builder {
        private ElastigroupSchedulingGcp scheduling;

        private Builder() {
            this.scheduling = new ElastigroupSchedulingGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTasks(final List<ElastigroupScheduleTasksConfigurationGcp> tasks) {
            scheduling.setTasks(tasks);
            return this;
        }

        public ElastigroupSchedulingGcp build() {
            return scheduling;
        }
    }

    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }
}
