package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class BlockDeviceMappings implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String      deviceName;
    private Ebs         ebs;

    private BlockDeviceMappings() {
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

    public Ebs getEbs() {
        return ebs;
    }

    public void setEbs(Ebs ebs) {
        isSet.add("ebs");
        this.ebs = ebs;
    }

    public static class Builder {
        private BlockDeviceMappings blockDeviceMappings;

        private Builder() {
            this.blockDeviceMappings = new BlockDeviceMappings();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDeviceName(final String deviceName) {
            blockDeviceMappings.setDeviceName(deviceName);
            return this;
        }

        public Builder setEbs(final Ebs ebs) {
            blockDeviceMappings.setEbs(ebs);
            return this;
        }

        public BlockDeviceMappings build() {
            return blockDeviceMappings;
        }
    }

    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    @JsonIgnore
    public boolean isEbsSet() {
        return isSet.contains("ebs");
    }

}

