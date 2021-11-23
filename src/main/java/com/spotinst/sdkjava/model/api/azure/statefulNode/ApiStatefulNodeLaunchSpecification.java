package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiStatefulNodeLaunchSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                isSet;
    private ApiLaunchSpecImageConfiguration            image;
    private ApiLaunchSpecNetworkConfiguration          network;
    private List<ApiLaunchSpecDataDisksSpecification>  dataDisks;
    private ApiLaunchSpecOsDiskSpecification           osDisk;
    private List<ApiLaunchSpecExtensionsSpecification> extensions;
    private ApiLaunchSpecLoginSpecification            login;
    private List<ApiLaunchSpecTagsSpecification>       tags;

    private ApiStatefulNodeLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiLaunchSpecImageConfiguration getImage() {
        return image;
    }

    public void setImage(ApiLaunchSpecImageConfiguration image) {
        isSet.add("image");
        this.image = image;
    }

    public ApiLaunchSpecNetworkConfiguration getNetwork() {
        return network;
    }

    public void setNetwork(ApiLaunchSpecNetworkConfiguration network) {
        isSet.add("network");
        this.network = network;
    }

    public List<ApiLaunchSpecDataDisksSpecification> getDataDisks() {
        return dataDisks;
    }

    public void setDataDisks(List<ApiLaunchSpecDataDisksSpecification> dataDisks) {
        isSet.add("dataDisks");
        this.dataDisks = dataDisks;
    }

    public ApiLaunchSpecOsDiskSpecification getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ApiLaunchSpecOsDiskSpecification osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    public List<ApiLaunchSpecExtensionsSpecification> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<ApiLaunchSpecExtensionsSpecification> extensions) {
        isSet.add("extensions");
        this.extensions = extensions;
    }

    public ApiLaunchSpecLoginSpecification getLogin() {
        return login;
    }

    public void setLogin(ApiLaunchSpecLoginSpecification login) {
        isSet.add("login");
        this.login = login;
    }

    public List<ApiLaunchSpecTagsSpecification> getTags() {
        return tags;
    }

    public void setTags(List<ApiLaunchSpecTagsSpecification> tags) {
        isSet.add("tags");
        this.tags = tags;
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