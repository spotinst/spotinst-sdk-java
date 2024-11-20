package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScheduleTasksConfigurationGcp {

    @JsonIgnore
    private Set<String>             isSet;
    private String                  cronExpression;
    private Boolean                 isEnabled;
    private Integer                 maxCapacity;
    private Integer                 minCapacity;
    private Integer                 targetCapacity;
    private String                  taskType;

    private ElastigroupScheduleTasksConfigurationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        isSet.add("cronExpression");
        this.cronExpression = cronExpression;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        isSet.add("taskType");

        this.taskType = taskType;
    }

    public Integer getTargetCapacity() {
        return targetCapacity;
    }

    public void setTargetCapacity(Integer targetCapacity) {
        isSet.add("targetCapacity");
        this.targetCapacity = targetCapacity;
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity) {
        isSet.add("minCapacity");
        this.minCapacity = minCapacity;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        isSet.add("maxCapacity");
        this.maxCapacity = maxCapacity;
    }

    public static class Builder {
        private ElastigroupScheduleTasksConfigurationGcp tasks;

        private Builder() {
            this.tasks = new ElastigroupScheduleTasksConfigurationGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            tasks.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setCronExpression(final String cronExpression) {
            tasks.setCronExpression(cronExpression);
            return this;
        }

        public Builder setTaskType(final String taskType) {
            tasks.setTaskType(taskType);
            return this;
        }

        public Builder setTargetCapacity(final Integer targetCapacity) {
            tasks.setTargetCapacity(targetCapacity);
            return this;
        }

        public Builder setMinCapacity(final Integer minCapacity) {
            tasks.setMinCapacity(minCapacity);
            return this;
        }

        public Builder setMaxCapacity(final Integer maxCapacity) {
            tasks.setMaxCapacity(maxCapacity);
            return this;
        }

        public ElastigroupScheduleTasksConfigurationGcp build() {
            return tasks;
        }

    }

    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isCronExpressionSet() {
        return isSet.contains("cronExpression");
    }

    @JsonIgnore
    public boolean isTaskTypeSet() {
        return isSet.contains("taskType");
    }

    @JsonIgnore
    public boolean isTargetCapacitySet() {
        return isSet.contains("targetCapacity");
    }

    @JsonIgnore
    public boolean isMinCapacitySet() {
        return isSet.contains("minCapacity");
    }

    @JsonIgnore
    public boolean isMaxCapacitySet() {
        return isSet.contains("maxCapacity");
    }
}
