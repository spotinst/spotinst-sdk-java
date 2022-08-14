package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppMeshVirtualNodeGroup {
    @JsonIgnore
    private Set<String>                                     isSet;
    private VirtualNodeGroupCanaryStableVirtualNodeRef      canaryVirtualNodeRef;
    private VirtualNodeGroupCanaryStableVirtualNodeRef      stableVirtualNodeRef;

    private AppMeshVirtualNodeGroup() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public VirtualNodeGroupCanaryStableVirtualNodeRef getCanaryVirtualNodeRef() {
        return canaryVirtualNodeRef;
    }

    public void setCanaryVirtualNodeRef(VirtualNodeGroupCanaryStableVirtualNodeRef canaryVirtualNodeRef) {
        isSet.add("canaryVirtualNodeRef");
        this.canaryVirtualNodeRef = canaryVirtualNodeRef;
    }

    public VirtualNodeGroupCanaryStableVirtualNodeRef getStableVirtualNodeRef() {
        return stableVirtualNodeRef;
    }

    public void setStableVirtualNodeRef(VirtualNodeGroupCanaryStableVirtualNodeRef stableVirtualNodeRef) {
        isSet.add("stableVirtualNodeRef");
        this.stableVirtualNodeRef = stableVirtualNodeRef;
    }

    public static class Builder {
        private AppMeshVirtualNodeGroup appMeshVirtualNodeGroup;

        private Builder() {
            this.appMeshVirtualNodeGroup = new AppMeshVirtualNodeGroup();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCanaryVirtualNodeRef(final VirtualNodeGroupCanaryStableVirtualNodeRef canaryVirtualNodeRef) {
            appMeshVirtualNodeGroup.setCanaryVirtualNodeRef(canaryVirtualNodeRef);
            return this;
        }

        public Builder setStableVirtualNodeRef(final VirtualNodeGroupCanaryStableVirtualNodeRef stableVirtualNodeRef) {
            appMeshVirtualNodeGroup.setStableVirtualNodeRef(stableVirtualNodeRef);
            return this;
        }

        public AppMeshVirtualNodeGroup build() {
            return appMeshVirtualNodeGroup;
        }
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