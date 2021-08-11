package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class Scheduling {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<Tasks> tasks;

    //endregion

    //region constructor
    private Scheduling() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<Tasks> tasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }
    //endregion

    //region Builder class
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
    //endregion

    //region isSet methods
    // Is tasks Set boolean method
    @JsonIgnore
    public boolean isTasksSet() {
        return isSet.contains("tasks");
    }

    //endregion
}
