package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerAwsTask {
    //region Members
    private Boolean isEnabled;
    private String  cronExpression;
    private String  taskType;
    private String  instanceGroupType;
    private Integer targetCapacity;
    private Integer minCapacity;
    private Integer maxCapacity;
    // endregion


    //region Constructor
    public BlMrScalerAwsTask() {
    }
    // endregion

    //region getters and setters
    // region isEnabled
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    // endregion

    // region cronExpression
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
    // endregion

    // region taskType
    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
    // endregion

    // region instanceGroupType
    public String getInstanceGroupType() {
        return instanceGroupType;
    }

    public void setInstanceGroupType(String instanceGroupType) {
        this.instanceGroupType = instanceGroupType;
    }
    // endregion

    // region targetCapacity
    public Integer getTargetCapacity() {
        return targetCapacity;
    }

    public void setTargetCapacity(Integer targetCapacity) {
        this.targetCapacity = targetCapacity;
    }
    // endregion

    // region minCapacity
    public Integer getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity) {
        this.minCapacity = minCapacity;
    }
    // endregion

    // region maxCapacity
    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    // endregion

    // endregion
}
