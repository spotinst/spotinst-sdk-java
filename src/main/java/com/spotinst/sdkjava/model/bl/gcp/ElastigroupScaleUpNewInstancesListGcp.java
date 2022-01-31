package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScaleUpNewInstancesListGcp {

    @JsonIgnore
    private Set<String> isSet;
    private String      instanceName;


    public ElastigroupScaleUpNewInstancesListGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        isSet.add("instanceName");
        this.instanceName = instanceName;
    }
    public static class Builder {
        private ElastigroupScaleUpNewInstancesListGcp elastigroupScaleUpNewInstancesListGcp;

        private Builder() {
            this.elastigroupScaleUpNewInstancesListGcp = new ElastigroupScaleUpNewInstancesListGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setInstanceName(final String instanceName) {
            elastigroupScaleUpNewInstancesListGcp.setInstanceName(instanceName);
            return this;
        }


        public ElastigroupScaleUpNewInstancesListGcp build() {
            return elastigroupScaleUpNewInstancesListGcp;
        }

    }

    @JsonIgnore
    public boolean isInstanceNameSet() {
        return isSet.contains("instanceName");
    }



}
