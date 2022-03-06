package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
            return new Builder();
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
