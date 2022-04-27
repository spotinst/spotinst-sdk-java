package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsTask {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean isEnabled;
    private String cronExpression;
    private String taskType;
    private String instanceGroupType;
    private Integer targetCapacity;
    private Integer minCapacity;
    private Integer maxCapacity;
    // endregion


    //region Constructor
    public ApiMrScalerAwsTask() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region isEnabled
    public Boolean getIsEnabled(){
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled){
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public Boolean isIsEnabledSet(){
        return isSet.contains("isEnabled");
    }
    // endregion

    // region cronExpression
    public String getCronExpression(){
        return cronExpression;
    }

    public void setCronExpression(String cronExpression){
        isSet.add("cronExpression");
        this.cronExpression = cronExpression;
    }

    public Boolean isCronExpressionSet(){
        return isSet.contains("cronExpression");
    }
    // endregion

    // region taskType
    public String getTaskType(){
        return taskType;
    }

    public void setTaskType(String taskType){
        isSet.add("taskType");
        this.taskType = taskType;
    }

    public Boolean isTaskTypeSet(){
        return isSet.contains("taskType");
    }
    // endregion

    // region instanceGroupType
    public String getInstanceGroupType(){
        return instanceGroupType;
    }

    public void setInstanceGroupType(String instanceGroupType){
        isSet.add("instanceGroupType");
        this.instanceGroupType = instanceGroupType;
    }

    public Boolean isInstanceGroupTypeSet(){
        return isSet.contains("instanceGroupType");
    }
    // endregion

    // region targetCapacity
    public Integer getTargetCapacity(){
        return targetCapacity;
    }

    public void setTargetCapacity(Integer targetCapacity){
        isSet.add("targetCapacity");
        this.targetCapacity = targetCapacity;
    }

    public Boolean isTargetCapacitySet(){
        return isSet.contains("targetCapacity");
    }
    // endregion

    // region minCapacity
    public Integer getMinCapacity(){
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity){
        isSet.add("minCapacity");
        this.minCapacity = minCapacity;
    }

    public Boolean isMinCapacitySet(){
        return isSet.contains("minCapacity");
    }
    // endregion

    // region maxCapacity
    public Integer getMaxCapacity(){
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity){
        isSet.add("maxCapacity");
        this.maxCapacity = maxCapacity;
    }

    public Boolean isMaxCapacitySet(){
        return isSet.contains("maxCapacity");
    }
    // endregion

    // endregion

    public static class Builder {
        private ApiMrScalerAwsTask task;

        private Builder(){ this.task = new ApiMrScalerAwsTask(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setIsEnabled(final Boolean isEnabled){
            task.setIsEnabled(isEnabled);
            return this;
        }
        public Builder setCronExpression(final String cronExpression){
            task.setCronExpression(cronExpression);
            return this;
        }
        public Builder setTaskType(final String taskType){
            task.setTaskType(taskType);
            return this;
        }
        public Builder setInstanceGroupType(final String instanceGroupType){
            task.setInstanceGroupType(instanceGroupType);
            return this;
        }
        public Builder setTargetCapacity(final Integer targetCapacity){
            task.setTargetCapacity(targetCapacity);
            return this;
        }
        public Builder setMinCapacity(final Integer minCapacity){
            task.setMinCapacity(minCapacity);
            return this;
        }
        public Builder setMaxCapacity(final Integer maxCapacity){
            task.setMaxCapacity(maxCapacity);
            return this;
        }

        public ApiMrScalerAwsTask build(){
            return task;
        }
        // endregion
    }
}
