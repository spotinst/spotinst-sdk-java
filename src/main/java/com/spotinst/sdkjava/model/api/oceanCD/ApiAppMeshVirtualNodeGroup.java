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
public class ApiAppMeshVirtualNodeGroup implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                     isSet;
    private ApiVirtualNodeGroupCanaryStableVirtualNodeRef canaryVirtualNodeRef;
    private ApiVirtualNodeGroupCanaryStableVirtualNodeRef stableVirtualNodeRef;

    public ApiAppMeshVirtualNodeGroup() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiVirtualNodeGroupCanaryStableVirtualNodeRef getCanaryVirtualNodeRef() {
        return canaryVirtualNodeRef;
    }

    public void setCanaryVirtualNodeRef(ApiVirtualNodeGroupCanaryStableVirtualNodeRef canaryVirtualNodeRef) {
        isSet.add("canaryVirtualNodeRef");
        this.canaryVirtualNodeRef = canaryVirtualNodeRef;
    }

    public ApiVirtualNodeGroupCanaryStableVirtualNodeRef getStableVirtualNodeRef() {
        return stableVirtualNodeRef;
    }

    public void setStableVirtualNodeRef(ApiVirtualNodeGroupCanaryStableVirtualNodeRef stableVirtualNodeRef) {
        isSet.add("stableVirtualNodeRef");
        this.stableVirtualNodeRef = stableVirtualNodeRef;
    }

    @JsonIgnore
    public boolean isCanaryVirtualNodeRefSet() {
        return isSet.contains("canaryVirtualNodeRef");
    }

    @JsonIgnore
    public boolean isStableVirtualNodeRefSet() {
        return isSet.contains("stableVirtualNodeRef");
    }
}