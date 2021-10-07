package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.RecurrenceFrequencyEnum;
import com.spotinst.sdkjava.enums.SchedulingTaskTypeEnum;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tasks {

    @JsonIgnore
    private Set<String>                  isSet;
    private String                       cronExpression;
    private RecurrenceFrequencyEnum      frequency;
    private Boolean                      isEnabled;
    private Date                         startTime;
    private SchedulingTaskTypeEnum       taskType;

    private Tasks() {
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

    public RecurrenceFrequencyEnum getFrequency() {
        return frequency;
    }

    public void setFrequency(RecurrenceFrequencyEnum frequency) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        isSet.add("startTime");
        this.startTime = startTime;
    }

    public SchedulingTaskTypeEnum getTaskType() {
        return taskType;
    }

    public void setTaskType(SchedulingTaskTypeEnum taskType) {
        isSet.add("taskType");
        this.taskType = taskType;
    }

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

        public Builder setFrequency(final RecurrenceFrequencyEnum frequency) {
            tasks.setFrequency(frequency);
            return this;
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            tasks.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setStartTime(final Date startTime) {
            tasks.setStartTime(startTime);
            return this;
        }

        public Builder setTaskType(final SchedulingTaskTypeEnum taskType) {
            tasks.setTaskType(taskType);
            return this;
        }

        public Tasks build() {
            return tasks;
        }
    }

    @JsonIgnore
    public boolean isCronExpressionSet() {
        return isSet.contains("cronExpression");
    }

    @JsonIgnore
    public boolean isFrequencySet() {
        return isSet.contains("frequency");
    }

    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isStartTimeSet() {
        return isSet.contains("startTime");
    }

    @JsonIgnore
    public boolean isTaskTypeSet() {
        return isSet.contains("taskType");
    }
}
