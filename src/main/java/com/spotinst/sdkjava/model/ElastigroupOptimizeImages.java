package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupOptimizeImages {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private Boolean shouldOptimizeEcsAmi;
    private ElastigroupPerFormAtSpecification performAt;
    //endregion
    //region Constructors
    private  ElastigroupOptimizeImages(){isSet = new HashSet<>();}
    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldOptimizeEcsAmi() {
        return shouldOptimizeEcsAmi;
    }

    public void setShouldOptimizeEcsAmi(Boolean shouldOptimizeEcsAmi) {
        isSet.add("shouldOptimizeEcsAmi");
        this.shouldOptimizeEcsAmi = shouldOptimizeEcsAmi;
    }
    public ElastigroupPerFormAtSpecification getPerformAt() {
        return performAt;
    }

    public void setPerformAt(ElastigroupPerFormAtSpecification performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }
    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupOptimizeImages optimizeImages;

        private Builder() { this.optimizeImages = new ElastigroupOptimizeImages(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setShouldOptimizeEcsAmi (final Boolean shouldOptimizeEcsAmi) {
            optimizeImages.setShouldOptimizeEcsAmi(shouldOptimizeEcsAmi);
            return this;
        }
        public Builder setPerformAt (final ElastigroupPerFormAtSpecification performAt) {
            optimizeImages.setPerformAt(performAt);
            return this;
        }

        public ElastigroupOptimizeImages build(){return optimizeImages;}
    }

    //region isSet methods
    // Is optimizeImages Set boolean method
    @JsonIgnore
    public boolean isShouldOptimizeEcsAmiSet() {
        return isSet.contains("shouldOptimizeEcsAmi");
    }

    // Is performAt Set boolean method
    @JsonIgnore
    public boolean isPerformAtSet() {
        return isSet.contains("performAt");
    }

}
