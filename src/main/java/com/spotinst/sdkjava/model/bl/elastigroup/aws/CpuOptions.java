package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Anurag Sharma
 * @since: 14/08/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class CpuOptions implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                    isSet;
    private Integer                               threadsPerCore;
    //endregion

    //region Constructor

    public CpuOptions() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getThreadsPerCore() {
        return threadsPerCore;
    }

    public void setThreadsPerCore(Integer threadsPerCore) {
        isSet.add("threadsPerCore");
        this.threadsPerCore = threadsPerCore;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private CpuOptions cpuThreads;
        //endregion

        private Builder() {
            this.cpuThreads = new CpuOptions();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setThreadsPerCore(final Integer threads) {
            cpuThreads.setThreadsPerCore(threads);
            return this;
        }

        public CpuOptions build() {
            // Validations
            return cpuThreads;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    @JsonIgnore
    public boolean isThreadsPerCoreSet() {
        return isSet.contains("threadsPerCore");
    }

    //endregion
}
