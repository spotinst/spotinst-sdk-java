package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupCreateInstanceSignal {

    @JsonIgnore
    private Set<String>                                          isSet;
    private String                                               instanceId;
    private String                                               signal;

    public ElastigroupCreateInstanceSignal() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        isSet.add("signal");
        this.signal = signal;
    }

    public static class Builder {
        private ElastigroupCreateInstanceSignal elastigroupCreateInstanceSignal;

        private Builder() {
            this.elastigroupCreateInstanceSignal = new ElastigroupCreateInstanceSignal();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupCreateInstanceSignal.Builder setInstanceId(final String instanceId) {
            elastigroupCreateInstanceSignal.setInstanceId(instanceId);
            return this;
        }

        public ElastigroupCreateInstanceSignal.Builder setSignal(final String signal) {
            elastigroupCreateInstanceSignal.setSignal(signal);
            return this;
        }

        public ElastigroupCreateInstanceSignal build() {
            return elastigroupCreateInstanceSignal;
        }

    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isSignalSet() {
        return isSet.contains("signal");
    }

}
