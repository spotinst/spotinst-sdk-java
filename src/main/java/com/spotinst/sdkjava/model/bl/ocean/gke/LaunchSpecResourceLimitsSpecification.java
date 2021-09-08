package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecResourceLimitsSpecification {

    private int maxInstanceCount;

    private Set<String> isSet;

    public LaunchSpecResourceLimitsSpecification(){ isSet = new HashSet<>();
    }
    public int getMaxInstanceCount(){
        return maxInstanceCount;
    }

    public void setMaxInstanceCount(int maxInstanceCount){
        isSet.add("maxInstanceCount");
        this.maxInstanceCount = maxInstanceCount;
    }

    public static class Builder {
        private LaunchSpecResourceLimitsSpecification gkeResourceLimits;

        private Builder() {
            this.gkeResourceLimits = new LaunchSpecResourceLimitsSpecification();
        }

        public static LaunchSpecResourceLimitsSpecification.Builder get() {
            LaunchSpecResourceLimitsSpecification.Builder builder = new LaunchSpecResourceLimitsSpecification.Builder();
            return builder;
        }

        public LaunchSpecResourceLimitsSpecification.Builder setMaxInstanceCount(final int maxInstanceCount) {
            gkeResourceLimits.setMaxInstanceCount(maxInstanceCount);
            return this;
        }

        public LaunchSpecResourceLimitsSpecification build() {
            return gkeResourceLimits;
        }
    }


    @JsonIgnore
    public boolean isMaxInstanceCountSet() {
        return isSet.contains("maxInstanceCount");
    }
}
