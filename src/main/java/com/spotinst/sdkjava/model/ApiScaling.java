package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiScaling implements IPartialUpdateEntity {

    //region Members
    // Partial Update support
    private Set<String>            isSet = new HashSet<>();
    private List<ApiScalingPolicy> up;
    private List<ApiScalingPolicy> down;
    //endregion

    //region Getters & Setters
    public List<ApiScalingPolicy> getUp() {
        return up;
    }

    public void setUp(List<ApiScalingPolicy> up) {
        isSet.add("up");
        this.up = up;
    }

    @JsonIgnore
    public boolean isUpSet() {
        return isSet.contains("up");
    }

    public List<ApiScalingPolicy> getDown() {
        return down;
    }

    public void setDown(List<ApiScalingPolicy> down) {
        isSet.add("down");
        this.down = down;
    }

    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

    @Override
    @JsonIgnore
    public Set<String> getIsSet() {
        return isSet;
    }
    //endregion
}