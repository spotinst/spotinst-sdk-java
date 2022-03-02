package com.spotinst.sdkjava.model.api.admin.account;

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
public class ApiProgrammaticUser implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>         isSet;
    private String              name;
    private String              description;
    private List<ApiUserPolicy> policies;

    public ApiProgrammaticUser() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public List<ApiUserPolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<ApiUserPolicy> policies) {
        isSet.add("policies");
        this.policies = policies;
    }
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isPoliciesSet() {
        return isSet.contains("policies");
    }
}
