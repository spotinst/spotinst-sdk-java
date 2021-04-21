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

public class OceanClusterAks {

    @JsonIgnore
    private Set<String>                         isSet;
    private String                              id;
    private ClusterConfigurationAks             aks;
    private String                              controllerClusterId;
    private String                              name;
    private ClusterVirtualNodeGroupTemplateAks  virtualNodeGroupTemplate;



    private OceanClusterAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public OceanClusterAks setIsSet(Set<String> isSet) {
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

    public static class Builder {

        private OceanClusterAks clusterAks;

        private Builder() {
            this.clusterAks = new OceanClusterAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setControllerClusterId(final String controllerClusterId) {
            clusterAks.setControllerClusterId(controllerClusterId);
            return this;
        }

        public Builder setName(final String name) {
            clusterAks.setName(name);
            return this;

        }

        public Builder setAks(final ClusterConfigurationAks aks) {
            clusterAks.setAks(aks);
            return this;
        }

        public Builder setVirtualNodeGroupTemplate(final ClusterVirtualNodeGroupTemplateAks virtualNodeGroupTemplate) {
            clusterAks.setVirtualNodeGroupTemplate(virtualNodeGroupTemplate);
            return this;
        }

        public Builder setId(final String id) {
            clusterAks.setId(id);
            return this;
        }

        public OceanClusterAks build() {
            return clusterAks;
        }
    }

}