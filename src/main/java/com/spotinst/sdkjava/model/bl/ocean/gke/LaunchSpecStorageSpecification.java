package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecStorageSpecification {

    private Set<String> isSet;
    private Integer         localSsdCount;

    public LaunchSpecStorageSpecification(){ isSet = new HashSet<>();
    }
    public Integer getLocalSsdCount() {
        return localSsdCount;
    }

    public void setLocalSsdCount(Integer localSsdCount) {
        isSet.add("localSsdCount");
        this.localSsdCount = localSsdCount;
    }

    public static class Builder {
        private LaunchSpecStorageSpecification gkeStorage;

        private Builder() {
            this.gkeStorage = new LaunchSpecStorageSpecification();
        }

        public static LaunchSpecStorageSpecification.Builder get() {
            LaunchSpecStorageSpecification.Builder builder = new LaunchSpecStorageSpecification.Builder();
            return builder;
        }

        public LaunchSpecStorageSpecification.Builder setLocalSsdCount(final Integer localSsdCount) {
            gkeStorage.setLocalSsdCount(localSsdCount);
            return this;
        }

        public LaunchSpecStorageSpecification build() {
            return gkeStorage;
        }
    }


    @JsonIgnore
    public boolean isLocalSsdCountSet() {
        return isSet.contains("localSsdCount");
    }

}
