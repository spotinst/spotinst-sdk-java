package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgrammaticUserResponse {
    @JsonIgnore
    private Set<String> isSet;
    private String      token;
    private String      name;
    private String      id;

    public ProgrammaticUserResponse() {
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

    public static class Builder {
        private ProgrammaticUserResponse programmaticUserResponse;

        private Builder() {
            this.programmaticUserResponse = new ProgrammaticUserResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            programmaticUserResponse.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            programmaticUserResponse.setName(name);
            return this;
        }

        public Builder setToken(final String token) {
            programmaticUserResponse.setToken(token);
            return this;
        }

        public ProgrammaticUserResponse build() {
            return programmaticUserResponse;
        }
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