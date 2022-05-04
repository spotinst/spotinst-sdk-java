package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsGroups {
    @JsonIgnore
    private Set<String>  isSet;
    private String       id;
    private String       name;
    private List<String> policyNames;

    public UserDetailsGroups() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public List<String> getPolicyNames() {
        return policyNames;
    }

    public void setPolicyNames(List<String> policyNames) {
        isSet.add("policyNames");
        this.policyNames = policyNames;
    }

    public static class Builder {
        private UserDetailsGroups groups;

        private Builder() {
            this.groups = new UserDetailsGroups();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            groups.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            groups.setName(name);
            return this;
        }

        public Builder setPolicies(final List<String> policies) {
            groups.setPolicyNames(policies);
            return this;
        }

        public UserDetailsGroups build() {
            return groups;
        }
    }
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isPolicyNamesSet() {
        return isSet.contains("policyNames");
    }
}