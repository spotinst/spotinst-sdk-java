package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsTask {
    @JsonIgnore
    private Set<String>     isSet;
    private Boolean         isEnabled;
    private String          cronExpression;
    private String          taskType;
    private String          instanceGroupType;
    private Integer         targetCapacity;
    private Integer         minCapacity;
    private Integer         maxCapacity;

    private MrScalerAwsTask() { isSet = new HashSet<>(); }

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

    public String getInstanceGroupType() {
        return instanceGroupType;
    }

    public void setInstanceGroupType(String instanceGroupType) {
        isSet.add("instanceGroupType");
        this.instanceGroupType = instanceGroupType;
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
        private MrScalerAwsTask task;

        private Builder(){ this.task = new MrScalerAwsTask(); }

        public static Builder get(){
            return new Builder();
        }

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

        public MrScalerAwsTask build(){
            return task;
        }

    }

    @JsonIgnore
    public Boolean isIsEnabledSet(){
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public Boolean isCronExpressionSet(){
        return isSet.contains("cronExpression");
    }

    @JsonIgnore
    public Boolean isTaskTypeSet(){
        return isSet.contains("taskType");
    }

    @JsonIgnore
    public Boolean isInstanceGroupTypeSet(){
        return isSet.contains("instanceGroupType");
    }

    @JsonIgnore
    public Boolean isTargetCapacitySet(){
        return isSet.contains("targetCapacity");
    }

    @JsonIgnore
    public Boolean isMinCapacitySet(){
        return isSet.contains("minCapacity");
    }

    @JsonIgnore
    public Boolean isMaxCapacitySet(){
        return isSet.contains("maxCapacity");
    }
}
