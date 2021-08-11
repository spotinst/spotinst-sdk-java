package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class BlockDeviceMappings {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockDeviceMappings that = (BlockDeviceMappings) o;

        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        return !(ebs != null ? !ebs.equals(that.ebs) : that.ebs != null);

    }

    @Override
    public int hashCode() {
        int result = deviceName != null ? deviceName.hashCode() : 0;
        result = 31 * result + (ebs != null ? ebs.hashCode() : 0);
        return result;
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

