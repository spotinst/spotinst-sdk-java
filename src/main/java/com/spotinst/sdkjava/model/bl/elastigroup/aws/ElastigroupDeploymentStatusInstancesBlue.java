package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupDeploymentStatusInstancesBlue {

    @JsonIgnore
    private Set<String> isSet;
    private String      instanceId;
    private String      lifeCycle;
    private Integer     batchNum;
    private String      status;

    public ElastigroupDeploymentStatusInstancesBlue() {
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

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        isSet.add("batchNum");
        this.batchNum = batchNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }


    public static class Builder {
        private ElastigroupDeploymentStatusInstancesBlue elastigroupGetDeploymentStatusInstancesBlue;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstancesBlue = new ElastigroupDeploymentStatusInstancesBlue();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setInstanceId(final String instanceId) {
            elastigroupGetDeploymentStatusInstancesBlue.setInstanceId(instanceId);
            return this;
        }

        public Builder setLifeCycle(final String lifeCycle) {
            elastigroupGetDeploymentStatusInstancesBlue.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder setBatchNum(final Integer batchNum) {
            elastigroupGetDeploymentStatusInstancesBlue.setBatchNum(batchNum);
            return this;
        }

        public Builder setStatus(final String status) {
            elastigroupGetDeploymentStatusInstancesBlue.setStatus(status);
            return this;
        }


        public ElastigroupDeploymentStatusInstancesBlue build() {
            return elastigroupGetDeploymentStatusInstancesBlue;
        }

    }

    @JsonIgnore
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    @JsonIgnore
    public boolean isBatchNumSet() {
        return isSet.contains("batchNum");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

}
