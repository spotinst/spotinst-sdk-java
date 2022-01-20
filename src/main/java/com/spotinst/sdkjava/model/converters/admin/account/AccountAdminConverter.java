package com.spotinst.sdkjava.model.converters.admin.account;

import com.spotinst.sdkjava.model.api.admin.account.*;
import com.spotinst.sdkjava.model.bl.admin.account.*;

import java.util.List;
import java.util.stream.Collectors;

public class AccountAdminConverter {

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

    public static ApiUpdateUserDirectPoliciesRequest toDal(UpdateUserDirectPoliciesRequest src) {
        ApiUpdateUserDirectPoliciesRequest apiPoliciesRequest = null;

        if (src != null) {
            apiPoliciesRequest = new ApiUpdateUserDirectPoliciesRequest();

            if (src.isPoliciesSet()) {
                List<ApiUserDirectPolicies> policies =
                        src.getPolicies().stream().map(AccountAdminConverter::toDal).collect(Collectors.toList());
                apiPoliciesRequest.setPolicies(policies);
            }
         }

        return apiPoliciesRequest;
    }

    public static ApiUserDirectPolicies toDal(UserDirectPolicies src) {
        ApiUserDirectPolicies apiPolicies = null;

        if(src != null) {
            apiPolicies = new ApiUserDirectPolicies();

            if(src.isPolicyIdSet()) {
                apiPolicies.setPolicyId(src.getPolicyId());
            }
            if(src.isAccountIdsSet()) {
                apiPolicies.setAccountIds(src.getAccountIds());
            }
        }
        return apiPolicies;
    }

    public static ApiPolicyStatements toDal(PolicyStatements src) {
        ApiPolicyStatements statements = null;

        if(src != null) {
            statements = new ApiPolicyStatements();

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
                List<ApiPolicyStatements> statements =
                        src.getStatements().stream().map(AccountAdminConverter::toDal).collect(Collectors.toList());
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
                List<UserPolicies> userPoliciesList =
                        src.getPolicies().stream().map(AccountAdminConverter::toBl).collect(Collectors.toList());
                userDetails.setPolicies(userPoliciesList);
            }
            if (src.isTokensSet()) {
                List<UserTokens> userTokensList =
                        src.getTokens().stream().map(AccountAdminConverter::toBl).collect(Collectors.toList());
                userDetails.setTokens(userTokensList);
            }
            if(src.isGroupsSet()) {
                List<UserDetailsGroups> groupNames =
                        src.getGroups().stream().map(AccountAdminConverter::toBl).collect(Collectors.toList());
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
    
    public static UserPolicies toBl(ApiUserPolicies src) {
        UserPolicies userPolicies = null;

        if (src != null) {
            userPolicies = new UserPolicies();

            if (src.isPolicyIdSet()) {
                userPolicies.setPolicyId(src.getPolicyId());
            }
            if (src.isPolicyNameSet()) {
                userPolicies.setPolicyName(src.getPolicyName());
            }
            if (src.isPolicyTypeSet()) {
                userPolicies.setPolicyType(src.getPolicyType());
            }
            if (src.isUserGroupIdsSet()) {
                userPolicies.setUserGroupIds(src.getUserGroupIds());
            }
            if (src.isAccountIdsSet()) {
                userPolicies.setAccountIds(src.getAccountIds());
            }
        }
        return userPolicies;
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

    public static ApiUserPolicies toDal(UserPolicies src) {
        ApiUserPolicies policies = null;

        if (src != null) {
            policies = new ApiUserPolicies();

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

    public static UserTokens toBl(ApiUserTokens src) {
        UserTokens userTokens = null;

        if (src != null) {
            userTokens = new UserTokens();

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
                List<ApiUserPolicies> policiesList =
                        src.getPolicies().stream().map(AccountAdminConverter::toDal).collect(Collectors.toList());
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

    public static PolicyStatements toBl(ApiPolicyStatements src) {
        PolicyStatements statements = null;

        if(src != null) {
            statements = new PolicyStatements();

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
                List<PolicyStatements> statements =
                        src.getStatements().stream().map(AccountAdminConverter::toBl).collect(Collectors.toList());
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
}