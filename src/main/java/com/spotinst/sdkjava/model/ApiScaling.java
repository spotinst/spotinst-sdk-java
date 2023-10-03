package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiMultipleMetrics;

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
    @JsonIgnore
    private Set<String>            isSet = new HashSet<>();
    private List<ApiScalingPolicy> up;
    private List<ApiScalingPolicy> down;
    private List<ApiScalingPolicy> target;
    private ApiMultipleMetrics multipleMetrics;
    //endregion

    //region Getters & Setters
    //region Up
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
    //endregion

    //region Down
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
    //endregion

    //region Target
    public List<ApiScalingPolicy> getTarget() {
        return target;
    }

    public void setTarget(List<ApiScalingPolicy> target) {
        isSet.add("target");
        this.target = target;
    }
    public ApiMultipleMetrics getMultipleMetrics() {
        return multipleMetrics;
    }

    public void setMultipleMetrics(ApiMultipleMetrics multipleMetrics) {
        isSet.add("multipleMetrics");
        this.multipleMetrics = multipleMetrics;
    }

    @JsonIgnore
    public boolean isTargetSet() {
        return isSet.contains("target");
    }
    //endregion

    @JsonIgnore
    public boolean isMultipleMetricsSet() {
        return isSet.contains("multipleMetrics");
    }
    //endregion

    @Override
    @JsonIgnore
    public Set<String> getIsSet() {
        return isSet;
    }
    //endregion
}
