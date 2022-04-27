package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.OceanK8sConverter;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiImportAsgToClusterInstanceTypes;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ImportAsgToClusterConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

public class ImportASGToK8sClusterRequest {
    //region Members
    @JsonProperty("cluster")
    private ImportAsgToClusterConfiguration instanceTypes;
    //endregion

    //region Private Constructor

    private ImportASGToK8sClusterRequest() {
    }

    //endregion

    //region Getters & Setters

    public ImportAsgToClusterConfiguration getImportAsgToCluster() {
        return instanceTypes;
    }

    public void setImportAsgToCluster(ImportAsgToClusterConfiguration importAsgToClusterInstanceTypes) {
        this.instanceTypes = importAsgToClusterInstanceTypes;
    }
    //endregion

    //Builder class
    public static class Builder {
        private ImportASGToK8sClusterRequest importAsgToClusterRequest;

        private Builder() {
            this.importAsgToClusterRequest = new ImportASGToK8sClusterRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setImportAsgToCluster(final ImportAsgToClusterConfiguration importAsgToCluster) {
            importAsgToClusterRequest.setImportAsgToCluster(importAsgToCluster);
            return this;
        }

        public ImportASGToK8sClusterRequest build() {
            return importAsgToClusterRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiImportAsgToClusterInstanceTypes importAsgToClusterInstanceTypesRequest = OceanK8sConverter.toDal(instanceTypes);
        Map<String, ApiImportAsgToClusterInstanceTypes> importAsgToClusterInstanceTypes = new HashMap<>();
        importAsgToClusterInstanceTypes.put("cluster", importAsgToClusterInstanceTypesRequest);

        return JsonMapper.toJson(importAsgToClusterInstanceTypes);
    }

    //endregion
}

