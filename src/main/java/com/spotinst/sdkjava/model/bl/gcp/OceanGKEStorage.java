package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class OceanGKEStorage {

    private Set<String> isSet;
    private int         localSsdCount;

    public OceanGKEStorage(){isSet = new HashSet<>();
    }
    public int getLocalSsdCount() {
        return localSsdCount;
    }

    public void setLocalSsdCount(int localSsdCount) {
        isSet.add("localSsdCount");
        this.localSsdCount = localSsdCount;
    }

    public static class Builder {
        private OceanGKEStorage gkeStorage;

        private Builder() {
            this.gkeStorage = new OceanGKEStorage();
        }

        public static OceanGKEStorage.Builder get() {
            OceanGKEStorage.Builder builder = new OceanGKEStorage.Builder();
            return builder;
        }

        public OceanGKEStorage.Builder setLocalSsdCount(final int localSsdCount) {
            gkeStorage.setLocalSsdCount(localSsdCount);
            return this;
        }

        public OceanGKEStorage build() {
            return gkeStorage;
        }
    }


    @JsonIgnore
    public boolean isLocalSsdCountSet() {
        return isSet.contains("localSsdCount");
    }

}
