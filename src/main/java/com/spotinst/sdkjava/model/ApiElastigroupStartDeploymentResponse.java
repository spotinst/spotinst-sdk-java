package com.spotinst.sdkjava.model;
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
public class ApiElastigroupStartDeploymentResponse implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                                         isSet;
    private List<ApiElastigroupStartDeploymentItemsResponse>    items;

    public ApiElastigroupStartDeploymentResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupStartDeploymentItemsResponse> getItems() {
        return items;
    }

    public void setItems(List<ApiElastigroupStartDeploymentItemsResponse> items) {
        isSet.add("items");
        this.items = items;
    }

    public static class Builder {
        private ApiElastigroupStartDeploymentResponse startDeploymentResponse;

        private Builder() {
            this.startDeploymentResponse = new ApiElastigroupStartDeploymentResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setItems(final List<ApiElastigroupStartDeploymentItemsResponse> items) {
            startDeploymentResponse.setItems(items);
            return this;
        }

        public ApiElastigroupStartDeploymentResponse build() {
            return startDeploymentResponse;
        }

    }

    @JsonIgnore
    public boolean isSetItemsSet() {
        return isSet.contains("items");
    }

}
