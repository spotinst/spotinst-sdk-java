package com.spotinst.sdkjava.model.converters.admin.organization;

import com.spotinst.sdkjava.model.api.admin.organization.*;
import com.spotinst.sdkjava.model.bl.admin.organization.*;

import java.util.List;
import java.util.stream.Collectors;

public class AdminOrganizationConverter {

    public static ApiUser toDal(User src) {
        ApiUser apiUser = null;

        if (src != null) {
            apiUser = new ApiUser();

            if (src.isFirstNameSet()) {
                apiUser.setFirstName(src.getFirstName());
            }
            if (src.isLastNameSet()) {
                apiUser.setLastName(src.getLastName());
            }
            if (src.isEmailSet()) {
                apiUser.setEmail(src.getEmail());
            }
            if (src.isPasswordSet()) {
                apiUser.setPassword(src.getPassword());
            }
            if (src.isRoleSet()) {
                apiUser.setRole(src.getRole());
            }
        }
        return apiUser;
    }

    public static ApiPolicyMapping toDal(PolicyMapping src) {
        ApiPolicyMapping apiPolicies = null;

        if(src != null) {
            apiPolicies = new ApiPolicyMapping();

            if(src.isPolicyIdSet()) {
                apiPolicies.setPolicyId(src.getPolicyId());
            }
            if(src.isAccountIdsSet()) {
                apiPolicies.setAccountIds(src.getAccountIds());
            }
        }
        return apiPolicies;
    }

    public static ApiUpdatePoliciesRequest toDal(UpdatePoliciesRequest src) {
        ApiUpdatePoliciesRequest apiPoliciesRequest = null;

        if (src != null) {
            apiPoliciesRequest = new ApiUpdatePoliciesRequest();

            if (src.isPoliciesSet()) {
                List<ApiPolicyMapping> policies =
                        src.getPolicies().stream().map(AdminOrganizationConverter::toDal).collect(Collectors.toList());
                apiPoliciesRequest.setPolicies(policies);
            }
        }

        return apiPoliciesRequest;
    }

    public static ApiUserGroup toDal(UserGroup src) {
        ApiUserGroup userGroup = null;

        if (src != null) {
            userGroup = new ApiUserGroup();

            if (src.isIdSet()) {
                userGroup.setId(src.getId());
            }
            if (src.isNameSet()) {
                userGroup.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                userGroup.setDescription(src.getDescription());
            }
            if (src.isUserIdsSet()) {
                userGroup.setUserIds(src.getUserIds());
            }
            if (src.isPoliciesSet()&& src.getPolicies()!=null ) {
                List<ApiPolicyMapping> groupPolicies =
                        src.getPolicies().stream().map(AdminOrganizationConverter::toDal).collect(Collectors.toList());
                userGroup.setPolicies(groupPolicies);
            }
        }
        return userGroup;
    }

    public static User toBl(ApiUser src) {
        User user = null;

        if (src != null) {
            user = new User();

            if (src.isFirstNameSet()) {
                user.setFirstName(src.getFirstName());
            }
            if (src.isLastNameSet()) {
                user.setLastName(src.getLastName());
            }
            if (src.isEmailSet()) {
                user.setEmail(src.getEmail());
            }
            if (src.isPasswordSet()) {
                user.setPassword(src.getPassword());
            }
            if (src.isIdSet()) {
                user.setId(src.getId());
            }
            if (src.isOrganizationIdSet()) {
                user.setOrganizationId(src.getOrganizationId());
            }
            if (src.isDisplayNameSet()) {
                user.setDisplayName(src.getDisplayName());
            }
            if (src.isPersonalAccessTokenSet()) {
                user.setPersonalAccessToken(src.getPersonalAccessToken());
            }
            if (src.isUserIdSet()) {
                user.setUserId(src.getUserId());
            }
        }
        return user;
    }

