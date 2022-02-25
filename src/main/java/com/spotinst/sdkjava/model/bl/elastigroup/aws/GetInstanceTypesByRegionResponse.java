package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetInstanceTypesByRegionResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             instanceType;

    public GetInstanceTypesByRegionResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        isSet.add("instanceType");
        this.instanceType = instanceType;
    }

    public static class Builder {
        private GetInstanceTypesByRegionResponse getInstanceTypesByRegion;

        private Builder() {
            this.getInstanceTypesByRegion = new GetInstanceTypesByRegionResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public GetInstanceTypesByRegionResponse.Builder setInstanceType(final String instanceType) {
            getInstanceTypesByRegion.setInstanceType(instanceType);
            return this;
        }

        public GetInstanceTypesByRegionResponse build() {
            return getInstanceTypesByRegion;
        }

    }

    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

}
