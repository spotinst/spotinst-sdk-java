package com.spotinst.sdkjava.model.bl.admin.account;

import com.spotinst.sdkjava.model.api.admin.account.*;


public class AccountConverter {
    //region BL -> DAL
    public static ApiAccountAdmin toDal(BlAccountAdmin src) {
        ApiAccountAdmin retVal = null;

        if (src != null) {
            retVal = new ApiAccountAdmin();

            if (src.isNameSet()) {
                retVal.setName(src.getName());
            }

            if (src.isIdSet()) {
                retVal.setId(src.getId());
            }
            if (src.isOrganizationIdSet()) {
                retVal.setOrganizationId(src.getOrganizationId());
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