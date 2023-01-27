package com.spotinst.sdkjava.model.api.elastigroup.aws;

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
public class ApiBeanstalkPlatformUpdate implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>        isSet;
    private Boolean            instanceRefreshEnabled;
    private String             performAt;
    private String             timeWindow;
    private String             updateLevel;
    //endregion

    //region Constructor

    public ApiBeanstalkPlatformUpdate() {
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

    public Boolean getInstanceRefreshEnabled() {
        return instanceRefreshEnabled;
    }

    public void setInstanceRefreshEnabled(Boolean instanceRefreshEnabled) {
        isSet.add("instanceRefreshEnabled");
        this.instanceRefreshEnabled = instanceRefreshEnabled;
    }

    public String getPerformAt() {
        return performAt;
    }

    public void setPerformAt(String performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    public String getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(String timeWindow) {
        isSet.add("timeWindow");
        this.timeWindow = timeWindow;
    }

    public String getUpdateLevel() {
        return updateLevel;
    }

    public void setUpdateLevel(String updateLevel) {
        isSet.add("updateLevel");
        this.updateLevel = updateLevel;
    }

    //endregion

    //region isSet methods
    // Is instanceRefreshEnabled Set boolean method
    @JsonIgnore
    public boolean isInstanceRefreshEnabledSet() {
        return isSet.contains("instanceRefreshEnabled");
    }

    // Is performAt Set boolean method
    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }

    // Is timeWindow Set boolean method
    @JsonIgnore
    public boolean isTimeWindowSet() {
        return isSet.contains("timeWindow");
    }

    // Is updateLevel Set boolean method
    @JsonIgnore
    public boolean isUpdateLevelSet() {
        return isSet.contains("updateLevel");
    }
    //endregion

}
