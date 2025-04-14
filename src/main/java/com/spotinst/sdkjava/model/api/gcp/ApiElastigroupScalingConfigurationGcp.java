package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupScalingConfigurationGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                             isSet;
    private List<ApiElastigroupScalingPolicyGcp>    up;
    private List<ApiElastigroupScalingPolicyGcp>    down;

    public ApiElastigroupScalingConfigurationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupScalingPolicyGcp> getUp() {
        return up;
    }

    public void setUp(List<ApiElastigroupScalingPolicyGcp> up) {
        isSet.add("up");
        this.up = up;
    }

    public List<ApiElastigroupScalingPolicyGcp> getDown() {
        return down;
    }

    public void setDown(List<ApiElastigroupScalingPolicyGcp> down) {
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
}
