package com.spotinst.sdkjava.model.api.admin.organization;

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
public class ApiProgrammaticUserResponse implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      token;
    private String      name;
    private String      id;

    public ApiProgrammaticUserResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        isSet.add("token");
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isTokenSet() {
        return isSet.contains("token");
    }

}
