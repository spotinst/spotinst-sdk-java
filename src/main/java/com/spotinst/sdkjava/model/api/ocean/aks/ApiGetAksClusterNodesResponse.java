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
public class ApiGetAksClusterNodesResponse implements IPartialUpdateEntity {
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


    public ApiGetAksClusterNodesResponse() {
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