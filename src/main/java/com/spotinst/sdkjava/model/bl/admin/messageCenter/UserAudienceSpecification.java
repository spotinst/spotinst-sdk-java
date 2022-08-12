package com.spotinst.sdkjava.model.bl.admin.messageCenter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAudienceSpecification {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Long  organizationId;
    private List<Long> userIds;
    //endregion

    //region Constructor
    public UserAudienceSpecification() {
        isSet = new HashSet<>();
    }
    //endregion

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        isSet.add("organizationId");
        this.organizationId = organizationId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        isSet.add("userIds");
        this.userIds = userIds;
    }

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private UserAudienceSpecification userOrganizationMapping;

        private Builder() {
            this.userOrganizationMapping = new UserAudienceSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setOrganizationId(final Long organizationId) {
            userOrganizationMapping.setOrganizationId(organizationId);
            return this;
        }

        public Builder setUserIds(final List<Long> userIds) {
            userOrganizationMapping.setUserIds(userIds);
            return this;
        }

        public UserAudienceSpecification build() {
            return userOrganizationMapping;
        }
    }
    //endregion

    //region isSet methods
    // Is organizationId Set boolean method
    @JsonIgnore
    public boolean isOrganizationIdSet() {
        return isSet.contains("organizationId");
    }

    // Is userIds Set boolean method
    @JsonIgnore
    public boolean isUserIdsSet() {
        return isSet.contains("userIds");
    }

    //endregion
}
