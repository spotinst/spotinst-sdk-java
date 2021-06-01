package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.admin.account.AccountDeleteRequest;

import java.io.IOException;

public class AccountUsageExampleAdmin {

    private final static String authToken = "your-token";

    public static void main(String[] args) throws IOException {
        // Get account service client
        SpotinstAccountAdminClient spotinstAccountAdminClient = SpotinstClient.getAdminAccountClient(authToken);

        // Delete account
        String accountIdToDelete = "your-account-id-to-delete";
        deleteAccount(spotinstAccountAdminClient, accountIdToDelete);
    }

    private static void deleteAccount(SpotinstAccountAdminClient client, String accountIdToDelete) {
        AccountDeleteRequest.Builder deletionBuilder = AccountDeleteRequest.Builder.get();
        AccountDeleteRequest        deletionRequest =
                deletionBuilder.setAccountId(accountIdToDelete).build();
        Boolean successfulDeletion = client.deleteAccount(deletionRequest);

        if (successfulDeletion) {
            System.out.println("Account successfully deleted: " + accountIdToDelete);
        }
    }

}



