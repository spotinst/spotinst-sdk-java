package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiBatchAzure implements IPartialUpdateEntity {
    //region Members
    private Set<String>  isSet;
    private List<String> jobQueueNames;
    //endregion

    public ApiBatchAzure() {
        isSet = new HashSet<>();
    }

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

    //region Methods
    @JsonIgnore
    public boolean isJobQueueNamesSet() {
        return isSet.contains("jobQueueNames");
    }
    //endregion

}
