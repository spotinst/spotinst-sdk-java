package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.admin.account.AccountDeleteRequest;

import java.io.IOException;

public class AccountUsageExampleAdmin {

    private final static String auth_token = "Your-Token";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstAdminAccountClient adminAccountClient = SpotinstClient.getAdminAccountClient(auth_token);

        // Delete elastigroup
        String accountIdToDelete = "Your-Account-Id-To-Delete";
        deleteAccount(adminAccountClient, accountIdToDelete);
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

    private static void sleep(Integer seconds) {
        for (Integer i = 0; i < seconds; i++) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((i % 5) == 0 && i > 0) {
                System.out.println(i + " seconds have passed.\n");
            }
        }

    }
}



