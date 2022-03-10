package com.spotinst.sdkjava.model.api.ocean.kubernetes;

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
public class ApiK8sClusterFetchElastilogResponse implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                        isSet;
    private String                                             message;
    private String                                             severity;
    private String                                             createdAt;

    public ApiK8sClusterFetchElastilogResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        isSet.add("message");
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        isSet.add("severity");
        this.severity = severity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    @JsonIgnore
    public boolean isMessageSet() {
        return isSet.contains("message");
    }

    @JsonIgnore
    public boolean isSeveritySet() {
        return isSet.contains("severity");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }


}