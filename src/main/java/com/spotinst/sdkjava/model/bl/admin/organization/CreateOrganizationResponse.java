package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrganizationResponse {
    @JsonIgnore
    private Set<String>                    isSet;
    private String                            organizationId;
    private String                            organizationName;

    public CreateOrganizationResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        isSet.add("organizationId");
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        isSet.add("organizationName");
        this.organizationName = organizationName;
    }

    public static class Builder {
        private CreateOrganizationResponse organization;

        private Builder() {
            this.organization = new CreateOrganizationResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setOrganizationName(final String organizationName) {
            organization.setOrganizationName(organizationName);
            return this;
        }

        public Builder setOrganizationId(final String organizationId) {
            organization.setOrganizationId(organizationId);
            return this;
        }

        public CreateOrganizationResponse build() {
            return organization;
        }
    }

    @JsonIgnore
    public boolean isOrganizationIdSet() {
        return isSet.contains("organizationId");
    }

    @JsonIgnore
    public boolean isOrganizationNameSet() {
        return isSet.contains("organizationName");
    }
}