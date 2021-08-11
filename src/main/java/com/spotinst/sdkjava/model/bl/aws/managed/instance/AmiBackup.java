package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/09/21.
 */

public class AmiBackup {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeleteImages;

    private AmiBackup() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getShouldDeleteImages() {
        return shouldDeleteImages;
    }

    public void setShouldDeleteImages(Boolean shouldDeleteImages) {
        isSet.add("shouldDeleteImages");
        this.shouldDeleteImages = shouldDeleteImages;
    }

    public static class Builder {
        private AmiBackup amiBackup;

        private Builder() {
            this.amiBackup = new AmiBackup();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setShouldDeleteImages(final Boolean shouldDeleteImages) {
            amiBackup.setShouldDeleteImages(shouldDeleteImages);
            return this;
        }

        public AmiBackup build() {
            // TODO : Validations
            return amiBackup;
        }
    }

    @JsonIgnore
    public boolean isShouldDeleteImagesSet() {
        return isSet.contains("shouldDeleteImages");
    }
}
