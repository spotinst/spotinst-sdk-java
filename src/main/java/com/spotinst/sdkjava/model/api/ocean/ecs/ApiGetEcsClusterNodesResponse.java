package com.spotinst.sdkjava.model.api.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.AwsECSLifecycleEnum;
import com.spotinst.sdkjava.enums.AwsECSRegistrationStatusEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGetEcsClusterNodesResponse implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                            isSet;
    private AwsECSLifecycleEnum                lifeCycle;
    private String			                    publicIp;
    private Double              workloadRequestedCpuUnit;
    private Integer         workloadRequestedMemoryInMiB;
    private Integer                 workloadRequestedGpu;
    private Integer             headroomRequestedCpuUnit;
    private Integer         headroomRequestedMemoryInMiB;
    private Integer                 headroomRequestedGpu;
    private Integer                    registeredCpuUnit;
    private Integer                registeredMemoryInMiB;
    private Integer                        registeredGpu;
    private AwsECSRegistrationStatusEnum registrationStatus;
    private String                             createdAt;
    private String                   containerInstanceId;
    private String                            instanceId;
    private String                          instanceType;
    private String                      availabilityZone;
    private String                          launchSpecId;
    private String                        launchSpecName;

    private ApiGetEcsClusterNodesResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public AwsECSLifecycleEnum getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(AwsECSLifecycleEnum lifeCycle) {
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

    public Double getWorkloadRequestedCpuUnit() {
        return workloadRequestedCpuUnit;
    }

    public void setWorkloadRequestedCpuUnit(Double workloadRequestedCpuUnit) {
        isSet.add("workloadRequestedCpuUnit");
        this.workloadRequestedCpuUnit = workloadRequestedCpuUnit;
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

    public Integer getHeadroomRequestedCpuUnit() {
        return headroomRequestedCpuUnit;
    }

    public void setHeadroomRequestedCpuUnit(Integer headroomRequestedCpuUnit) {
        isSet.add("headroomRequestedCpuUnit");
        this.headroomRequestedCpuUnit = headroomRequestedCpuUnit;
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

    public Integer getRegisteredCpuUnit() {
        return registeredCpuUnit;
    }

    public void setRegisteredCpuUnit(Integer registeredCpuUnit) {
        isSet.add("registeredCpuUnit");
        this.registeredCpuUnit = registeredCpuUnit;
    }

    public Integer getRegisteredMemoryInMiB() {
        return registeredMemoryInMiB;
    }

    public void setRegisteredMemoryInMiB(Integer registeredMemoryInMiB) {
        isSet.add("registeredMemoryInMiB");
        this.registeredMemoryInMiB = registeredMemoryInMiB;
    }

    public String getContainerInstanceId() {
        return containerInstanceId;
    }

    public void setContainerInstanceId(String containerInstanceId) {
        isSet.add("containerInstanceId");
        this.containerInstanceId = containerInstanceId;
    }

    public AwsECSRegistrationStatusEnum getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(AwsECSRegistrationStatusEnum registrationStatus) {
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

    public Integer getRegisteredGpu() {
        return registeredGpu;
    }

    public void setRegisteredGpu(Integer registeredGpu) {
        isSet.add("registeredGpu");
        this.registeredGpu = registeredGpu;
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
    public boolean isWorkloadRequestedCpuUnitSet() {
        return isSet.contains("workloadRequestedCpuUnit");
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
    public boolean isHeadroomRequestedCpuUnitSet() {
        return isSet.contains("headroomRequestedCpuUnit");
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
    public boolean isRegisteredCpuUnitSet() {
        return isSet.contains("registeredCpuUnit");
    }

    @JsonIgnore
    public boolean isRegisteredMemoryInMiBSet() {
        return isSet.contains("registeredMemoryInMiB");
    }

    @JsonIgnore
    public boolean isRegisteredGpuSet() {
        return isSet.contains("registeredGpu");
    }

    @JsonIgnore
    public boolean isContainerInstanceIdSet() {
        return isSet.contains("containerInstanceId");
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