package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecBlockDeviceMappings {
    //region Members
    @JsonIgnore
    private Set<String>                isSet;
    private String                     deviceName;
    private LaunchSpecEbsSpecification ebs;

    private LaunchSpecBlockDeviceMappings() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        isSet.add("deviceName");
        this.deviceName = deviceName;
    }

    public LaunchSpecEbsSpecification getEbs() {
        return ebs;
    }

    public void setEbs(LaunchSpecEbsSpecification ebs) {
        isSet.add("ebs");
        this.ebs = ebs;
    }

    public static class Builder {

        private LaunchSpecBlockDeviceMappings launchSpecBlockDeviceMappings;

        private Builder() {
            this.launchSpecBlockDeviceMappings = new LaunchSpecBlockDeviceMappings();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDeviceName(final String deviceName) {
            launchSpecBlockDeviceMappings.setDeviceName(deviceName);
            return this;
        }

        public Builder setEbs(final LaunchSpecEbsSpecification ebs) {
            launchSpecBlockDeviceMappings.setEbs(ebs);
            return this;
        }

        public LaunchSpecBlockDeviceMappings build() {
            return launchSpecBlockDeviceMappings;
        }
    }

    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    public boolean isEbsSet() {
        return isSet.contains("ebs");
    }
}
