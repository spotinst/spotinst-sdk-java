package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmiBackupConfig {
    //region Members
    private Boolean shouldDeleteImages;

    //endregion

    //region Getters & Setters

    public Boolean getShouldDeleteImages() {
        return shouldDeleteImages;
    }

    public void setShouldDeleteImages(Boolean shouldDeleteImages) {
        this.shouldDeleteImages = shouldDeleteImages;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private AmiBackupConfig amiBackup;

        private Builder() {
            this.amiBackup = new AmiBackupConfig();
        }

        public static AmiBackupConfig.Builder get() {
            AmiBackupConfig.Builder builder = new AmiBackupConfig.Builder();
            return builder;
        }

        public AmiBackupConfig.Builder setShouldDeleteImages(final Boolean shouldDeleteImages) {
            amiBackup.setShouldDeleteImages(shouldDeleteImages);
            return this;
        }

        public AmiBackupConfig build() {
            return amiBackup;
        }
    }
    //endregion
}
