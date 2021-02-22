package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiAdditionalIpConfigurationsAzure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDisksGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                              isSet;
    private Boolean                                  autoDelete;
    private String                                   deviceName;
    private String                                   type;
    private String                                   source;
    private String                                   mode;
    private Boolean                                  boot;
    private ApiInitializeParamsGcp                   initializeParams;
    //endregion

    //region Constructor
    public ApiDisksGcp() {
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        isSet.add("deviceName");
        this.deviceName = deviceName;
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        isSet.add("mode");
        this.mode = mode;
    }

    public Boolean getBoot() {
        return boot;
    }

    public void setBoot(Boolean boot) {
        isSet.add("boot");
        this.boot = boot;
    }

    public ApiInitializeParamsGcp getInitializeParams() {
        return initializeParams;
    }

    public void setInitializeParams(ApiInitializeParamsGcp initializeParams) {
        isSet.add("initializeParams");
        this.initializeParams = initializeParams;
    }

    //endregion

    //region isSet methods
    // Is autoDelete Set boolean method
    @JsonIgnore
    public boolean isAutoDeleteSet() {
        return isSet.contains("autoDelete");
    }

    // Is boot Set boolean method
    @JsonIgnore
    public boolean isBootSet() {
        return isSet.contains("boot");
    }

    // Is deviceName Set boolean method
    @JsonIgnore
    public boolean isDeviceNameSet() {
        return isSet.contains("deviceName");
    }

    // Is mode Set boolean method
    @JsonIgnore
    public boolean isModeSet() {
        return isSet.contains("mode");
    }

    // Is source Set boolean method
    @JsonIgnore
    public boolean isSourceSet() {
        return isSet.contains("source");
    }

    // Is type Set boolean method
    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    // Is initializeParams Set boolean method
    @JsonIgnore
    public boolean isInitializeParamsSet() {
        return isSet.contains("initializeParams");
    }
    //endregion
}
