package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class GetClusterNodesResponse {
    @JsonIgnore
    private Set<String>                            isSet;
    private String                             lifeCycle;
    private String			                    publicIp;
    private Integer            workloadRequestedMilliCpu;
    private Integer         workloadRequestedMemoryInMiB;
    private Integer            headroomRequestedMilliCpu;
    private Integer         headroomRequestedMemoryInMiB;
    private Integer                  allocatableMilliCpu;
    private Integer               allocatableMemoryInMiB;
    private String                              nodeName;
    private String                    registrationStatus;
    private String                             createdAt;
    private String                            instanceId;
    private String                          instanceType;
    private String                      availabilityZone;
    private String                          launchSpecId;
    private String                        launchSpecName;

    private GetClusterNodesResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
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

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        isSet.add("instanceId");
        this.instanceId = instanceId;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public String getLaunchSpecId() {
        return launchSpecId;
    }

    public void setLaunchSpecId(String launchSpecId) {
        isSet.add("launchSpecId");
        this.launchSpecId = launchSpecId;
    }

    public String getLaunchSpecName() {
        return launchSpecName;
    }

    public void setLaunchSpecName(String launchSpecName) {
        isSet.add("launchSpecName");
        this.launchSpecName = launchSpecName;
    }

    public static class Builder {
        private GetClusterNodesResponse clusterVNGNodes;

        private Builder() {
            this.clusterVNGNodes = new GetClusterNodesResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setLifeCycle(final String lifeCycle) {
            clusterVNGNodes.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder setPublicIp(final String publicIp) {
            clusterVNGNodes.setPublicIp(publicIp);
            return this;
        }

        public Builder setWorkloadRequestedMilliCpu(final Integer workloadRequestedMilliCpu) {
            clusterVNGNodes.setWorkloadRequestedMilliCpu(workloadRequestedMilliCpu);
            return this;
        }

        public Builder setWorkloadRequestedMemoryInMiB(final Integer workloadRequestedMemoryInMiB) {
            clusterVNGNodes.setWorkloadRequestedMemoryInMiB(workloadRequestedMemoryInMiB);
            return this;
        }

        public Builder setHeadroomRequestedMilliCpu(final Integer headroomRequestedMilliCpu) {
            clusterVNGNodes.setHeadroomRequestedMilliCpu(headroomRequestedMilliCpu);
            return this;
        }

        public Builder setHeadroomRequestedMemoryInMiB(final Integer headroomRequestedMemoryInMiB) {
            clusterVNGNodes.setHeadroomRequestedMemoryInMiB(headroomRequestedMemoryInMiB);
            return this;
        }

        public Builder setAllocatableMilliCpu(final Integer allocatableMilliCpu) {
            clusterVNGNodes.setAllocatableMilliCpu(allocatableMilliCpu);
            return this;
        }

        public Builder setAllocatableMemoryInMiB(final Integer allocatableMemoryInMiB) {
            clusterVNGNodes.setAllocatableMemoryInMiB(allocatableMemoryInMiB);
            return this;
        }

        public Builder setNodeName(final String nodeName) {
            clusterVNGNodes.setNodeName(nodeName);
            return this;
        }

        public Builder setRegistrationStatus(final String registrationStatus) {
            clusterVNGNodes.setRegistrationStatus(registrationStatus);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            clusterVNGNodes.setCreatedAt(createdAt);
            return this;
        }

        public Builder setInstanceId(final String instanceId) {
            clusterVNGNodes.setInstanceId(instanceId);
            return this;
        }

        public Builder setInstanceType(final String instanceType) {
            clusterVNGNodes.setInstanceType(instanceType);
            return this;
        }

        public Builder setAvailabilityZone(final String availabilityZone) {
            clusterVNGNodes.setAvailabilityZone(availabilityZone);
            return this;
        }

        public Builder setLaunchSpecId(final String launchSpecId) {
            clusterVNGNodes.setLaunchSpecId(launchSpecId);
            return this;
        }

        public Builder setLaunchSpecName(final String launchSpecName) {
            clusterVNGNodes.setLaunchSpecName(launchSpecName);
            return this;
        }

        public GetClusterNodesResponse build() {
            // Validations
            return clusterVNGNodes;
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
    public boolean isHeadroomRequestedMilliCpuSet() {
        return isSet.contains("headroomRequestedMilliCpu");
    }

    @JsonIgnore
    public boolean isHeadroomRequestedMemoryInMiBSet() {
        return isSet.contains("headroomRequestedMemoryInMiB");
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
    public boolean isInstanceIdSet() {
        return isSet.contains("instanceId");
    }

    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

    @JsonIgnore
    public boolean isAvailabilityZoneSet() {
        return isSet.contains("availabilityZone");
    }

    @JsonIgnore
    public boolean isLaunchSpecIdSet() {
        return isSet.contains("launchSpecId");
    }

    @JsonIgnore
    public boolean isLaunchSpecNameSet() {
        return isSet.contains("launchSpecName");
    }
}