package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiTasks {

    @JsonIgnore
    private Set<String>             isSet;
    private String                  cronExpression;
    private String                  frequency;
    private Boolean                 isEnabled;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date                    startTime;
    private String                  taskType;

    public ApiTasks() {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
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