    public static OrganizationUsers toBl(ApiOrganizationUsers src) {
        OrganizationUsers orgUsers = null;

        if (src != null) {
            orgUsers = new OrganizationUsers();

            if (src.isUserIdSet()) {
                orgUsers.setUserId(src.getUserId());
            }
            if (src.isUserNameSet()) {
                orgUsers.setUsername(src.getUsername());
            }
            if (src.isMfaSet()) {
                orgUsers.setMfa(src.getMfa());
            }
            if (src.isTypeSet()) {
                orgUsers.setType(src.getType());
            }
            if (src.isEmailSet()) {
                orgUsers.setEmail(src.getEmail());
            }
            if (src.isGroupNamesSet()) {
                orgUsers.setGroupNames(src.getGroupNames());
            }
        }
        return orgUsers;
    }

    public static UserDetails toBl(ApiUserDetails src) {
        UserDetails userDetails = null;

        if (src != null) {
            userDetails = new UserDetails();

            if (src.isUserIdSet()) {
                userDetails.setUserId(src.getUserId());
            }
            if (src.isUserNameSet()) {
                userDetails.setUsername(src.getUsername());
            }
            if (src.isMfaSet()) {
                userDetails.setMfa(src.getMfa());
            }
            if (src.isTypeSet()) {
                userDetails.setType(src.getType());
            }
            if (src.isEmailSet()) {
                userDetails.setEmail(src.getEmail());
            }
            if (src.isPoliciesSet()) {
                List<UserDetailsPolicy> userPolicyList =
                        src.getPolicies().stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());
                userDetails.setPolicies(userPolicyList);
            }
            if (src.isTokensSet()) {
                List<UserDetailsTokens> userTokensList =
                        src.getTokens().stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());
                userDetails.setTokens(userTokensList);
            }
            if(src.isGroupsSet()) {
                List<UserDetailsGroups> groupNames =
                        src.getGroups().stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());
                userDetails.setGroups(groupNames);
            }
        }
        return userDetails;
    }

    public static UserDetailsPolicy toBl(ApiUserDetailsPolicy src) {
        UserDetailsPolicy userPolicy = null;

        if (src != null) {
            userPolicy = new UserDetailsPolicy();

            if (src.isPolicyIdSet()) {
                userPolicy.setPolicyId(src.getPolicyId());
            }
            if (src.isPolicyNameSet()) {
                userPolicy.setPolicyName(src.getPolicyName());
            }
            if (src.isPolicyTypeSet()) {
                userPolicy.setPolicyType(src.getPolicyType());
            }
            if (src.isUserGroupIdsSet()) {
                userPolicy.setUserGroupIds(src.getUserGroupIds());
            }
            if (src.isAccountIdsSet()) {
                userPolicy.setAccountIds(src.getAccountIds());
            }
        }
        return userPolicy;
    }

    public static UserDetailsGroups toBl(ApiUserDetailsGroups src) {
        UserDetailsGroups groups = null;

        if (src != null) {
            groups = new UserDetailsGroups();

            if (src.isIdSet()) {
                groups.setId(src.getId());
            }
            if (src.isNameSet()) {
                groups.setName(src.getName());
            }
            if (src.isPolicyNamesSet()) {
                groups.setPolicyNames(src.getPolicyNames());
            }
        }
        return groups;
    }

    public static UserDetailsTokens toBl(ApiUserDetailsTokens src) {
        UserDetailsTokens userTokens = null;

        if (src != null) {
            userTokens = new UserDetailsTokens();

            if (src.isNameSet()) {
                userTokens.setName(src.getName());
            }
            if (src.isCreatedAtSet()) {
                userTokens.setCreatedAt(src.getCreatedAt());
            }
            if (src.isTokenIdSet()) {
                userTokens.setTokenId(src.getTokenId());
            }
            if (src.isTokenLastDigitsSet()) {
                userTokens.setTokenLastDigits(src.getTokenLastDigits());
            }
        }
        return userTokens;
    }

    public static PolicyMapping toBl(ApiPolicyMapping src) {
        PolicyMapping policies = null;

        if(src != null) {
            policies = new PolicyMapping();

            if(src.isPolicyIdSet()) {
                policies.setPolicyId(src.getPolicyId());
            }
            if(src.isAccountIdsSet()) {
                policies.setAccountIds(src.getAccountIds());
            }
        }
        return policies;
    }

    public static UserGroup toBl(ApiUserGroup src) {
        UserGroup userGroup = null;

        if (src != null) {
            userGroup = new UserGroup();

            if (src.isIdSet()) {
                userGroup.setId(src.getId());
            }
            if (src.isNameSet()) {
                userGroup.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                userGroup.setDescription(src.getDescription());
            }
            if (src.isUserIdsSet()) {
                userGroup.setUserIds(src.getUserIds());
            }
            if (src.isPoliciesSet() && src.getPolicies()!=null ) {
                List<PolicyMapping> userGroupMappedPolicies =
                        src.getPolicies().stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());
                userGroup.setPolicies(userGroupMappedPolicies);
            }
        }
        return userGroup;
    }

    public static OrganizationUserGroups toBl(ApiOrganizationUserGroups src) {
        OrganizationUserGroups groupDetails = null;

        if (src != null) {
            groupDetails = new OrganizationUserGroups();

            if (src.isIdSet()) {
                groupDetails.setId(src.getId());
            }
            if (src.isNameSet()) {
                groupDetails.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                groupDetails.setDescription(src.getDescription());
            }
            if (src.isCreatedAtSet()) {
                groupDetails.setCreatedAt(src.getCreatedAt());
            }
            if (src.isUsersCountSet()) {
                groupDetails.setUsersCount(src.getUsersCount());
            }

            if (src.isPolicyNamesSet()) {
                groupDetails.setPolicyNames(src.getPolicyNames());
            }
        }
        return groupDetails;
    }

    public static UserGroupDetailsUsers toBl(ApiUserGroupDetailsUsers src) {
        UserGroupDetailsUsers users = null;

        if (src != null) {
            users = new UserGroupDetailsUsers();

            if (src.isUserIdSet()) {
                users.setUserId(src.getUserId());
            }
            if (src.isUserNameSet()) {
                users.setUsername(src.getUsername());
            }
            if (src.isTypeSet()) {
                users.setType(src.getType());
            }
        }
        return users;
    }

    public static UserGroupDetailsPolicies toBl(ApiUserGroupDetailsPolicies src) {
        UserGroupDetailsPolicies policies = null;

        if (src != null) {
            policies = new UserGroupDetailsPolicies();

            if (src.isPolicyIdSet()) {
                policies.setPolicyId(src.getPolicyId());
            }
            if (src.isPolicyNameSet()) {
                policies.setPolicyName(src.getPolicyName());
            }
            if (src.isPolicyTypeSet()) {
                policies.setPolicyType(src.getPolicyType());
            }
            if(src.isAccountIdsSet()) {
                policies.setAccountIds(src.getAccountIds());
            }
        }
        return policies;
    }

    public static UserGroupDetails toBl(ApiUserGroupDetails src) {
        UserGroupDetails groupDetails = null;

        if (src != null) {
            groupDetails = new UserGroupDetails();

            if (src.isIdSet()) {
                groupDetails.setId(src.getId());
            }
            if (src.isNameSet()) {
                groupDetails.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                groupDetails.setDescription(src.getDescription());
            }
            if (src.isCreatedAtSet()) {
                groupDetails.setCreatedAt(src.getCreatedAt());
            }
            if (src.isUsersSet()) {
                List<UserGroupDetailsUsers> users =
                        src.getUsers().stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());
                groupDetails.setUsers(users);
            }

            if (src.isPoliciesSet()) {
                List<UserGroupDetailsPolicies> policies =
                        src.getPolicies().stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());
                groupDetails.setPolicies(policies);
            }
        }
        return groupDetails;
    }
}