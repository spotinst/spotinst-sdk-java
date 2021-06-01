package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.admin.account.AccountDeleteRequest;

import java.io.IOException;

public class AccountUsageExampleAdmin {

    // TODO or: use camelCase in Java - Done
    private final static String auth_token = "your-token";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        // TODO or: as we talked, SpotinstAdminClient - Done
        SpotinstAdminAccountClient SpotinstAdminClient = SpotinstClient.getAdminAccountClient(auth_token);

        // Delete elastigroup
        String accountIdToDelete = "your-account-id-to-delete";
        // TODO or: for better example, return boolean, and then print. - false cant be achived
        deleteAccount(SpotinstAdminClient, accountIdToDelete);
    }

    private static void deleteAccount(SpotinstAdminAccountClient client, String accountIdToDelete) {
        AccountDeleteRequest.Builder deletionBuilder = AccountDeleteRequest.Builder.get();
        AccountDeleteRequest        deletionRequest =
                deletionBuilder.setAccountId(accountIdToDelete).build();
        Boolean successfulDeletion = client.deleteAccount(deletionRequest);

        if (successfulDeletion) {
            System.out.println("Account succesfully deleted: " + accountIdToDelete);
        }
    }

    // TODO or: remove -DONE (sleep was here)
}



