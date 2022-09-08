package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScaleDownVictimGcp {

    @JsonIgnore
    private Set<String> isSet;
    private String      instanceName;
    private String      zone;
    private String      machineType;

    public ElastigroupScaleDownVictimGcp() {
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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        isSet.add("zone");
        this.zone = zone;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        isSet.add("machineType");
        this.machineType = machineType;
    }

    public static class Builder {
        private ElastigroupScaleDownVictimGcp elastigroupScaleDownvictimGcp;

        private Builder() {
            this.elastigroupScaleDownvictimGcp = new ElastigroupScaleDownVictimGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setInstanceName(final String instanceName) {
            elastigroupScaleDownvictimGcp.setInstanceName(instanceName);
            return this;
        }

        public Builder setZone(final String zone) {
            elastigroupScaleDownvictimGcp.setZone(zone);
            return this;
        }

        public Builder setMachineType(final String machineType) {
            elastigroupScaleDownvictimGcp.setMachineType(machineType);
            return this;
        }

        public ElastigroupScaleDownVictimGcp build() {
            return elastigroupScaleDownvictimGcp;
        }

    }

    @JsonIgnore
    public boolean isInstanceNameSet() {
        return isSet.contains("instanceName");
    }
    @JsonIgnore
    public boolean isZoneSet() {
        return isSet.contains("zone");
    }
    @JsonIgnore
    public boolean isMachineTypeSet() {
        return isSet.contains("machineType");
    }



}
