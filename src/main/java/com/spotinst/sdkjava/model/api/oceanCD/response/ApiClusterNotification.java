package com.spotinst.sdkjava.model.api.oceanCD.response;

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
public class ApiClusterNotification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>            isSet;
    private Integer                minutesWithoutHeartbeat;
    private List<String>           providers;

    public ApiClusterNotification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMinutesWithoutHeartbeat() {
        return minutesWithoutHeartbeat;
    }

    public void setMinutesWithoutHeartbeat(Integer minutesWithoutHeartbeat) {
        isSet.add("minutesWithoutHeartbeat");
        this.minutesWithoutHeartbeat = minutesWithoutHeartbeat;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        isSet.add("providers");
        this.providers = providers;
    }

    @JsonIgnore
    public boolean isMinutesWithoutHeartbeatSet() {
        return isSet.contains("minutesWithoutHeartbeat");
    }

    @JsonIgnore
    public boolean isProvidersSet() {
        return isSet.contains("providers");
    }
}