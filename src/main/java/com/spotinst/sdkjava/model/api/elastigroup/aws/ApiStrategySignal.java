package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsSignalNameEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anurag Sharma on 14/8/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiStrategySignal {
    //region Members
    @JsonIgnore
    private Set<String>            isSet;
    private AwsSignalNameEnum       name;
    private Integer              timeout;
    //endregion

    //region Constructor

    public ApiStrategySignal() {
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

    public AwsSignalNameEnum getName() {
        return name;
    }

    public void setName(AwsSignalNameEnum name) {
        isSet.add("name");
        this.name = name;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        isSet.add("timeout");
        this.timeout = timeout;
    }

    //endregion

    //endregion

    //region Builder class
    public static class Builder {
        private ApiStrategySignal signal;

        private Builder() {
            this.signal = new ApiStrategySignal();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final AwsSignalNameEnum name) {
            signal.setName(name);
            return this;
        }

        public Builder setTimeout(final Integer timeout) {
            signal.setTimeout(timeout);
            return this;
        }

        public ApiStrategySignal build() {
            // TODO : Validations
            return signal;
        }
    }
    //endregion

    //region isSet methods
    // Is minimum Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }


    // Is timeout Set boolean method
    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

    //endregion
}
