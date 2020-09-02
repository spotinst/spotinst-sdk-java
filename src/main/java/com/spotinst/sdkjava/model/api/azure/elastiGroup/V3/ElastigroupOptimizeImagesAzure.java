package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.MaintenanceWindowTypeEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupOptimizeImagesAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>  isSet;
    private Boolean      shouldOptimizeEcsAmi;
    private MaintenanceWindowTypeEnumAzure performAt;
    private List<String>              timeWindows;

    //endregion
    //region Constructors
    private ElastigroupOptimizeImagesAzure() {
        isSet = new HashSet<>();
    }

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

    public MaintenanceWindowTypeEnumAzure getPerformAt() {
        return performAt;
    }

    public void setPerformAt(MaintenanceWindowTypeEnumAzure performAt) {
        isSet.add("performAt");
        this.performAt = performAt;
    }

    public List<String> getTimeWindows() {
        return timeWindows;
    }

    public void setTimeWindows(List<String> timeWindows) {
        isSet.add("timeWindows");
        this.timeWindows = timeWindows;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupOptimizeImagesAzure optimizeImages;

        private Builder() {
            this.optimizeImages = new ElastigroupOptimizeImagesAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldOptimizeEcsAmi(final Boolean shouldOptimizeEcsAmi) {
            optimizeImages.setShouldOptimizeEcsAmi(shouldOptimizeEcsAmi);
            return this;
        }

        public Builder setPerformAt(final MaintenanceWindowTypeEnumAzure performAt) {
            optimizeImages.setPerformAt(performAt);
            return this;
        }

        public Builder setTimeWindow(final List<String> timeWindow) {
            optimizeImages.setTimeWindows(timeWindow);
            return this;
        }

        public ElastigroupOptimizeImagesAzure build() {
            return optimizeImages;
        }

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

    // Is timeWindow Set boolean method
    @JsonIgnore
    public boolean isTimeWindowSet() {
        return isSet.contains("timeWindows");
    }

}
