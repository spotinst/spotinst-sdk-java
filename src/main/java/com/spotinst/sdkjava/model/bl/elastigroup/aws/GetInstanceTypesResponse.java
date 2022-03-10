package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetInstanceTypesResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             instanceType;

    public GetInstanceTypesResponse() {
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
        private GetInstanceTypesResponse getInstanceTypesByRegion;

        private Builder() {
            this.getInstanceTypesByRegion = new GetInstanceTypesResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public GetInstanceTypesResponse.Builder setInstanceType(final String instanceType) {
            getInstanceTypesByRegion.setInstanceType(instanceType);
            return this;
        }

        public GetInstanceTypesResponse build() {
            return getInstanceTypesByRegion;
        }

    }

    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

}
