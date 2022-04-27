package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeLaunchSpecification {
    @JsonIgnore
    private Set<String>                             isSet;
    private LaunchSpecImageConfiguration            image;
    private LaunchSpecNetworkConfiguration          network;
    private List<LaunchSpecDataDisksSpecification>  dataDisks;
    private LaunchSpecOsDiskSpecification           osDisk;
    private List<LaunchSpecExtensionsSpecification> extensions;
    private LaunchSpecLoginSpecification            login;
    private List<LaunchSpecTagsSpecification>       tags;

    private StatefulNodeLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public LaunchSpecImageConfiguration getImage() {
        return image;
    }

    public void setImage(LaunchSpecImageConfiguration image) {
        isSet.add("image");
        this.image = image;
    }

    public LaunchSpecNetworkConfiguration getNetwork() {
        return network;
    }

    public void setNetwork(LaunchSpecNetworkConfiguration network) {
        isSet.add("network");
        this.network = network;
    }

    public List<LaunchSpecDataDisksSpecification> getDataDisks() {
        return dataDisks;
    }

    public void setDataDisks(List<LaunchSpecDataDisksSpecification> dataDisks) {
        isSet.add("dataDisks");
        this.dataDisks = dataDisks;
    }

    public LaunchSpecOsDiskSpecification getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(LaunchSpecOsDiskSpecification osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    public List<LaunchSpecExtensionsSpecification> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<LaunchSpecExtensionsSpecification> extensions) {
        isSet.add("extensions");
        this.extensions = extensions;
    }

    public LaunchSpecLoginSpecification getLogin() {
        return login;
    }

    public void setLogin(LaunchSpecLoginSpecification login) {
        isSet.add("login");
        this.login = login;
    }

    public List<LaunchSpecTagsSpecification> getTags() {
        return tags;
    }

    public void setTags(List<LaunchSpecTagsSpecification> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public static class Builder {

        private StatefulNodeLaunchSpecification launchspec;

        private Builder() {
            this.launchspec = new StatefulNodeLaunchSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setImage(final LaunchSpecImageConfiguration image) {
            launchspec.setImage(image);
            return this;
        }

        public Builder setNetwork(final LaunchSpecNetworkConfiguration network) {
            launchspec.setNetwork(network);
            return this;
        }

        public Builder setOsDisk(final LaunchSpecOsDiskSpecification osDisk) {
            launchspec.setOsDisk(osDisk);
            return this;
        }

        public Builder setDataDisks(final List<LaunchSpecDataDisksSpecification> dataDisks) {
            launchspec.setDataDisks(dataDisks);
            return this;
        }

        public Builder setIamInstanceProfile(final LaunchSpecOsDiskSpecification osDisk) {
            launchspec.setOsDisk(osDisk);
            return this;
        }

        public Builder setExtensions(final List<LaunchSpecExtensionsSpecification> extensions) {
            launchspec.setExtensions(extensions);
            return this;
        }

        public Builder setLogin(final LaunchSpecLoginSpecification login) {
            launchspec.setLogin(login);
            return this;
        }

        public Builder setTags(final List<LaunchSpecTagsSpecification> tags) {
            launchspec.setTags(tags);
            return this;
        }


        public StatefulNodeLaunchSpecification build() {
            return launchspec;
        }
    }

    @JsonIgnore
    public boolean isImageSet() {
        return isSet.contains("image");
    }

    @JsonIgnore
    public boolean isNetworkSet() {
        return isSet.contains("network");
    }

    @JsonIgnore
    public boolean isDataDisksSet() {
        return isSet.contains("dataDisks");
    }

    @JsonIgnore
    public boolean isOsDiskSet() {
        return isSet.contains("osDisk");
    }

    @JsonIgnore
    public boolean isExtensionsSet() {
        return isSet.contains("extensions");
    }

    @JsonIgnore
    public boolean isLoginSet() {
        return isSet.contains("login");
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

}