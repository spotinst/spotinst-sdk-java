package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterSecurityConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private ClusterContainerImageSpecification containerImage;


    private ClusterSecurityConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ClusterContainerImageSpecification getContainerImage() {
        return containerImage;
    }

    public void setContainerImage(ClusterContainerImageSpecification containerImage) {
        isSet.add("containerImage");
        this.containerImage = containerImage;
    }

    public static class Builder {
        private ClusterSecurityConfiguration security;

        private Builder() {
            this.security = new ClusterSecurityConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setContainerImage(final ClusterContainerImageSpecification containerImage) {
            security.setContainerImage(containerImage);
            return this;
        }

        public ClusterSecurityConfiguration build() {
            return security;
        }
    }

    @JsonIgnore
    public boolean isContainerimageSet() {
        return isSet.contains("containerImage");
    }

}
