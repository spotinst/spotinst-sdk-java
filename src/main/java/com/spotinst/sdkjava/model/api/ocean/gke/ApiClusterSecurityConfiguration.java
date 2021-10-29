package com.spotinst.sdkjava.model.api.ocean.gke;

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
public class ApiClusterSecurityConfiguration implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                           isSet;
    private ApiClusterContainerImageSpecification containerImage;

    public ApiClusterSecurityConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiClusterContainerImageSpecification getContainerImage() {
        return containerImage;
    }

    public void setContainerImage(ApiClusterContainerImageSpecification containerImage) {
        isSet.add("containerImage");
        this.containerImage = containerImage;
    }

    @JsonIgnore
    public boolean isContainerImageSet() { return isSet.contains("containerImage"); }

}
