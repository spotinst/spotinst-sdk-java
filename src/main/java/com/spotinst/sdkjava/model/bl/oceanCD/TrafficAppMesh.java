package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficAppMesh {
    @JsonIgnore
    private Set<String>                              isSet;
    private AppMeshVirtualService                    virtualService;
    private AppMeshVirtualNodeGroup                  virtualNodeGroup;

    private TrafficAppMesh() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public AppMeshVirtualService getVirtualService() {
        return virtualService;
    }

    public void setVirtualService(AppMeshVirtualService virtualService) {
        isSet.add("virtualService");
        this.virtualService = virtualService;
    }

    public AppMeshVirtualNodeGroup getVirtualNodeGroup() {
        return virtualNodeGroup;
    }

    public void setVirtualNodeGroup(AppMeshVirtualNodeGroup virtualNodeGroup) {
        isSet.add("virtualNodeGroup");
        this.virtualNodeGroup = virtualNodeGroup;
    }

    public static class Builder {
        private TrafficAppMesh trafficAppMesh;

        private Builder() {
            this.trafficAppMesh = new TrafficAppMesh();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVirtualService(final AppMeshVirtualService virtualService) {
            trafficAppMesh.setVirtualService(virtualService);
            return this;
        }

        public Builder setVirtualNodeGroup(final AppMeshVirtualNodeGroup virtualNodeGroup) {
            trafficAppMesh.setVirtualNodeGroup(virtualNodeGroup);
            return this;
        }

        public TrafficAppMesh build() {
            return trafficAppMesh;
        }
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