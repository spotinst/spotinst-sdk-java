package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDisksGcp {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private Boolean                        autoDelete;
    private Boolean                        boot;
    private String                         deviceName;
    private String                         type;
    private String                         source;
    private String                         mode;
    private ElastigroupInitializeParamsGcp initializeParams;
    //endregion

    //region Constructor
    private ElastigroupDisksGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(Boolean autoDelete) {
        isSet.add("autoDelete");
        this.autoDelete = autoDelete;
    }

    public Boolean getBoot() {
        return boot;
    }

    public void setBoot(Boolean boot) {
        isSet.add("boot");
        this.boot = boot;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        isSet.add("mode");
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        isSet.add("source");
        this.source = source;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        isSet.add("deviceName");
        this.deviceName = deviceName;
    }

    public ElastigroupInitializeParamsGcp getInitializeParams() {
        return initializeParams;
    }

    public void setInitializeParams(ElastigroupInitializeParamsGcp initializeParams) {
        isSet.add("initializeParams");
        this.initializeParams = initializeParams;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupDisksGcp disks;

        private Builder() {
            this.disks = new ElastigroupDisksGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setAutoDelete(final Boolean autoDelete) {
            disks.setAutoDelete(autoDelete);
            return this;
        }

        public Builder setBoot(final Boolean boot) {
            disks.setBoot(boot);
            return this;
        }

        public Builder setMode(final String mode) {
            disks.setMode(mode);
            return this;
        }

        public Builder setType(final String type) {
            disks.setType(type);
            return this;
        }

        public Builder setSource(final String source) {
            disks.setSource(source);
            return this;
        }

        public Builder setDeviceName(final String deviceName) {
            disks.setDeviceName(deviceName);
            return this;
        }

        public Builder setInitializeParams(final ElastigroupInitializeParamsGcp initializeParams) {
            disks.setInitializeParams(initializeParams);
            return this;
        }

        public ElastigroupDisksGcp build() {
            return disks;
        }
    }
    //endregion

    //region isSet methods
    // Is autoDelete Set boolean method
    @JsonIgnore
    public boolean isAutoDeleteSet() { return isSet.contains("autoDelete"); }

    // Is boot Set boolean method
    @JsonIgnore
    public boolean isBootSet() { return isSet.contains("boot"); }

    // Is mode Set boolean method
    @JsonIgnore
    public boolean isModeSet() { return isSet.contains("mode"); }

    // Is source Set boolean method
    @JsonIgnore
    public boolean isSourceSet() { return isSet.contains("source"); }

    // Is type Set boolean method
    @JsonIgnore
    public boolean isTypeSet() { return isSet.contains("type"); }

    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isDeviceNameSet() { return isSet.contains("deviceName"); }

    // Is initializeParams Set boolean method
    @JsonIgnore
    public boolean isInitializeParamsSet() { return isSet.contains("initializeParams"); }
    //endregion
}
