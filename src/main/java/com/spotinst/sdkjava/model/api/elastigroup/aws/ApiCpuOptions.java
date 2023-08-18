package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anurag Sharma on 14/8/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiCpuOptions {
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
        isSet.add("terminationPolicy");
        this.threadsPerCore = threads;
    }

    //endregion

    //endregion

    //region Builder class
    public static class Builder {
        private ApiCpuOptions threadsPerCore;

        private Builder() {
            this.threadsPerCore = new ApiCpuOptions();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setThreadsPerCore(final Integer threads) {
            threadsPerCore.setThreadsPerCore(threads);
            return this;
        }

        public ApiCpuOptions build() {
            // TODO : Validations
            return threadsPerCore;
        }
    }
    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isThreadsPerCoreSet() {
        return isSet.contains("threadsPerCore");
    }

    //endregion
}
