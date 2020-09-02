package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.ElastigroupAutoScaleSpecification;
import com.spotinst.sdkjava.model.ElastigroupEcsBatch;
import com.spotinst.sdkjava.model.ElastigroupOptimizeImages;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupEcsSpecificationAzure {
    //region Members
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 clusterName;
    private ElastigroupAutoScaleSpecificationAzure autoScale;
    private ElastigroupOptimizeImagesAzure         optimizeImages;
    private ElastigroupEcsBatchAzure               batch;
    //endregion

    //region Constructor

    private ElastigroupEcsSpecificationAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
    }

    public ElastigroupAutoScaleSpecificationAzure getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ElastigroupAutoScaleSpecificationAzure autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public ElastigroupOptimizeImagesAzure getOptimizeImages() {
        return optimizeImages;
    }

    public void setOptimizeImages(ElastigroupOptimizeImagesAzure optimizeImages) {
        isSet.add("optimizeImages");
        this.optimizeImages = optimizeImages;
    }

    public ElastigroupEcsBatchAzure getBatch() {
        return batch;
    }

    public void setBatch(ElastigroupEcsBatchAzure batch) {
        isSet.add("batch");
        this.batch = batch;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupEcsSpecificationAzure ecs;

        private Builder() {
            this.ecs = new ElastigroupEcsSpecificationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setBatch(final ElastigroupEcsBatchAzure batch) {
            ecs.setBatch(batch);
            return this;
        }

        public Builder setClusterName(final String clusterName) {
            ecs.setClusterName(clusterName);
            return this;
        }

        public Builder setAutoScale(final ElastigroupAutoScaleSpecificationAzure autoScale) {
            ecs.setAutoScale(autoScale);
            return this;
        }

        public Builder setOptimizeImages(final ElastigroupOptimizeImagesAzure optimizeImages) {
            ecs.setOptimizeImages(optimizeImages);
            return this;
        }

        public ElastigroupEcsSpecificationAzure build() {
            return ecs;
        }
    }
    //endregion

    //region isSet methods
    // Is autoScale Set boolean method
    @JsonIgnore
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }

    // Is clusterName Set boolean method
    @JsonIgnore
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
    }

    // Is optimizeImages Set boolean method
    @JsonIgnore
    public boolean isOptimizeImagesSet() {
        return isSet.contains("optimizeImages");
    }

    // Is batch Set boolean method
    @JsonIgnore
    public boolean isBatchSet() {
        return isSet.contains("batch");
    }

    //endregion

}
