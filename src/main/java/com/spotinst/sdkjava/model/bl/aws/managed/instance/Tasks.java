package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class Tasks {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      cronExpression;
    private String      frequency;
    private Boolean     isEnabled;
    private String      startTime;
    private String      taskType;

    //endregion

    //region constructor
    private Tasks() {
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

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        isSet.add("cronExpression");
        this.cronExpression = cronExpression;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        isSet.add("frequency");
        this.frequency = frequency;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        isSet.add("startTime");
        this.startTime = startTime;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        isSet.add("taskType");
        this.taskType = taskType;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private Tasks tasks;

        private Builder() {
            this.tasks = new Tasks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCronExpression(final String cronExpression) {
            tasks.setCronExpression(cronExpression);
            return this;
        }

        public Builder setFrequency(final String frequency) {
            tasks.setFrequency(frequency);
            return this;
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            tasks.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setStartTime(final String startTime) {
            tasks.setStartTime(startTime);
            return this;
        }

        public Builder setTaskType(final String taskType) {
            tasks.setTaskType(taskType);
            return this;
        }

        public Tasks build() {
            // TODO : Validations
            return tasks;
        }
    }
    //endregion

    //region isSet methods
    // Is cronExpression Set boolean method
    @JsonIgnore
    public boolean isCronExpressionSet() {
        return isSet.contains("cronExpression");
    }

    // Is frequency Set boolean method
    @JsonIgnore
    public boolean isFrequencySet() {
        return isSet.contains("frequency");
    }

    // Is isEnabled Set boolean method
    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    // Is startTime Set boolean method
    @JsonIgnore
    public boolean isStartTimeSet() {
        return isSet.contains("startTime");
    }

    // Is taskType Set boolean method
    @JsonIgnore
    public boolean isTaskTypeSet() {
        return isSet.contains("taskType");
    }

    //endregion
}
