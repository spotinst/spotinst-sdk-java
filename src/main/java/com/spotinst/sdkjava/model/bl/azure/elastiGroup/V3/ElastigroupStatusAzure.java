package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.ElastigroupStatusEnumAzure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupStatusAzure {

    @JsonIgnore
    private Set<String>                                 isSet;
    private ElastigroupStatusEnumAzure                  status;
    private List<ElastigroupSuspendedProcessAzure>      suspendedProcesses;
    private List<VmsAzure>                              vms;

    private ElastigroupStatusAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupStatusEnumAzure getStatus() {
        return status;
    }

    public void setStatus(ElastigroupStatusEnumAzure status) {
        isSet.add("status");
        this.status = status;
    }

    public List<ElastigroupSuspendedProcessAzure> getSuspendedProcesses() {
        return suspendedProcesses;
    }

    public void setSuspendedProcesses(List<ElastigroupSuspendedProcessAzure> suspendedProcesses) {
        isSet.add("suspendedProcesses");
        this.suspendedProcesses = suspendedProcesses;
    }

    public List<VmsAzure> getVms() {
        return vms;
    }

    public void setVms(List<VmsAzure> vms) {
        isSet.add("vms");
        this.vms = vms;
    }

    public static class Builder {
        private ElastigroupStatusAzure elastigroupStatusAzure;

        private Builder() {
            this.elastigroupStatusAzure = new ElastigroupStatusAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setStatus(final ElastigroupStatusEnumAzure status) {
            elastigroupStatusAzure.setStatus(status);
            return this;
        }

        public Builder setSuspendedProcesses(final List<ElastigroupSuspendedProcessAzure> suspendedProcesses) {
            elastigroupStatusAzure.setSuspendedProcesses(suspendedProcesses);
            return this;
        }

        public Builder setVms(final List<VmsAzure> vms) {
            elastigroupStatusAzure.setVms(vms);
            return this;
        }

        public ElastigroupStatusAzure build() {
            return elastigroupStatusAzure;
        }

    }


    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isSuspendedProcessesSet() {
        return isSet.contains("suspendedProcesses");
    }

    @JsonIgnore
    public boolean isVmsSet() {
        return isSet.contains("vms");
    }
}
