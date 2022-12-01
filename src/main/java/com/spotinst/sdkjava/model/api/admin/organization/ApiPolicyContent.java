package com.spotinst.sdkjava.model.api.admin.organization;

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
public class ApiPolicyContent implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>              isSet;
    private List<ApiPolicyStatement> statements;

    public ApiPolicyContent() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiPolicyStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<ApiPolicyStatement> statements) {
        isSet.add("statements");
        this.statements = statements;
    }

    @JsonIgnore
    public boolean isStatementSet() {
        return isSet.contains("statements");
    }
}