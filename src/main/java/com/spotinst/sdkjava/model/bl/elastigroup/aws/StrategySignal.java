package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsSignalNameEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Anurag Sharma
 * @since: 14/08/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class StrategySignal implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                    isSet;
    private AwsSignalNameEnum                               name;
    private Integer                                      timeout;
    //endregion

    //region Constructor

    public StrategySignal() {
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

    //region Builder class
    public static class Builder {
        //region Members
        private StrategySignal signal;
        //endregion

        private Builder() {
            this.signal = new StrategySignal();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setName(final AwsSignalNameEnum name) {
            signal.setName(name);
            return this;
        }

        public Builder setTimeout(final Integer timeout) {
            signal.setTimeout(timeout);
            return this;
        }

        public StrategySignal build() {
            // Validations
            return signal;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is Timeout Set boolean method
    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

    //endregion
}
