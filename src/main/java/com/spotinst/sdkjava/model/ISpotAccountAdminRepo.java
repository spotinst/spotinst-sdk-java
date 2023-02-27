package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.account.*;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateAccountRequest;

import java.util.List;

public interface ISpotAccountAdminRepo extends IRepository<BlAccountAdmin, Void, String> {
    RepoGenericResponse<Account> create(String accountName, String authToken);

    RepoGenericResponse<Boolean> update(UpdateAccountRequest request, String authToken, String account);

    RepoGenericResponse<List<AuditLogEvents>> getAuditLogEvents(String authToken, String accountId, String fromDate, String toDate, String responseStatus);
}
