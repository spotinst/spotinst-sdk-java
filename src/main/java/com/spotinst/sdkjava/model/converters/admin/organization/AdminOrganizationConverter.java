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
            if (src.isIdSet()) {
                apiUser.setId(src.getId());
            }
            if (src.isOrganizationIdSet()) {
                apiUser.setOrganizationId(src.getOrganizationId());
            }
            if (src.isUserIdSet()) {
                apiUser.setUserId(src.getUserId());
            }
        }
        return apiUser;
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

    public static ApiPolicyStatement toDal(PolicyStatement src) {
        ApiPolicyStatement statements = null;

        if(src != null) {
            statements = new ApiPolicyStatement();

            if (src.isEffectSet()) {
                statements.setEffect(src.getEffect());
            }
            if (src.isActionsSet()) {
                statements.setActions(src.getActions());
            }
            if (src.isResourcesSet()) {
                statements.setResources(src.getResources());
            }
        }
        return statements;
    }

    public static ApiPolicyContent toDal(PolicyContent src) {
        ApiPolicyContent policyContent = null;

        if (src != null) {
            policyContent = new ApiPolicyContent();

            if (src.isStatementSet()) {
                List<ApiPolicyStatement> statements =
                        src.getStatements().stream().map(AdminOrganizationConverter::toDal).collect(Collectors.toList());
                policyContent.setStatements(statements);
            }
        }
        return policyContent;
    }

    public static ApiPolicy toDal(Policy src) {
        ApiPolicy policy = null;

        if (src != null) {
            policy = new ApiPolicy();

            if (src.isPolicyContentSet()) {
                policy.setPolicyContent(toDal(src.getPolicyContent()));
            }
            if (src.isIdSet()) {
                policy.setId(src.getId());
            }
            if (src.isNameSet()) {
                policy.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                policy.setDescription(src.getDescription());
            }
            if (src.isTypeSet()) {
                policy.setType(src.getType());
            }
            if (src.isCreatedAtSet()) {
                policy.setCreatedAt(src.getCreatedAt());
            }
            if (src.isUpdatedAtSet()) {
                policy.setUpdatedAt(src.getUpdatedAt());
            }
        }
        return policy;
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
            if (src.isUserIdSet()) {
                user.setUserId(src.getUserId());
            }
        }
        return user;
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
            if (src.isDescriptionSet()) {
                userDetails.setDescription(src.getDescription());
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

    public static ApiUserDetailsPolicy toDal(UserDetailsPolicy src) {
        ApiUserDetailsPolicy policies = null;

        if (src != null) {
            policies = new ApiUserDetailsPolicy();

            if (src.isPolicyIdSet()) {
                policies.setPolicyId(src.getPolicyId());
            }
            if (src.isPolicyNameSet()) {
                policies.setPolicyName(src.getPolicyName());
            }
            if (src.isPolicyTypeSet()) {
                policies.setPolicyType(src.getPolicyType());
            }
            if (src.isAccountIdsSet()) {
                policies.setAccountIds(src.getAccountIds());
            }
            if (src.isUserGroupIdsSet()) {
                policies.setUserGroupIds(src.getUserGroupIds());
            }
        }
        return policies;
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

    public static ApiProgrammaticUser toDal(ProgrammaticUser src) {
        ApiProgrammaticUser apiProgrammaticUser = null;

        if (src != null) {
            apiProgrammaticUser = new ApiProgrammaticUser();

            if (src.isNameSet()) {
                apiProgrammaticUser.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                apiProgrammaticUser.setDescription(src.getDescription());
            }
            if (src.isPoliciesSet()) {
                List<ApiUserDetailsPolicy> policiesList =
                        src.getPolicies().stream().map(AdminOrganizationConverter::toDal).collect(Collectors.toList());
                apiProgrammaticUser.setPolicies(policiesList);
            }
        }
        return apiProgrammaticUser;
    }

    public static ProgrammaticUserResponse toBl(ApiProgrammaticUserResponse src) {
        ProgrammaticUserResponse ProgrammeticUser = null;

        if (src != null) {
            ProgrammeticUser = new ProgrammaticUserResponse();

            if (src.isIdSet()) {
                ProgrammeticUser.setId(src.getId());
            }
            if (src.isNameSet()) {
                ProgrammeticUser.setName(src.getName());
            }
            if (src.isTokenSet()) {
                ProgrammeticUser.setToken(src.getToken());
            }
        }
        return ProgrammeticUser;
    }

    public static PolicyStatement toBl(ApiPolicyStatement src) {
        PolicyStatement statements = null;

        if(src != null) {
            statements = new PolicyStatement();

            if (src.isEffectSet()) {
                statements.setEffect(src.getEffect());
            }
            if (src.isActionsSet()) {
                statements.setActions(src.getActions());
            }
            if (src.isResourcesSet()) {
                statements.setResources(src.getResources());
            }
        }
        return statements;
    }

    public static PolicyContent toBl(ApiPolicyContent src) {
        PolicyContent policyContent = null;

        if (src != null) {
            policyContent = new PolicyContent();

            if (src.isStatementSet()) {
                List<PolicyStatement> statements =
                        src.getStatements().stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());
                policyContent.setStatements(statements);
            }
        }
        return policyContent;
    }

    public static Policy toBl(ApiPolicy src) {
        Policy policy = null;

        if (src != null) {
            policy = new Policy();

            if (src.isPolicyContentSet()) {
                policy.setPolicyContent(toBl(src.getPolicyContent()));
            }
            if (src.isIdSet()) {
                policy.setId(src.getId());
            }
            if (src.isNameSet()) {
                policy.setName(src.getName());
            }
            if (src.isDescriptionSet()) {
                policy.setDescription(src.getDescription());
            }
            if (src.isTypeSet()) {
                policy.setType(src.getType());
            }
            if (src.isCreatedAtSet()) {
                policy.setCreatedAt(src.getCreatedAt());
            }
            if (src.isUpdatedAtSet()) {
                policy.setUpdatedAt(src.getUpdatedAt());
            }
        }
        return policy;
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
}