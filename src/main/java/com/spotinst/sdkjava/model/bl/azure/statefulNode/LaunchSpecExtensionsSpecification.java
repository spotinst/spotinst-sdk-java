package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecExtensionsSpecification {
    @JsonIgnore
    private Set<String>                           isSet;
    private String                                name;
    private String                                type;
    private String                                publisher;
    private String                                apiVersion;
    private Boolean                               minorVersionAutoUpgrade;
    private LaunchSpecExtensionsProtectedSettings protectedSettings;

    private LaunchSpecExtensionsSpecification() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        isSet.add("publisher");
        this.publisher = publisher;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        isSet.add("apiVersion");
        this.apiVersion = apiVersion;
    }

    public Boolean getMinorVersionAutoUpgrade() {
        return minorVersionAutoUpgrade;
    }

    public void setMinorVersionAutoUpgrade(Boolean minorVersionAutoUpgrade) {
        isSet.add("minorVersionAutoUpgrade");
        this.minorVersionAutoUpgrade = minorVersionAutoUpgrade;
    }

    public LaunchSpecExtensionsProtectedSettings getProtectedSettings() {
        return protectedSettings;
    }

    public void setProtectedSettings(LaunchSpecExtensionsProtectedSettings protectedSettings) {
        isSet.add("protectedSettings");
        this.protectedSettings = protectedSettings;
    }

    public static class Builder {

        private LaunchSpecExtensionsSpecification extensionsSpecification;

        private Builder() {
            this.extensionsSpecification = new LaunchSpecExtensionsSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            extensionsSpecification.setName(name);
            return this;
        }

        public Builder setType(final String type) {
            extensionsSpecification.setType(type);
            return this;
        }

        public Builder setPublisher(final String publisher) {
            extensionsSpecification.setPublisher(publisher);
            return this;
        }

        public Builder setApiVersion(final String apiVersion) {
            extensionsSpecification.setApiVersion(apiVersion);
            return this;
        }

        public Builder setMinorVersionAutoUpgrade(final Boolean minorVersionAutoUpgrade) {
            extensionsSpecification.setMinorVersionAutoUpgrade(minorVersionAutoUpgrade);
            return this;
        }

        public Builder setProtectedSettings(final LaunchSpecExtensionsProtectedSettings protectedSettings) {
            extensionsSpecification.setProtectedSettings(protectedSettings);
            return this;
        }

        public LaunchSpecExtensionsSpecification build() {
            return extensionsSpecification;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @JsonIgnore
    public boolean isPublisherSet() {
        return isSet.contains("publisher");
    }

    @JsonIgnore
    public boolean isApiVersionet() {
        return isSet.contains("apiVersion");
    }

    @JsonIgnore
    public boolean isMinorVersionAutoUpgradeSet() {
        return isSet.contains("minorVersionAutoUpgrade");
    }

    @JsonIgnore
    public boolean isProtectedSettingsSet() {
        return isSet.contains("protectedSettings");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

}