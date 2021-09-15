package com.spotinst.sdkjava.model.api.ocean.gke;


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
public class ApiClusterContainerImageSpecification implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>  isSet;
    private List<String> approvedImages;

    public ApiClusterContainerImageSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getApprovedImages() {
        return approvedImages;
    }

    public void setApprovedImages(List<String> approvedImages) {
        isSet.add("approvedImages");
        this.approvedImages = approvedImages;
    }

    @JsonIgnore
    public boolean isApprovedImagesSet() { return isSet.contains("approvedImages"); }

}

