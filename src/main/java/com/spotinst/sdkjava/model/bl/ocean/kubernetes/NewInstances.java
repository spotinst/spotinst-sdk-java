package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class NewInstances {

    @JsonIgnore
    private Set<String>                 isSet;
    private String            instanceId;
    private String      availabilityZone;
    private String          instanceType;
    private String             lifeCycle;

    private NewInstances() {
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

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public static class Builder {
        private NewInstances newInstances;

        public Builder() {
            this.newInstances = new NewInstances();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setInstanceId(String instanceId) {
            newInstances.setInstanceId(instanceId);
            return this;
        }

        public Builder setAvailabilityZone(String availabilityZone) {
            newInstances.setAvailabilityZone(availabilityZone);
            return this;
        }

        public Builder setInstanceType(String instanceType) {
            newInstances.setInstanceType(instanceType);
            return this;
        }

        public Builder setLifeCycle(String lifeCycle) {
            newInstances.setLifeCycle(lifeCycle);
            return this;
        }

        public NewInstances build() {
            return newInstances;
        }
    }

    @JsonIgnore
    public boolean isInstanceIdSet() {return isSet.contains("instanceId");}

    @JsonIgnore
    public boolean isAvailabilityZoneSet() {return isSet.contains("availabilityZone");}

    @JsonIgnore
    public boolean isInstanceTypeSet() {return isSet.contains("instanceType");}

    @JsonIgnore
    public boolean isLifeCycleSet() {return isSet.contains("lifeCycle");}
}