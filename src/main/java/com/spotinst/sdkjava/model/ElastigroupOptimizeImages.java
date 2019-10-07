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
   // private timeWindow timeWindow     //TODO Sali
    //endregion
    //region Constructors
    private  ElastigroupOptimizeImages(){isSet = new HashSet<>();}
    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        isSet.add("isSet");
        this.isSet = isSet;
    }

    public Boolean getShouldOptimizeEcsAmi() {
        return shouldOptimizeEcsAmi;
    }

    public void setShouldOptimizeEcsAmi(Boolean shouldOptimizeEcsAmi) {
        isSet.add("shouldOptimizeEcsAmi");
        this.shouldOptimizeEcsAmi = shouldOptimizeEcsAmi;
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

        public ElastigroupOptimizeImages build(){return optimizeImages;}
    }

    //region isSet methods
    // Is optimizeImages Set boolean method
    @JsonIgnore
    public boolean isShouldOptimizeEcsAmiSet() {
        return isSet.contains("shouldOptimizeEcsAmi");
    }

}
