package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiAmiBackup {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Boolean     shouldDeleteImages;

    public ApiAmiBackup() {
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

    @JsonIgnore
    public boolean isShouldDeleteImagesSet() {
        return isSet.contains("shouldDeleteImages");
    }
}
