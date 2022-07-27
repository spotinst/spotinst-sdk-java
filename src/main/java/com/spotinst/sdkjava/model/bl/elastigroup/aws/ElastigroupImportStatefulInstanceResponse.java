package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupImportStatefulInstanceResponse {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             id;
    private String                                             groupId;
    private String                                             state;
    private ElastigroupImportStatefulInstanceDataResponse      data;

    public ElastigroupImportStatefulInstanceResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    public ElastigroupImportStatefulInstanceDataResponse getData() {
        return data;
    }

    public void setData(ElastigroupImportStatefulInstanceDataResponse data) {
        isSet.add("data");
        this.data = data;
    }

    public static class Builder {
        private ElastigroupImportStatefulInstanceResponse elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new ElastigroupImportStatefulInstanceResponse();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupImportStatefulInstanceResponse.Builder setId(final String id) {
            elastigroupGetDeploymentStatusInstances.setId(id);
            return this;
        }

        public ElastigroupImportStatefulInstanceResponse.Builder setGroupId(final String groupId) {
            elastigroupGetDeploymentStatusInstances.setGroupId(groupId);
            return this;
        }

        public ElastigroupImportStatefulInstanceResponse.Builder setState(final String state) {
            elastigroupGetDeploymentStatusInstances.setState(state);
            return this;
        }

        public Builder setData(final ElastigroupImportStatefulInstanceDataResponse data) {
            elastigroupGetDeploymentStatusInstances.setData(data);
            return this;
        }

        public ElastigroupImportStatefulInstanceResponse build() {
            return elastigroupGetDeploymentStatusInstances;
        }

    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

    @JsonIgnore
    public boolean isDataSet() {
        return isSet.contains("data");
    }

}
