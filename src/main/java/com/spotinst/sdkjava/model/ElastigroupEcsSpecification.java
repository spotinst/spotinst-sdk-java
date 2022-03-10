package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupEcsSpecification {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private String                            clusterName;
    private ElastigroupAutoScaleSpecification autoScale;
    private ElastigroupOptimizeImages         optimizeImages;
    private ElastigroupEcsBatch batch;
    //endregion

    //region Constructor

    private ElastigroupEcsSpecification() {
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

    public ElastigroupAutoScaleSpecification getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ElastigroupAutoScaleSpecification autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public ElastigroupOptimizeImages getOptimizeImages() {
        return optimizeImages;
    }

    public void setOptimizeImages(ElastigroupOptimizeImages optimizeImages) {
        isSet.add("optimizeImages");
        this.optimizeImages = optimizeImages;
    }

    public ElastigroupEcsBatch getBatch() {
        return batch;
    }

    public void setBatch(ElastigroupEcsBatch batch) {
        isSet.add("batch");
        this.batch = batch;
    }
    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupEcsSpecification ecs;

        private Builder() {
            this.ecs = new ElastigroupEcsSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBatch (final ElastigroupEcsBatch batch ){
            ecs.setBatch(batch);
            return this;
        }

        public Builder setClusterName(final String clusterName) {
            ecs.setClusterName(clusterName);
            return this;
        }

        public Builder setAutoScale(final ElastigroupAutoScaleSpecification autoScale) {
            ecs.setAutoScale(autoScale);
            return this;
        }

        public Builder setOptimizeImages(final ElastigroupOptimizeImages optimizeImages) {
            ecs.setOptimizeImages(optimizeImages);
            return this;
        }

        public ElastigroupEcsSpecification build() {
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
