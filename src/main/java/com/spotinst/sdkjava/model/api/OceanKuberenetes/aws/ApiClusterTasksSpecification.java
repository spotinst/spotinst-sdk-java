package com.spotinst.sdkjava.model.api.OceanKuberenetes.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiClusterTasksSpecification implements IPartialUpdateEntity {


    @JsonIgnore
    private Set<String> isSet;
    private Boolean     isEnabled;
    private String      cronExpression;
    private String      taskType;

    public ApiClusterTasksSpecification() { isSet = new HashSet<>(); }

    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

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
