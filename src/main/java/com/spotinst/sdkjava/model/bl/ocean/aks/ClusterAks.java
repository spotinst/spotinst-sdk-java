package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ClusterAks {

    @JsonIgnore
    private Set<String>                     isSet;
    private ClusterConfigurationAks         aks;
    private String                          controllerClusterId;
    private String                          name;
    private ClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplate;


    public ClusterAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public ClusterAks setIsSet(Set<String> isSet) {
        this.isSet = isSet;
        return this;
    }

    public ClusterConfigurationAks getAks() {
        return aks;
    }

    public void setAks(ClusterConfigurationAks aks) {
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

    public ClusterVirtualNodeGroupTemplateAks getVirtualNodeGroupTemplate() {

        return virtualNodeGroupTemplate;
    }

    public void setVirtualNodeGroupTemplate(ClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplate) {

        isSet.add("virtualNodeGroupTemplate");
        this.virtualNodeGroupTemplate = virtualNodeGroupTemplate;
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


}