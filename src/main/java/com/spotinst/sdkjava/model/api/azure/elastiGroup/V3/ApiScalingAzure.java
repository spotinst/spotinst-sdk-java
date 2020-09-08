package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiScalingAzure implements IPartialUpdateEntity {

    //region Members
    // Partial Update support
    private Set<String>            isSet = new HashSet<>();
    private List<ApiScalingPolicyAzure> up;
    private List<ApiScalingPolicyAzure> down;
    //endregion

    //region Getters & Setters
    public List<ApiScalingPolicyAzure> getUp() {
        return up;
    }

    public void setUp(List<ApiScalingPolicyAzure> up) {
        isSet.add("up");
        this.up = up;
    }

    public List<ApiScalingPolicyAzure> getDown() {
        return down;
    }

    public void setDown(List<ApiScalingPolicyAzure> down) {
        isSet.add("down");
        this.down = down;
    }

    @JsonIgnore
    public boolean isUpSet() {
        return isSet.contains("up");
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
