package com.spotinst.sdkjava.model.api.admin.messageCenter;

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
public class ApiUsersAudienceSpecification implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private Long  organizationId;
    private List<Long> userIds;
    //endregion

    //region Constructor
    public ApiUsersAudienceSpecification() {
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
