package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsSchedulingConfiguration {
    @JsonIgnore
    private Set<String>             isSet;
    private List<MrScalerAwsTask> tasks;

    private MrScalerAwsSchedulingConfiguration() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<MrScalerAwsTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<MrScalerAwsTask> tasks) {
        isSet.add("tasks");
        this.tasks = tasks;
    }

    public static class Builder {
        private MrScalerAwsSchedulingConfiguration scheduling;

        private Builder(){ this.scheduling = new MrScalerAwsSchedulingConfiguration(); }

        public static Builder get(){ return new Builder(); }

        public Builder setTasks(final List<MrScalerAwsTask> tasks){
            scheduling.setTasks(tasks);
            return this;
        }

        public MrScalerAwsSchedulingConfiguration build(){
            return scheduling;
        }

    }

    @JsonIgnore
    public Boolean isTasksSet(){
        return isSet.contains("tasks");
    }
}
