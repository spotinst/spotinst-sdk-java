package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterSchedulingConfiguration {

    @JsonIgnore
    private Set<String>                       isSet;
    private List<ClusterTasksConfiguration>   tasks;
    private ClusterShutdownHoursSpecification shutdownHours;

    public ClusterSchedulingConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ClusterTasksConfiguration> getTasks() {
        return tasks;
    }

    public void setTasks(List<ClusterTasksConfiguration> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    public ClusterShutdownHoursSpecification getShutdownHours() {
        return shutdownHours;
    }

    public void setShutdownHours(ClusterShutdownHoursSpecification shutdownHours) {
        isSet.add("shutdownHours");
        this.shutdownHours = shutdownHours;
    }

    public static class Builder {
        private ClusterSchedulingConfiguration scheduling;

        private Builder() {
            this.scheduling = new ClusterSchedulingConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTasks(final List<ClusterTasksConfiguration> tasks) {
            scheduling.setTasks(tasks);
            return this;
        }

        public Builder setShutdownHours(final ClusterShutdownHoursSpecification shutdownHours) {
            scheduling.setShutdownHours(shutdownHours);
            return this;
        }

        public ClusterSchedulingConfiguration build() {
            return scheduling;
        }
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
