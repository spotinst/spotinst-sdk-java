package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anurag Sharma on 14/8/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCpuOptions implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>        isSet;
    private Integer   threadsPerCore;
    //endregion

    //region Constructor

    public ApiCpuOptions() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getThreadsPerCore() {
        return threadsPerCore;
    }

    public void setThreadsPerCore(Integer threads) {
        isSet.add("threadsPerCore");
        this.threadsPerCore = threads;
    }

    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isThreadsPerCoreSet() {
        return isSet.contains("threadsPerCore");
    }

    //endregion
}
