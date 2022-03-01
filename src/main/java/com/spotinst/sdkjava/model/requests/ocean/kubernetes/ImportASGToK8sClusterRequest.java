package com.spotinst.sdkjava.model.requests.ocean.kubernetes;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.OceanK8sConverter;
import com.spotinst.sdkjava.model.api.ocean.kubernetes.ApiImportAsgToClusterInstanceTypes;
import com.spotinst.sdkjava.model.bl.ocean.kubernetes.ImportAsgToClusterInstanceTypes;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

public class ImportASGToK8sClusterRequest {
    //region Members
    @JsonProperty("cluster")
    private ImportAsgToClusterInstanceTypes importAsgToClusterInstanceTypes;
    //endregion

    //region Private Constructor

    private ImportASGToK8sClusterRequest() {
    }

    //endregion

    //region Getters & Setters

    public ImportAsgToClusterInstanceTypes getImportAsgToCluster() {
        return importAsgToClusterInstanceTypes;
    }

    public void setImportAsgToCluster(ImportAsgToClusterInstanceTypes importAsgToClusterInstanceTypes) {
        this.importAsgToClusterInstanceTypes = importAsgToClusterInstanceTypes;
    }
    //endregion

    //Builder class
    public static class Builder {
        private ImportASGToK8sClusterRequest importAsgToClusterRequest;

        private Builder() {
            this.importAsgToClusterRequest = new ImportASGToK8sClusterRequest();
        }

        public static Builder get() {
            ImportASGToK8sClusterRequest.Builder builder = new Builder();
            return builder;
        }

        public Builder setImportAsgToCluster(final ImportAsgToClusterInstanceTypes importAsgToCluster) {
            importAsgToClusterRequest.setImportAsgToCluster(importAsgToCluster);
            return this;
        }

        public ImportASGToK8sClusterRequest build() {
            return importAsgToClusterRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiImportAsgToClusterInstanceTypes importAsgToClusterInstanceTypesRequest = OceanK8sConverter.toDal(importAsgToClusterInstanceTypes);
        Map<String, ApiImportAsgToClusterInstanceTypes> importAsgToClusterInstanceTypes = new HashMap<>();
        importAsgToClusterInstanceTypes.put("cluster", importAsgToClusterInstanceTypesRequest);
        String   importAsgToClusterInstanceTypesJson    = JsonMapper.toJson(importAsgToClusterInstanceTypes);

        return importAsgToClusterInstanceTypesJson;
    }

    //endregion
}

