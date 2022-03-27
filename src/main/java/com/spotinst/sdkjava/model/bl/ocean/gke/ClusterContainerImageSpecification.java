package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterContainerImageSpecification {

    @JsonIgnore
    private Set<String>                 isSet;
    private List<String>                approvedImages;

    private ClusterContainerImageSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getApprovedImages() { return approvedImages; }

    public void setApprovedImages(List<String> approvedImages) {
        isSet.add("approvedImages");
        this.approvedImages = approvedImages;
    }

    public static class Builder {
        private ClusterContainerImageSpecification containerImageSpecification;

        private Builder() {
            this.containerImageSpecification = new ClusterContainerImageSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setApprovedImages(final List<String> approvedImages) {
            containerImageSpecification.setApprovedImages(approvedImages);
            return this;
        }

        public ClusterContainerImageSpecification build() {
            return containerImageSpecification;
        }
    }

    @JsonIgnore
    public boolean isApprovedImagesSet() { return isSet.contains("approvedImages"); }

}

