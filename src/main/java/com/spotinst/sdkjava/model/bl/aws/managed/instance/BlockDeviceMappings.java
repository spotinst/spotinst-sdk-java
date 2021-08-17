package com.spotinst.sdkjava.model.bl.aws.managed.instance;

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

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      deviceName;
    private Ebs         ebs;
    //endregion

    //region Constructor

    private BlockDeviceMappings() {
        isSet = new HashSet<>();
    }
    //endregion

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

   //region Builder class
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
            // TODO : Validations
            return blockDeviceMappings;
        }
    }
    //endregion

    //region isSet methods
    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    // Is ebs Set boolean method
    @JsonIgnore
    public boolean isEbsSet() {
        return isSet.contains("ebs");
    }

    //endregion
}

