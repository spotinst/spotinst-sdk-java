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
public class ApiSpotDeploymentManifest implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         kind;
    private String                         apiVersion;

    private ApiSpotDeploymentManifest() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        isSet.add("kind");
        this.kind = kind;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        isSet.add("apiVersion");
        this.apiVersion = apiVersion;
    }

    @JsonIgnore
    public boolean isKindSet() {
        return isSet.contains("kind");
    }

    @JsonIgnore
    public boolean isApiVersionSet() {
        return isSet.contains("apiVersion");
    }
}