package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpotDeployment {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         name;
    private String                         oldVersion;
    private String                         newVersion;
    private SpotDeploymentManifest         oldManifest;
    private SpotDeploymentManifest         newManifest;

    private SpotDeployment() {
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

    public SpotDeploymentManifest getOldManifest() {
        return oldManifest;
    }

    public void setOldManifest(SpotDeploymentManifest oldManifest) {
        isSet.add("oldManifest");
        this.oldManifest = oldManifest;
    }

    public SpotDeploymentManifest getNewManifest() {
        return newManifest;
    }

    public void setNewManifest(SpotDeploymentManifest newManifest) {
        isSet.add("newManifest");
        this.newManifest = newManifest;
    }

    public static class Builder {
        private SpotDeployment spotDeployment;

        private Builder() {
            this.spotDeployment = new SpotDeployment();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            spotDeployment.setName(name);
            return this;
        }

        public Builder setOldVersion(final String oldVersion) {
            spotDeployment.setOldVersion(oldVersion);
            return this;
        }

        public Builder setNewVersion(final String newVersion) {
            spotDeployment.setNewVersion(newVersion);
            return this;
        }

        public Builder setOldManifest(final SpotDeploymentManifest oldManifest) {
            spotDeployment.setOldManifest(oldManifest);
            return this;
        }

        public Builder setNewManifest(final SpotDeploymentManifest newManifest) {
            spotDeployment.setNewManifest(newManifest);
            return this;
        }

        public SpotDeployment build() {
            return spotDeployment;
        }
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