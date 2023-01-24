package com.spotinst.sdkjava.model.converters.admin.account;

import com.spotinst.sdkjava.model.api.admin.account.*;
import com.spotinst.sdkjava.model.api.admin.organization.ApiPolicy;
import com.spotinst.sdkjava.model.api.admin.organization.ApiPolicyContent;
import com.spotinst.sdkjava.model.bl.admin.account.Account;
import com.spotinst.sdkjava.model.bl.admin.account.BlAccountAdmin;
import com.spotinst.sdkjava.model.bl.admin.account.Users;
import com.spotinst.sdkjava.model.bl.admin.account.UsersPermissions;
import com.spotinst.sdkjava.model.bl.admin.organization.Policy;
import com.spotinst.sdkjava.model.bl.admin.organization.PolicyContent;
import com.spotinst.sdkjava.model.bl.admin.organization.PolicyStatement;
import com.spotinst.sdkjava.model.converters.admin.organization.AdminOrganizationConverter;

import java.util.List;
import java.util.stream.Collectors;


public class AccountConverter {
    //region BL -> DAL
    public static ApiAccountAdmin toDal(BlAccountAdmin src) {
        ApiAccountAdmin retVal = null;

        if (src != null) {
            retVal = new ApiAccountAdmin();

            if (src.isNameSet()) {
                retVal.setName(src.getName());
            }

            if (src.isAccountIdSet()) {
                retVal.setAccountId(src.getAccountId());
            }

            if (src.isOrganizationIdSet()) {
                retVal.setOrganizationId(src.getOrganizationId());
            }

            if (src.isCloudProviderSet()) {
                retVal.setCloudProvider(src.getCloudProvider());
            }

            if (src.isProviderExternalIdSet()) {
                retVal.setProviderExternalId(src.getProviderExternalId());
            }
        }

        return retVal;
    }


    //endregion

    //region DAL -> BL
    public static BlAccountAdmin toBl(ApiAccountAdmin src) {
        BlAccountAdmin retVal = null;

        if (src != null) {
            BlAccountAdmin.Builder accountBuilder = BlAccountAdmin.Builder.get();

            if (src.isAccountIdSet()) {
                accountBuilder.setAccountId(src.getAccountId());
            }

            if (src.isNameSet()) {
                accountBuilder.setName(src.getName());
            }

            if (src.isOrganizationIdSet()) {
                accountBuilder.setOrganizationId(src.getOrganizationId());
            }

            if (src.isCloudProviderSet()) {
                accountBuilder.setCloudProvider(src.getCloudProvider());
            }

            if (src.isProviderExternalIdSet()) {
                accountBuilder.setProviderExternalId(src.getProviderExternalId());
            }

            retVal = accountBuilder.build();

        }

        return retVal;
    }
    //endregion

    //region DAL -> BL
    public static Users toBl(ApiUsers src) {
        Users retVal = null;

        if (src != null) {
            Users.Builder accountUserBuilder = Users.Builder.get();

            if (src.isDisplayNameSet()) {
                accountUserBuilder.setDisplayName(src.getDisplayName());
            }

            if (src.isEmailSet()) {
                accountUserBuilder.setEmail(src.getEmail());
            }

            if (src.isMappedAccountIdsSet()) {
                accountUserBuilder.setMappedAccountIds(src.getMappedAccountIds());
            }

            if (src.isUserIdSet()) {
                accountUserBuilder.setUserId(src.getUserId());
            }

            retVal = accountUserBuilder.build();

        }

        return retVal;
    }
    //endregion

    public static UsersPermissions toBl(ApiUsersPermissions src) {
        UsersPermissions retVal = null;

        if (src != null) {
            UsersPermissions.Builder accountUserBuilder = UsersPermissions.Builder.get();

            if (src.isPermissionStrategySet()) {
                accountUserBuilder.setPermissionStrategy(src.getPermissionStrategy());
            }

            if (src.isPolicyIdsSet()) {
                accountUserBuilder.setPolicyIds(src.getPolicyIds());
            }

            if (src.isRoleSet()) {
                accountUserBuilder.setRole(src.getRole());
            }

            if (src.isUserIdSet()) {
                accountUserBuilder.setUserId(src.getUserId());
            }

            retVal = accountUserBuilder.build();

        }

        return retVal;
    }

    public static Policy toBl(ApiPolicy src) {
        Policy retVal = null;

        if (src != null) {
            Policy.Builder accessPolicyBuilder = Policy.Builder.get();

            if (src.isCreatedAtSet()) {
                accessPolicyBuilder.setCreatedAt(src.getCreatedAt());
            }

            if (src.isDescriptionSet()) {
                accessPolicyBuilder.setDescription(src.getDescription());
            }

            if (src.isIdSet()) {
                accessPolicyBuilder.setId(src.getId());
            }

            if (src.isNameSet()) {
                accessPolicyBuilder.setName(src.getName());
            }

            if (src.isPolicyContentSet()) {
                accessPolicyBuilder.setPolicyContent(toBl(src.getPolicyContent()));
            }

            if (src.isUpdatedAtSet()) {
                accessPolicyBuilder.setUpdatedAt(src.getUpdatedAt());
            }

            retVal = accessPolicyBuilder.build();

        }

        return retVal;
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

    //region DAL -> BL
    public static Account toBl(ApiAccount src) {
        Account retVal = null;

        if (src != null) {
            Account.Builder accountBuilder = Account.Builder.get();

            if (src.isIdSet()) {
                accountBuilder.setId(src.getId());
            }

            if (src.isNameSet()) {
                accountBuilder.setName(src.getName());
            }

            if (src.isOrganizationIdSet()) {
                accountBuilder.setOrganizationId(src.getOrganizationId());
            }

            retVal = accountBuilder.build();

        }

        return retVal;
    }
    //endregion

}