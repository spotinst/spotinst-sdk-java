package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiTrafficPingPong implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     pingService;
    private String                     pongService;

    public ApiTrafficPingPong() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPingService() {
        return pingService;
    }

    public void setPingService(String pingService) {
        isSet.add("pingService");
        this.pingService = pingService;
    }

    public String getPongService() {
        return pongService;
    }

    public void setPongService(String pongService) {
        isSet.add("pongService");
        this.pongService = pongService;
    }

    @JsonIgnore
    public boolean isPingServiceSet() {
        return isSet.contains("pingService");
    }

    @JsonIgnore
    public boolean isPongServiceSet() {
        return isSet.contains("pongService");
    }
}