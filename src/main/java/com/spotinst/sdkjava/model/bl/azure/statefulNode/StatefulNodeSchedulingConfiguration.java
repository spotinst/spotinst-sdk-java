package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeSchedulingConfiguration {
    @JsonIgnore
    private Set<String>                          isSet;
    private List<StatefulNodeTasksConfiguration> tasks;

    public StatefulNodeSchedulingConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<StatefulNodeTasksConfiguration> getTasks() {
        return tasks;
    }

    public void setTasks(List<StatefulNodeTasksConfiguration> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    public static class Builder {
        private StatefulNodeSchedulingConfiguration scheduling;

        private Builder() {
            this.scheduling = new StatefulNodeSchedulingConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTasks(final List<StatefulNodeTasksConfiguration> tasks) {
            scheduling.setTasks(tasks);
            return this;
        }

        public StatefulNodeSchedulingConfiguration build() {
            return scheduling;
        }
    }

    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }

}
