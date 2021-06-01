package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.admin.account.AccountDeleteRequest;

import java.io.IOException;

public class AccountUsageExampleAdmin {

    // TODO or: use caps in Java
    private final static String auth_token = "your-token";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstAdminAccountClient spotinstAccountAdminClient = SpotinstClient.getAdminAccountClient(auth_token);

        // Delete elastigroup
        String accountIdToDelete = "your-account-id-to-delete";
        deleteAccount(spotinstAccountAdminClient, accountIdToDelete);
    }

    private static void deleteAccount(SpotinstAdminAccountClient client, String accountIdToDelete) {
        AccountDeleteRequest.Builder deletionBuilder = AccountDeleteRequest.Builder.get();
        AccountDeleteRequest        deletionRequest =
                deletionBuilder.setAccountId(accountIdToDelete).build();
        Boolean successfulDeletion = client.deleteAccount(deletionRequest);

        if (successfulDeletion) {
            System.out.println("Account successfully deleted: " + accountIdToDelete);
        }
    }

}



