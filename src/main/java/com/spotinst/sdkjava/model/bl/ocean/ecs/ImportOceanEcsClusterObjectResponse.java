package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 20/07/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportOceanEcsClusterObjectResponse {

    @JsonIgnore
    private Set<String>                            isSet;
    private ImportOceanEcsClusterResponse          cluster;


    private ImportOceanEcsClusterObjectResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ImportOceanEcsClusterResponse getCluster() {
        return cluster;
    }

    public void setCluster(ImportOceanEcsClusterResponse cluster) {
        isSet.add("cluster");
        this.cluster = cluster;
    }

    public static class Builder {
        private ImportOceanEcsClusterObjectResponse ecsCluster;

        private Builder() {
            this.ecsCluster = new ImportOceanEcsClusterObjectResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCluster(final ImportOceanEcsClusterResponse cluster) {
            ecsCluster.setCluster(cluster);
            return this;
        }

        public ImportOceanEcsClusterObjectResponse build() {
            // Validations
            return ecsCluster;
        }
    }

    @JsonIgnore
    public boolean isClusterSet() {
        return isSet.contains("cluster");
    }

}