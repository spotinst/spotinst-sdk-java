package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterTasksConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     isEnabled;
    private String      cronExpression;
    private String      taskType;

    public ClusterTasksConfiguration() { isSet = new HashSet<>(); }

    public Boolean getIsEnabled(){
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled){
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public String getCronExpression(){
        return cronExpression;
    }

    public void setCronExpression(String cronExpression){
        isSet.add("cronExpression");
        this.cronExpression = cronExpression;
    }

    public String getTaskType(){
        return taskType;
    }

    public void setTaskType(String taskType){
        isSet.add("taskType");
        this.taskType = taskType;
    }

    public static class Builder {
        private ClusterTasksConfiguration task;

        private Builder(){ this.task = new ClusterTasksConfiguration(); }

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

        public ClusterTasksConfiguration build(){
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

}
