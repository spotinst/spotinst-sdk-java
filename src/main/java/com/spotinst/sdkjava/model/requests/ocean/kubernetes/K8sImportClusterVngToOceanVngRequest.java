package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiImportEKSK8sVngSpec;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ImportEKSK8sVngSpec;
import com.spotinst.sdkjava.model.converters.K8sVngConverter;

import java.util.HashMap;
import java.util.Map;

public class K8sImportClusterVngToOceanVngRequest {

	@JsonProperty("launchSpec")
    private ImportEKSK8sVngSpec             vngLaunchSpec;
    private String                          accountId;
    private String                          eksClusterName;
    private String                          eksNodeGroupName;
    private String                          oceanId;
    private String                          region;

    private K8sImportClusterVngToOceanVngRequest() {
    }

    //region Getters & Setters
    public ImportEKSK8sVngSpec getVngLaunchSpec() {
        return vngLaunchSpec;
    }

    public void setVngLaunchSpec(ImportEKSK8sVngSpec vngLaunchSpec) {
        this.vngLaunchSpec = vngLaunchSpec;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEksClusterName() {
        return eksClusterName;
    }

    public void setEksClusterName(String eksClusterName) {
        this.eksClusterName = eksClusterName;
    }

    public String getEksNodeGroupName() {
        return eksNodeGroupName;
    }

    public void setEksNodeGroupName(String eksNodeGroupName) {
        this.eksNodeGroupName = eksNodeGroupName;
    }

    public String getOceanId() {
        return oceanId;
    }

    public void setOceanId(String oceanId) {
        this.oceanId = oceanId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
	
	public static class Builder {
        private K8sImportClusterVngToOceanVngRequest launchSpecCreationRequest;

        private Builder() {
            this.launchSpecCreationRequest = new K8sImportClusterVngToOceanVngRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVngLaunchSpec(final ImportEKSK8sVngSpec k8sVirtualNodeGroup) {
            launchSpecCreationRequest.setVngLaunchSpec(k8sVirtualNodeGroup);
            return this;
        }

        public Builder setAccountId(final String accountId) {
            launchSpecCreationRequest.setAccountId(accountId);
            return this;
        }

        public Builder setOceanId(final String oceanId) {
            launchSpecCreationRequest.setOceanId(oceanId);
            return this;
        }

        public Builder setEksClusterName(final String eksClusterName) {
            launchSpecCreationRequest.setEksClusterName(eksClusterName);
            return this;
        }

        public Builder setEksNodeGroupName(final String eksNodeGroupName) {
            launchSpecCreationRequest.setEksNodeGroupName(eksNodeGroupName);
            return this;
        }

        public Builder setRegion(final String region) {
            launchSpecCreationRequest.setRegion(region);
            return this;
        }

        public K8sImportClusterVngToOceanVngRequest build() {
            return launchSpecCreationRequest;
        }

    }

    public String toJson() {
        ApiImportEKSK8sVngSpec apiLaunchSpecToCreate = K8sVngConverter.toDal(vngLaunchSpec);

        Map<String, ApiImportEKSK8sVngSpec> launchSpecRequest = new HashMap<>();
        launchSpecRequest.put("launchSpec", apiLaunchSpecToCreate);

        return JsonMapper.toJson(launchSpecRequest);
    }
}
