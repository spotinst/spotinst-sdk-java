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
public class ImportOceanEcsClusterResponse {

    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 name;
    private String                                 region;
    private String                                 clusterName;
    private ImportClusterComputeConfiguration      compute;

    private ImportOceanEcsClusterResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        isSet.add("region");
        this.region = region;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setclusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
    }

    public ImportClusterComputeConfiguration getCompute() {
        return compute;
    }

    public void setCompute(ImportClusterComputeConfiguration compute) {
        isSet.add("compute");
        this.compute = compute;
    }

    public static class Builder {
        private ImportOceanEcsClusterResponse cluster;

        private Builder() {
            this.cluster = new ImportOceanEcsClusterResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            cluster.setName(name);
            return this;
        }
        public Builder setRegion(final String region) {
            cluster.setRegion(region);
            return this;
        }
        public Builder setClusterName(final String clusterName) {
            cluster.setclusterName(clusterName);
            return this;
        }
        public Builder setCompute(final ImportClusterComputeConfiguration compute) {
            cluster.setCompute(compute);
            return this;
        }

        public ImportOceanEcsClusterResponse build() {
            // Validations
            return cluster;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
    }

    @JsonIgnore
    public boolean isRegionSet() {
        return isSet.contains("region");
    }

    @JsonIgnore
    public boolean isComputeSet() {
        return isSet.contains("compute");
    }

}