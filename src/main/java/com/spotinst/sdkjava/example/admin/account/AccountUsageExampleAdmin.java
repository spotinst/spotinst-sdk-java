package com.spotinst.sdkjava.example.admin.account;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import com.spotinst.sdkjava.model.requests.admin.account.AccountDeleteRequest;
import com.spotinst.sdkjava.model.requests.admin.account.ListAllAccountsRequest;
import com.spotinst.sdkjava.model.requests.admin.account.UpdateAccountRequest;

import java.util.*;
import java.io.IOException;

public class AccountUsageExampleAdmin {

    private final static String authToken = "your-token";

    public static void main(String[] args) throws IOException {
        // Get account service client
        SpotinstAccountAdminClient spotinstAccountAdminClient = SpotinstClient.getAdminAccountClient(authToken);

        // -------------------- Create account Example ---------------------------
        String accountNameToCreate = "your-account-to-create";
        String accountId = createAccount(spotinstAccountAdminClient, accountNameToCreate);

        System.out.println("Account Created with Account ID - " + accountId);

        // -------------------- Update account Example ---------------------------
        String accountNameToUpdate = "your-account-to-update";
        Boolean status = updateAccount(spotinstAccountAdminClient, accountNameToUpdate, accountId);

        if(status) {
            System.out.println("Account Successfully Updated");
        }
        else {
            System.out.println("Account Update Failed");
        }


        // -------------------- List all accounts Example ---------------------------
        String yourCloudAccountId = "you-cloud-account-id"; // This parameter can be Null, if all the accounts in the organization to be listed.
        List<BlAccountAdmin> accountList = listAllAccounts(spotinstAccountAdminClient, yourCloudAccountId);

        System.out.println("Total Accounts Found - " + accountList.size());

        // For loop for iterating over the List
        for (BlAccountAdmin account : accountList) {
            System.out.println("Account Id - " + account.getAccountId());
            System.out.println("Organization Id - " + account.getOrganizationId());
            System.out.println("Name - " + account.getName());
            System.out.println("Cloud Provider - " + account.getCloudProvider());
            System.out.println("Provider External Id - " + account.getProviderExternalId());
        }

        // -------------------- Delete account Example ---------------------------
        deleteAccount(spotinstAccountAdminClient, accountId);

    }

    private static String createAccount(SpotinstAccountAdminClient client, String accountName) {

        Account response = client.createAccount(accountName);

        return response.getId();
    }

    private static Boolean updateAccount(SpotinstAccountAdminClient client, String newAccountName, String accountToUpdate) {
        UpdateAccountRequest.Builder requestBuilder = UpdateAccountRequest.Builder.get();
        UpdateAccountRequest updateAccountsRequest = requestBuilder.setName(newAccountName).build();

        return client.updateAccount(updateAccountsRequest, accountToUpdate);
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



