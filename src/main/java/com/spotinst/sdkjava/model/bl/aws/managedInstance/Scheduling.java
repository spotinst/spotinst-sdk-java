package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scheduling {

    @JsonIgnore
    private Set<String> isSet;
    private List<Tasks> tasks;

    private Scheduling() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    public static class Builder {
        private Scheduling scheduling;

        private Builder() {
            this.scheduling = new Scheduling();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setTasks(final List<Tasks> tasks) {
            scheduling.setTasks(tasks);
            return this;
        }

        public Scheduling build() {
            // TODO : Validations
            return scheduling;
        }
    }

    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }
}
