package com.spotinst.sdkjava.model.bl.oceanCD.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpotDeploymentManifest {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         kind;
    private String                         apiVersion;

    private SpotDeploymentManifest() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        isSet.add("kind");
        this.kind = kind;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        isSet.add("apiVersion");
        this.apiVersion = apiVersion;
    }

    public static class Builder {
        private SpotDeploymentManifest spotDeploymentManifest;

        private Builder() {
            this.spotDeploymentManifest = new SpotDeploymentManifest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setKind(final String kind) {
            spotDeploymentManifest.setKind(kind);
            return this;
        }

        public Builder setApiVersion(final String apiVersion) {
            spotDeploymentManifest.setApiVersion(apiVersion);
            return this;
        }

        public SpotDeploymentManifest build() {
            return spotDeploymentManifest;
        }
    }

    @JsonIgnore
    public boolean isKindSet() {
        return isSet.contains("kind");
    }

    @JsonIgnore
    public boolean isApiVersionSet() {
        return isSet.contains("apiVersion");
    }
}