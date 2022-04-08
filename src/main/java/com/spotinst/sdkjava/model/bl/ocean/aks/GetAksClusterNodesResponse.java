package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class GetAksClusterNodesResponse {
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                vmName;
    private String                                vmSize;
    private String                      availabilityZone;
    private String                    virtualNodeGroupId;
    private String                  virtualNodeGroupName;
    private String                             lifeCycle;
    private String			                    publicIp;
    private Integer            workloadRequestedMilliCpu;
    private Integer         workloadRequestedMemoryInMiB;
    private Integer                 workloadRequestedGpu;
    private Integer            headroomRequestedMilliCpu;
    private Integer         headroomRequestedMemoryInMiB;
    private Integer                 headroomRequestedGpu;
    private Integer                  allocatableMilliCpu;
    private Integer               allocatableMemoryInMiB;
    private Integer                       allocatableGpu;
    private String                              nodeName;
    private String                    registrationStatus;
    private String                             createdAt;

    private GetAksClusterNodesResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public String getVmSize() {
        return vmSize;
    }

    public void setVmSize(String vmSize) {
        isSet.add("vmSize");
        this.vmSize = vmSize;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        isSet.add("lifeCycle");
        this.lifeCycle = lifeCycle;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        isSet.add("publicIp");
        this.publicIp = publicIp;
    }

    public Integer getWorkloadRequestedMilliCpu() {
        return workloadRequestedMilliCpu;
    }

    public void setWorkloadRequestedMilliCpu(Integer workloadRequestedMilliCpu) {
        isSet.add("workloadRequestedMilliCpu");
        this.workloadRequestedMilliCpu = workloadRequestedMilliCpu;
    }

    public Integer getWorkloadRequestedMemoryInMiB() {
        return workloadRequestedMemoryInMiB;
    }

    public void setWorkloadRequestedMemoryInMiB(Integer workloadRequestedMemoryInMiB) {
        isSet.add("workloadRequestedMemoryInMiB");
        this.workloadRequestedMemoryInMiB = workloadRequestedMemoryInMiB;
    }

    public Integer getWorkloadRequestedGpu() {
        return workloadRequestedGpu;
    }

    public void setWorkloadRequestedGpu(Integer workloadRequestedGpu) {
        isSet.add("workloadRequestedGpu");
        this.workloadRequestedGpu = workloadRequestedGpu;
    }

    public Integer getHeadroomRequestedMilliCpu() {
        return headroomRequestedMilliCpu;
    }

    public void setHeadroomRequestedMilliCpu(Integer headroomRequestedMilliCpu) {
        isSet.add("headroomRequestedMilliCpu");
        this.headroomRequestedMilliCpu = headroomRequestedMilliCpu;
    }

    public Integer getHeadroomRequestedMemoryInMiB() {
        return headroomRequestedMemoryInMiB;
    }

    public void setHeadroomRequestedMemoryInMiB(Integer headroomRequestedMemoryInMiB) {
        isSet.add("headroomRequestedMemoryInMiB");
        this.headroomRequestedMemoryInMiB = headroomRequestedMemoryInMiB;
    }

    public Integer getHeadroomRequestedGpu() {
        return headroomRequestedGpu;
    }

    public void setHeadroomRequestedGpu(Integer headroomRequestedGpu) {
        isSet.add("headroomRequestedGpu");
        this.headroomRequestedGpu = headroomRequestedGpu;
    }

    public Integer getAllocatableMilliCpu() {
        return allocatableMilliCpu;
    }

    public void setAllocatableMilliCpu(Integer allocatableMilliCpu) {
        isSet.add("allocatableMilliCpu");
        this.allocatableMilliCpu = allocatableMilliCpu;
    }

    public Integer getAllocatableMemoryInMiB() {
        return allocatableMemoryInMiB;
    }

    public void setAllocatableMemoryInMiB(Integer allocatableMemoryInMiB) {
        isSet.add("allocatableMemoryInMiB");
        this.allocatableMemoryInMiB = allocatableMemoryInMiB;
    }

    public Integer getAllocatableGpu() {
        return allocatableGpu;
    }

    public void setAllocatableGpu(Integer allocatableGpu) {
        isSet.add("allocatableGpu");
        this.allocatableGpu = allocatableGpu;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        isSet.add("nodeName");
        this.nodeName = nodeName;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        isSet.add("registrationStatus");
        this.registrationStatus = registrationStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public String getVirtualNodeGroupId() {
        return virtualNodeGroupId;
    }

    public void setVirtualNodeGroupId(String virtualNodeGroupId) {
        isSet.add("virtualNodeGroupId");
        this.virtualNodeGroupId = virtualNodeGroupId;
    }

    public String getVirtualNodeGroupName() {
        return virtualNodeGroupName;
    }

    public void setVirtualNodeGroupName(String virtualNodeGroupName) {
        isSet.add("virtualNodeGroupName");
        this.virtualNodeGroupName = virtualNodeGroupName;
    }

    public static class Builder {
        private GetAksClusterNodesResponse clusterNodes;

        private Builder() {
            this.clusterNodes = new GetAksClusterNodesResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setLifeCycle(final String lifeCycle) {
            clusterNodes.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder setPublicIp(final String publicIp) {
            clusterNodes.setPublicIp(publicIp);
            return this;
        }

        public Builder setWorkloadRequestedMilliCpu(final Integer workloadRequestedMilliCpu) {
            clusterNodes.setWorkloadRequestedMilliCpu(workloadRequestedMilliCpu);
            return this;
        }

        public Builder setWorkloadRequestedMemoryInMiB(final Integer workloadRequestedMemoryInMiB) {
            clusterNodes.setWorkloadRequestedMemoryInMiB(workloadRequestedMemoryInMiB);
            return this;
        }

        public Builder setWorkloadRequestedGpu(final Integer workloadRequestedGpu) {
            clusterNodes.setWorkloadRequestedGpu(workloadRequestedGpu);
            return this;
        }

        public Builder setHeadroomRequestedMilliCpu(final Integer headroomRequestedMilliCpu) {
            clusterNodes.setHeadroomRequestedMilliCpu(headroomRequestedMilliCpu);
            return this;
        }

        public Builder setHeadroomRequestedMemoryInMiB(final Integer headroomRequestedMemoryInMiB) {
            clusterNodes.setHeadroomRequestedMemoryInMiB(headroomRequestedMemoryInMiB);
            return this;
        }

        public Builder setHeadroomRequestedGpu(final Integer headroomRequestedGpu) {
            clusterNodes.setHeadroomRequestedGpu(headroomRequestedGpu);
            return this;
        }

        public Builder setAllocatableMilliCpu(final Integer allocatableMilliCpu) {
            clusterNodes.setAllocatableMilliCpu(allocatableMilliCpu);
            return this;
        }

        public Builder setAllocatableMemoryInMiB(final Integer allocatableMemoryInMiB) {
            clusterNodes.setAllocatableMemoryInMiB(allocatableMemoryInMiB);
            return this;
        }

        public Builder setAllocatableGpu(final Integer allocatableGpu) {
            clusterNodes.setAllocatableGpu(allocatableGpu);
            return this;
        }

        public Builder setNodeName(final String nodeName) {
            clusterNodes.setNodeName(nodeName);
            return this;
        }

        public Builder setRegistrationStatus(final String registrationStatus) {
            clusterNodes.setRegistrationStatus(registrationStatus);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            clusterNodes.setCreatedAt(createdAt);
            return this;
        }

        public Builder setVmName(final String vmName) {
            clusterNodes.setVmName(vmName);
            return this;
        }

        public Builder setVmSize(final String vmSize) {
            clusterNodes.setVmSize(vmSize);
            return this;
        }

        public Builder setAvailabilityZone(final String availabilityZone) {
            clusterNodes.setAvailabilityZone(availabilityZone);
            return this;
        }

        public Builder setVirtualNodeGroupId(final String virtualNodeGroupId) {
            clusterNodes.setVirtualNodeGroupId(virtualNodeGroupId);
            return this;
        }

        public Builder setVirtualNodeGroupName(final String virtualNodeGroupName) {
            clusterNodes.setVirtualNodeGroupName(virtualNodeGroupName);
            return this;
        }

        public GetAksClusterNodesResponse build() {
            // Validations
            return clusterNodes;
        }
    }

    @JsonIgnore
    public boolean isLifeCycleSet() {
        return isSet.contains("lifeCycle");
    }

    @JsonIgnore
    public boolean isPublicIpSet() {
        return isSet.contains("publicIp");
    }

    @JsonIgnore
    public boolean isWorkloadRequestedMilliCpuSet() {
        return isSet.contains("workloadRequestedMilliCpu");
    }

    @JsonIgnore
    public boolean isWorkloadRequestedMemoryInMiBSet() {
        return isSet.contains("workloadRequestedMemoryInMiB");
    }

    @JsonIgnore
    public boolean isWorkloadRequestedGpuSet() {
        return isSet.contains("workloadRequestedGpu");
    }

    @JsonIgnore
    public boolean isHeadroomRequestedMilliCpuSet() {
        return isSet.contains("headroomRequestedMilliCpu");
    }

    @JsonIgnore
    public boolean isHeadroomRequestedMemoryInMiBSet() {
        return isSet.contains("headroomRequestedMemoryInMiB");
    }

    @JsonIgnore
    public boolean isHeadroomRequestedGpuSet() {
        return isSet.contains("headroomRequestedGpu");
    }

    @JsonIgnore
    public boolean isAllocatableMilliCpuSet() {
        return isSet.contains("allocatableMilliCpu");
    }

    @JsonIgnore
    public boolean isAllocatableMemoryInMiBSet() {
        return isSet.contains("allocatableMemoryInMiB");
    }

    @JsonIgnore
    public boolean isAllocatableGpuSet() {
        return isSet.contains("allocatableGpu");
    }

    @JsonIgnore
    public boolean isNodeNameSet() {
        return isSet.contains("nodeName");
    }

    @JsonIgnore
    public boolean isRegistrationStatusSet() {
        return isSet.contains("registrationStatus");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }

    @JsonIgnore
    public boolean isVmSizeSet() {
        return isSet.contains("vmSize");
    }

    @JsonIgnore
    public boolean isAvailabilityZoneSet() {
        return isSet.contains("availabilityZone");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupIdSet() {
        return isSet.contains("virtualNodeGroupId");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupNameSet() {
        return isSet.contains("virtualNodeGroupName");
    }
}