package com.spotinst.sdkjava.model;

/**
 * @author Caduri Katzav
 */
public class StatefulDeallocationConfig {
    //region Members
    private Boolean shouldDeleteNetworkInterfaces;
    private Boolean shouldDeleteSnapshots;
    private Boolean shouldDeleteImages;
    private Boolean shouldDeleteVolumes;
    private Boolean shouldTerminateInstance;
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

    public Boolean getShouldTerminateInstance() {
        return shouldTerminateInstance;
    }

    public void setShouldTerminateInstance(Boolean shouldTerminateInstance) {
        this.shouldTerminateInstance = shouldTerminateInstance;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private StatefulDeallocationConfig statefulDeallocationConfig;

        private Builder() {
            this.statefulDeallocationConfig = new StatefulDeallocationConfig();
        }

        public static StatefulDeallocationConfig.Builder get() {
            StatefulDeallocationConfig.Builder builder = new StatefulDeallocationConfig.Builder();
            return builder;
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

        public StatefulDeallocationConfig.Builder setShouldTerminateInstance(Boolean shouldTerminateInstance) {
            statefulDeallocationConfig.setShouldTerminateInstance(shouldTerminateInstance);
            return this;
        }

        public StatefulDeallocationConfig build() {
            // TODO : Validations
            return statefulDeallocationConfig;
        }
    }
    //endregion
}
