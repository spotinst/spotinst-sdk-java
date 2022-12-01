package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrganization {
    @JsonIgnore
    private Set<String>                    isSet;
    private Organization                   organization;

    public CreateOrganization() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        isSet.add("organization");
        this.organization = organization;
    }

    public static class Builder {
        private CreateOrganization programmaticUser;

        private Builder() {
            this.programmaticUser = new CreateOrganization();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOrganization(final Organization organization) {
            programmaticUser.setOrganization(organization);
            return this;
        }

        public CreateOrganization build() {
            return programmaticUser;
        }
    }
    @JsonIgnore
    public boolean isOrganizationSet() {
        return isSet.contains("organization");
    }
}