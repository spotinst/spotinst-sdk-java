package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupEcsBatch {
    //region Members
    private Set<String>  isSet;
    private List<String> jobQueueNames;
    //endregion

    private ElastigroupEcsBatch() {isSet = new HashSet<>();}
    //region Setters&Getters
    public List<String> getJobQueueNames() {
        return jobQueueNames;
    }

    public void setJobQueueNames(List<String> jobQueueNames) {
        isSet.add("jobQueueNames");
        this.jobQueueNames = jobQueueNames;
    }
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    //endregion

    //region Builder class
public static class Builder {
        private ElastigroupEcsBatch ecsBatch;

        private Builder() {
            this.ecsBatch = new ElastigroupEcsBatch();
        }

        public static Builder get() {
            return new Builder();
        }
        public  Builder setJobQueueNames(final List<String> jobQueueNames){
            ecsBatch.setJobQueueNames(jobQueueNames);
            return this;
        }
        public  ElastigroupEcsBatch build() {
            return  ecsBatch;
        }
    }
    //region isSet methods
    @JsonIgnore
    public boolean isJobQueueNamesSet() {
        return isSet.contains("jobQueueNames");
    }
    //endregion
}
