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
public class ApiTrafficAppMesh implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                              isSet;
    private ApiAppMeshVirtualService                 virtualService;
    private ApiAppMeshVirtualNodeGroup               virtualNodeGroup;

    public ApiTrafficAppMesh() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiAppMeshVirtualService getVirtualService() {
        return virtualService;
    }

    public void setVirtualService(ApiAppMeshVirtualService virtualService) {
        isSet.add("virtualService");
        this.virtualService = virtualService;
    }

    public ApiAppMeshVirtualNodeGroup getVirtualNodeGroup() {
        return virtualNodeGroup;
    }

    public void setVirtualNodeGroup(ApiAppMeshVirtualNodeGroup virtualNodeGroup) {
        isSet.add("virtualNodeGroup");
        this.virtualNodeGroup = virtualNodeGroup;
    }

    @JsonIgnore
    public boolean isVirtualServiceSet() {
        return isSet.contains("virtualService");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupSet() {
        return isSet.contains("virtualNodeGroup");
    }
}