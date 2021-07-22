package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import java.util.*;
import java.io.IOException;

public class AccountUsageExampleAdmin {

    private final static String authToken = "your-token";

    public static void main(String[] args) throws IOException {
        // Get account service client
        SpotinstAccountAdminClient spotinstAccountAdminClient = SpotinstClient.getAdminAccountClient(authToken);

        // -------------------- List all accounts Example ---------------------------
        String yourCloudAccountId = "you-cloud-account-id"; // This parameter can be Null, if all the accounts in the organization to be listed.
        List<BlAccountAdmin> accountList = listAllAccounts(spotinstAccountAdminClient, yourCloudAccountId);

        System.out.println("Total Accounts Found - " + accountList.size());

        // For loop for iterating over the List
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println("Account Id - " + accountList.get(i).getAccountId());
            System.out.println("Organization Id - " + accountList.get(i).getOrganizationId());
            System.out.println("Name - " + accountList.get(i).getName());
            System.out.println("Cloud Provider - " + accountList.get(i).getCloudProvider());
            System.out.println("Provider External Id - " + accountList.get(i).getProviderExternalId());
        }

        // -------------------- Delete account Example ---------------------------
        String accountIdToDelete = "you-account-id-to-delete";
        deleteAccount(spotinstAccountAdminClient, accountIdToDelete);

    }

    private static List<BlAccountAdmin> listAllAccounts(SpotinstAccountAdminClient client, String cloudAccountId) {
        ListAllAccountsRequest.Builder listAccountsBuilder = ListAllAccountsRequest.Builder.get();
        ListAllAccountsRequest listAccountsRequest = listAccountsBuilder.setCloudAccountId(cloudAccountId).build();

        return client.listAllAccounts(listAccountsRequest);
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



