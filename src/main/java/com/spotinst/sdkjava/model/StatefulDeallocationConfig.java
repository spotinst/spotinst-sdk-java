package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Caduri Katzav
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulDeallocationConfig {
    //region Members
    private Boolean shouldDeleteNetworkInterfaces;
    private Boolean shouldDeleteSnapshots;
    private Boolean shouldDeleteImages;
    private Boolean shouldDeleteVolumes;
    //endregion

    //region Getters & Setters
    public Boolean getShouldDeleteNetworkInterfaces() {
        return shouldDeleteNetworkInterfaces;
    }

    public void setShouldDeleteNetworkInterfaces(Boolean shouldDeleteNetworkInterfaces) {
        this.shouldDeleteNetworkInterfaces = shouldDeleteNetworkInterfaces;
    }

    public Boolean getShouldDeleteSnapshots() {
        return shouldDeleteSnapshots;
    }

    public void setShouldDeleteSnapshots(Boolean shouldDeleteSnapshots) {
        this.shouldDeleteSnapshots = shouldDeleteSnapshots;
    }

    public Boolean getShouldDeleteImages() {
        return shouldDeleteImages;
    }

    public void setShouldDeleteImages(Boolean shouldDeleteImages) {
        this.shouldDeleteImages = shouldDeleteImages;
    }

    public Boolean getShouldDeleteVolumes() {
        return shouldDeleteVolumes;
    }

    public void setShouldDeleteVolumes(Boolean shouldDeleteVolumes) {
        this.shouldDeleteVolumes = shouldDeleteVolumes;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private StatefulDeallocationConfig statefulDeallocationConfig;

        private Builder() {
            this.statefulDeallocationConfig = new StatefulDeallocationConfig();
        }

        public static StatefulDeallocationConfig.Builder get() {
            return new Builder();
        }

        public StatefulDeallocationConfig.Builder setShouldDeleteNetworkInterfaces(final Boolean shouldDeleteNetworkInterfaces) {
            statefulDeallocationConfig.setShouldDeleteNetworkInterfaces(shouldDeleteNetworkInterfaces);
            return this;
        }

        public StatefulDeallocationConfig.Builder setShouldDeleteSnapshots(final Boolean shouldDeleteSnapshots) {
            statefulDeallocationConfig.setShouldDeleteSnapshots(shouldDeleteSnapshots);
            return this;
        }

        public StatefulDeallocationConfig.Builder setShouldDeleteImages(final Boolean shouldDeleteImages) {
            statefulDeallocationConfig.setShouldDeleteImages(shouldDeleteImages);
            return this;
        }

        public StatefulDeallocationConfig.Builder setShouldDeleteVolumes(Boolean shouldDeleteVolumes) {
            statefulDeallocationConfig.setShouldDeleteVolumes(shouldDeleteVolumes);
            return this;
        }

        public StatefulDeallocationConfig build() {
            return statefulDeallocationConfig;
        }
    }
    //endregion
}
