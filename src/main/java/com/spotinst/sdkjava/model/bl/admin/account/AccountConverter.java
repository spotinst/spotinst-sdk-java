package com.spotinst.sdkjava.model.bl.admin.account;

import com.spotinst.sdkjava.model.api.admin.account.*;


public class AccountConverter {
    //region BL -> DAL
    public static ApiAdminAccount toDal(BlAdminAccount src) {
        ApiAdminAccount retVal = null;

        if (src != null) {
            retVal = new ApiAdminAccount();

            if (src.isNameSet()) {
                retVal.setName(src.getName());
            }

            if (src.isIdSet()) {
                retVal.setId(src.getId());
            }

        }

        return retVal;
    }


    //endregion

    //region DAL -> BL
    public static BlAdminAccount toBl(ApiAdminAccount src) {
        BlAdminAccount retVal = null;

        if (src != null) {
            BlAdminAccount.Builder accountBuilder = BlAdminAccount.Builder.get();

            if (src.isIdSet()) {
                accountBuilder.setId(src.getId());
            }

            if (src.isNameSet()) {
                accountBuilder.setName(src.getName());
            }

            retVal = accountBuilder.build();

        }

        return retVal;
    }
    //endregion
}