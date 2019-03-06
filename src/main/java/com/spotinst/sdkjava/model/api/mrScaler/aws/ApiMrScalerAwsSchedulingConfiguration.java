package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiMrScalerAwsSchedulingConfiguration {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<ApiMrScalerAwsTask> tasks;
    //region Constructor
    public ApiMrScalerAwsSchedulingConfiguration() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region tasks
    public List<ApiMrScalerAwsTask> getTasks(){
        return tasks;
    }

    public void setTasks(List<ApiMrScalerAwsTask> tasks){
        isSet.add("tasks");
        this.tasks = tasks;
    }

    public Boolean isTasksSet(){
        return isSet.contains("tasks");
    }
    // endregion

    // endregion

    public static class Builder {
        private ApiMrScalerAwsSchedulingConfiguration scheduling;

        private Builder(){ this.scheduling = new ApiMrScalerAwsSchedulingConfiguration(); }

        public static Builder get(){ return new Builder(); }

        // region build methods
        public Builder setTasks(final List<ApiMrScalerAwsTask> tasks){
            scheduling.setTasks(tasks);
            return this;
        }

        public ApiMrScalerAwsSchedulingConfiguration build(){
            return scheduling;
        }
        // endregion
    }
}
