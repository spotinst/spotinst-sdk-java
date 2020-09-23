package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.*;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupScheduledTaskAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     isEnabled;
    private String      frequency;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date        startTime;
    private String      cronExpression;
    private String      taskType;
    private Integer     scaleTargetCapacity;
    private Integer     scaleMinCapacity;
    private Integer     scaleMaxCapacity;
    private Integer     batchSizePercentage;
    private Integer     gracePeriod;
    private Integer     adjustment;
    private Integer     adjustmentPercentage;
    private Integer     targetCapacity;
    private Integer     minCapacity;
    private Integer     maxCapacity;
    //endregion

    //region Constructor
    public ApiElastigroupScheduledTaskAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        isSet.add("frequency");
        this.frequency = frequency;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        isSet.add("startTime");
        this.startTime = startTime;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        isSet.add("cronExpression");
        this.cronExpression = cronExpression;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        isSet.add("taskType");
        this.taskType = taskType;
    }

    public Integer getScaleTargetCapacity() {
        return scaleTargetCapacity;
    }

    public void setScaleTargetCapacity(Integer scaleTargetCapacity) {
        isSet.add("scaleTargetCapacity");
        this.scaleTargetCapacity = scaleTargetCapacity;
    }

    public Integer getScaleMinCapacity() {
        return scaleMinCapacity;
    }

    public void setScaleMinCapacity(Integer scaleMinCapacity) {
        isSet.add("scaleMinCapacity");
        this.scaleMinCapacity = scaleMinCapacity;
    }

    public Integer getScaleMaxCapacity() {
        return scaleMaxCapacity;
    }

    public void setScaleMaxCapacity(Integer scaleMaxCapacity) {
        isSet.add("scaleMaxCapacity");
        this.scaleMaxCapacity = scaleMaxCapacity;
    }

    public Integer getBatchSizePercentage() {
        return batchSizePercentage;
    }

    public void setBatchSizePercentage(Integer batchSizePercentage) {
        isSet.add("batchSizePercentage");
        this.batchSizePercentage = batchSizePercentage;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        isSet.add("gracePeriod");
        this.gracePeriod = gracePeriod;
    }

    public Integer getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {
        isSet.add("adjustment");
        this.adjustment = adjustment;
    }

    public Integer getAdjustmentPercentage() {
        return adjustmentPercentage;
    }

    public void setAdjustmentPercentage(Integer adjustmentPercentage) {
        isSet.add("adjustmentPercentage");
        this.adjustmentPercentage = adjustmentPercentage;
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

    //endregion
    //region isSet methods
    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isFrequencySet() {
        return isSet.contains("frequency");
    }

    @JsonIgnore
    public boolean isStartTimeSet() {
        return isSet.contains("startTime");
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
    public boolean isScaleTargetCapacitySet() {
        return isSet.contains("scaleTargetCapacity");
    }

    @JsonIgnore
    public boolean isScaleMinCapacitySet() {
        return isSet.contains("scaleMinCapacity");
    }

    @JsonIgnore
    public boolean isScaleMaxCapacitySet() {
        return isSet.contains("scaleMaxCapacity");
    }

    @JsonIgnore
    public boolean isBatchSizePercentageSet() {
        return isSet.contains("batchSizePercentage");
    }

    @JsonIgnore
    public boolean isGracePeriodSet() {
        return isSet.contains("gracePeriod");
    }

    @JsonIgnore
    public boolean isAdjustmentSet() {
        return isSet.contains("adjustment");
    }

    @JsonIgnore
    public boolean isAdjustmentPercentageSet() {
        return isSet.contains("adjustmentPercentage");
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
    //endregion
}
