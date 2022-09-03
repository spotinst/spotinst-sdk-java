package com.spotinst.sdkjava.model.api.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiSpotDeployment implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         name;
    private String                         oldVersion;
    private String                         newVersion;
    private ApiSpotDeploymentManifest      oldManifest;
    private ApiSpotDeploymentManifest      newManifest;

    private ApiSpotDeployment() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getOldVersion() {
        return oldVersion;
    }

    public void setOldVersion(String oldVersion) {
        isSet.add("oldVersion");
        this.oldVersion = oldVersion;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        isSet.add("newVersion");
        this.newVersion = newVersion;
    }

    public ApiSpotDeploymentManifest getOldManifest() {
        return oldManifest;
    }

    public void setOldManifest(ApiSpotDeploymentManifest oldManifest) {
        isSet.add("oldManifest");
        this.oldManifest = oldManifest;
    }

    public ApiSpotDeploymentManifest getNewManifest() {
        return newManifest;
    }

    public void setNewManifest(ApiSpotDeploymentManifest newManifest) {
        isSet.add("newManifest");
        this.newManifest = newManifest;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isOldVersionSet() {
        return isSet.contains("oldVersion");
    }

    @JsonIgnore
    public boolean isNewVersionSet() {
        return isSet.contains("newVersion");
    }

    @JsonIgnore
    public boolean isOldManifestSet() {
        return isSet.contains("oldManifest");
    }

    @JsonIgnore
    public boolean isNewManifestSet() {
        return isSet.contains("newManifest");
    }
}