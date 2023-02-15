package com.spotinst.sdkjava.model.converters.admin.account;

import com.spotinst.sdkjava.model.ApiAuditEventLogs;
import com.spotinst.sdkjava.model.AuditEventLogs;
import com.spotinst.sdkjava.model.api.admin.account.*;
import com.spotinst.sdkjava.model.bl.admin.account.Account;
import com.spotinst.sdkjava.model.bl.admin.account.BlAccountAdmin;


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
    public static AuditEventLogs toBl(ApiAuditEventLogs src) {
        AuditEventLogs retVal = null;

        if (src != null) {
            AuditEventLogs.Builder eventsBuilder = AuditEventLogs.Builder.get();

            if (src.isActionTypeSet()) {
                eventsBuilder.setActionType(src.getActionType());
            }

            if (src.isAgentSet()) {
                eventsBuilder.setAgent(src.getAgent());
            }

            if (src.isContextSet()) {
                eventsBuilder.setContext(src.getContext());
            }

            if (src.isCreatedAtSet()) {
                eventsBuilder.setCreatedAt(src.getCreatedAt());
            }

            if (src.isNameSpaceSet()) {
                eventsBuilder.setNamespace(src.getNamespace());
            }

            if (src.isRecourceIdSet()) {
                eventsBuilder.setResourceId(src.getResourceId());
            }

            if (src.isResourceTypeSet()) {
                eventsBuilder.setResourceType(src.getResourceType());
            }

            if (src.isResponseStatusSet()) {
                eventsBuilder.setResponseStatus(src.getResponseStatus());
            }

            if (src.isSourceSet()) {
                eventsBuilder.setSource(src.getSource());
            }

            if (src.isUserSet()) {
                eventsBuilder.setUser(src.getUser());
            }

            retVal = eventsBuilder.build();

        }

        return retVal;
    }
    //endregion

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