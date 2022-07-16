package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.ElastigroupVmSignalEnumAzure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeSignalConfiguration {

    @JsonIgnore
    private Set<String>                  isSet;
    private ElastigroupVmSignalEnumAzure type;
    private Integer                      timeout;

    private StatefulNodeSignalConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupVmSignalEnumAzure getType() {
        return type;
    }

    public void setType(ElastigroupVmSignalEnumAzure type) {
        isSet.add("type");
        this.type = type;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        isSet.add("timeout");
        this.timeout = timeout;
    }

    public static class Builder {
        private StatefulNodeSignalConfiguration statefulNodeSignal;

        private Builder() {
            this.statefulNodeSignal = new StatefulNodeSignalConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setType(final ElastigroupVmSignalEnumAzure type) {
            statefulNodeSignal.setType(type);
            return this;
        }

        public Builder setTimeout(final Integer timeout) {
            statefulNodeSignal.setTimeout(timeout);
            return this;
        }

        public StatefulNodeSignalConfiguration build() {
            return statefulNodeSignal;
        }
    }
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

}
