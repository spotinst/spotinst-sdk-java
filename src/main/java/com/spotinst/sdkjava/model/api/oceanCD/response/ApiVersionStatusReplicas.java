package com.spotinst.sdkjava.model.api.oceanCD.response;

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
public class ApiVersionStatusReplicas implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                    isSet;
    private Integer                        desired;
    private Integer                        ready;
    private Integer                        inProgress;
    private Integer                        failed;

    private ApiVersionStatusReplicas() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getDesired() {
        return desired;
    }

    public void setDesired(Integer desired) {
        isSet.add("desired");
        this.desired = desired;
    }

    public Integer getReady() {
        return ready;
    }

    public void setReady(Integer ready) {
        isSet.add("ready");
        this.ready = ready;
    }

    public Integer getInProgress() {
        return inProgress;
    }

    public void setInProgress(Integer inProgress) {
        isSet.add("inProgress");
        this.inProgress = inProgress;
    }

    public Integer getdFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        isSet.add("failed");
        this.failed = failed;
    }

    @JsonIgnore
    public boolean isDesiredSet() {
        return isSet.contains("desired");
    }

    @JsonIgnore
    public boolean isReadySet() {
        return isSet.contains("ready");
    }

    @JsonIgnore
    public boolean isInProgressSet() {
        return isSet.contains("inProgress");
    }

    @JsonIgnore
    public boolean isFailedSet() {
        return isSet.contains("failed");
    }
}