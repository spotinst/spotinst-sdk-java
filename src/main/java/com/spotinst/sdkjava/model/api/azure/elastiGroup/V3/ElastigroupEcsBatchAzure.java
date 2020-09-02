package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupEcsBatchAzure {
    //region Members
    private Set<String>  isSet;
    private List<String> jobQueueNames;
    //endregion

    private ElastigroupEcsBatchAzure() { isSet = new HashSet<>();}
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
        private ElastigroupEcsBatchAzure ecsBatch;

        private Builder() {
            this.ecsBatch = new ElastigroupEcsBatchAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public  Builder setJobQueueNames(final List<String> jobQueueNames){
            ecsBatch.setJobQueueNames(jobQueueNames);
            return this;
        }
        public ElastigroupEcsBatchAzure build() {
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
