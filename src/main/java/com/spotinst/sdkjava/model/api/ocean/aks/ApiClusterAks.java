package com.spotinst.sdkjava.model.api.ocean.aks;

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

public class ApiClusterAks implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                     isSet;
    private String                          id;
    private ApiClusterConfigurationAks      aks;
    private String                          controllerClusterId;
    private String                          name;
    private ApiVirtualNodeGroupTemplateAks  virtualNodeGroupTemplate;


    public ApiClusterAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public ApiClusterAks setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        return this;
    }

    public ApiClusterConfigurationAks getAks() {
        return aks;
    }

    public void setAks(ApiClusterConfigurationAks aks) {
        isSet.add("aks");
        this.aks = aks;
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        isSet.add("controllerClusterId");
        this.controllerClusterId = controllerClusterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public ApiVirtualNodeGroupTemplateAks getVirtualNodeGroupTemplate() {

        return virtualNodeGroupTemplate;
    }

    public void setVirtualNodeGroupTemplate(ApiVirtualNodeGroupTemplateAks virtualNodeGroupTemplate) {

        isSet.add("virtualNodeGroupTemplate");
        this.virtualNodeGroupTemplate = virtualNodeGroupTemplate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    @JsonIgnore
    public boolean isAksSet() {
        return isSet.contains("aks");
    }

    @JsonIgnore
    public boolean isControllerClusterIdSet() {
        return isSet.contains("controllerClusterId");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupTemplateSet() {
        return isSet.contains("virtualNodeGroupTemplate");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

}