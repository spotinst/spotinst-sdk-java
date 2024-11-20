package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerAwsSchedulingConfiguration implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private List<ApiMrScalerAwsTask> tasks;

    public ApiMrScalerAwsSchedulingConfiguration() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiMrScalerAwsTask> getTasks(){
        return tasks;
    }

    public void setTasks(List<ApiMrScalerAwsTask> tasks){
        isSet.add("tasks");
        this.tasks = tasks;
    }

    @JsonIgnore
    public Boolean isTasksSet(){
        return isSet.contains("tasks");
    }
}
