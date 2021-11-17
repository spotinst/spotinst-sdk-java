package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupStartDeploymentResponse {
    @JsonIgnore
    private Set<String>                                   isSet;
    private List<ElastigroupStartDeploymentItemsResponse> items;

    public ElastigroupStartDeploymentResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupStartDeploymentItemsResponse> getItems() {
        return items;
    }

    public void setItems(List<ElastigroupStartDeploymentItemsResponse> items) {
        isSet.add("items");
        this.items = items;
    }

    public static class Builder {
        private ElastigroupStartDeploymentResponse startDeploymentResponse;

        private Builder() {
            this.startDeploymentResponse = new ElastigroupStartDeploymentResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setItems(final List<ElastigroupStartDeploymentItemsResponse> items) {
            startDeploymentResponse.setItems(items);
            return this;
        }

        public ElastigroupStartDeploymentResponse build() {
            return startDeploymentResponse;
        }

    }

    @JsonIgnore
    public boolean isSetItemsSet() {
        return isSet.contains("items");
    }

}



