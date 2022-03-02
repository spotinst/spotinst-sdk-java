package com.spotinst.sdkjava.model.bl.admin.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgrammaticUser {
    @JsonIgnore
    private Set<String>      isSet;
    private String           name;
    private String           description;
    private List<UserPolicy> policies;

    public ProgrammaticUser() {
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

    public List<UserPolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<UserPolicy> policies) {
        isSet.add("policies");
        this.policies = policies;
    }

    public static class Builder {
        private ProgrammaticUser programmaticUser;

        private Builder() {
            this.programmaticUser = new ProgrammaticUser();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            programmaticUser.setName(name);
            return this;
        }

        public Builder setDescription(final String description) {
            programmaticUser.setDescription(description);
            return this;
        }

        public Builder setPolicies(final List<UserPolicy> policies) {
            programmaticUser.setPolicies(policies);
            return this;
        }

        public ProgrammaticUser build() {
            return programmaticUser;
        }
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
