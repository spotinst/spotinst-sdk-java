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

    public ApiClusterConfigurationAks getAks() {
        return aks;
    }

    public ApiClusterAks setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        return this;
    }

    public void setAks(ApiClusterConfigurationAks aks) {
        this.aks = aks;
    }

    public String getControllerClusterId() {
        return controllerClusterId;
    }

    public void setControllerClusterId(String controllerClusterId) {
        this.controllerClusterId = controllerClusterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApiVirtualNodeGroupTemplateAks getVirtualNodeGroupTemplate() {
        return virtualNodeGroupTemplate;
    }

    public void setVirtualNodeGroupTemplate(ApiVirtualNodeGroupTemplateAks virtualNodeGroupTemplate) {
        this.virtualNodeGroupTemplate = virtualNodeGroupTemplate;
    }

    public boolean isXSet() {
        return isSet.contains("marketplace");
    }


}