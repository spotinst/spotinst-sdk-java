package com.spotinst.sdkjava.example.admin.account;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.admin.account.PolicyEffectEnum;
import com.spotinst.sdkjava.enums.admin.account.PolicyTypeEnum;
import com.spotinst.sdkjava.model.SpotinstAccountAdminClient;
import com.spotinst.sdkjava.model.bl.admin.account.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserManagementUsageExample {
    private final static String authToken    = "ddece2cb5e456f497b46cecc0888ceb97e8ab9932908387ea2d10adb2941d21a";
    private final static String accountId        = "act-55f2b053";

    public static void main(String[] args) {
        SpotinstAccountAdminClient adminClient = SpotinstClient.getAdminAccountClient(authToken,accountId);

        //createUser(adminClient);
        //u-aafa966c
        //pu-a6b9a607
        //getUserDetails(adminClient,"u-ff653112");
        //createProgammaticUser(adminClient);
        //getOrganizationUsers(adminClient);
        //updateGroupsofUsers(adminClient);

        //updateUserDirectPolicies(adminClient);
        //createPolicy(adminClient);
        //updatePolicy("pol-24afa8c3",adminClient);
        deletePolicy("pol-24afa8c3",adminClient);
        //getAllPolicies(adminClient);
    }

    private static String createUser(SpotinstAccountAdminClient adminClient) {
        // Build user
        User.Builder userBuilder = User.Builder.get();
        User userRequest = userBuilder.setFirstName("abc").setLastName("123").setEmail("abc@gmail.com").setPassword("Suganya1!").build();
        User userResponse = adminClient.createUser(userRequest);
        return userResponse.getUserId();
    }

    private static void getUserDetails(SpotinstAccountAdminClient adminClient,String userId) {
        // Build user
        UserDetails userDetails = adminClient.getUserDetails(userId);
        System.out.println(String.format("userName: %s",userDetails.getUsername()));
        System.out.println(String.format("type: %s",userDetails.getType()));
        System.out.println(String.format("mfa: %s",userDetails.getMfa()));
    }

    private static String createProgammaticUser(SpotinstAccountAdminClient adminClient) {
        UserPolicies.Builder policiesBuilder  = UserPolicies.Builder.get();
        UserPolicies         userPolicies     = policiesBuilder.setPolicyId("4").build();
        List<UserPolicies>   userPoliciesList = Collections.singletonList(userPolicies);

        ProgrammaticUser.Builder userBuilder = ProgrammaticUser.Builder.get();
        ProgrammaticUser userReqeest = userBuilder.setName("suganyaPro")
                                                  .setDescription("my programmatic user")
                                                  .setPolicies(userPoliciesList)
                                                  .build();
        ProgrammaticUserResponse createResponse = adminClient.createProgrammaticUser(userReqeest,"true");
        System.out.println(String.format("User Id: %s",createResponse.getId()));
        System.out.println(String.format("Token: %s",createResponse.getToken()));
        System.out.println(String.format("name: %s",createResponse.getName()));

        return createResponse.getId();
    }

    private static void getOrganizationUsers(SpotinstAccountAdminClient adminClient) {
        // Build user
        List<OrganizationUsers> orgUsers = adminClient.getOrganizationUsers();

        for ( OrganizationUsers user: orgUsers  ) {
            System.out.println(String.format("User Id: %s", user.getUserId()));
            System.out.println(String.format("User Name: %s", user.getUsername()));
            System.out.println(String.format("Type: %s", user.getType()));
            System.out.println(String.format("email: %s", user.getEmail()));
            System.out.println(String.format("mfa: %s", user.getMfa()));
            System.out.println(String.format("Group Names: %s", user.getGroupNames()));
            System.out.println();
        }
    }

    private static void updateGroupsofUsers(SpotinstAccountAdminClient adminClient) {
        // Build user
        List<String> userGroupIds = new ArrayList<>();
        userGroupIds.add("ugr-bc9e828f");

        Boolean updateStatus = adminClient.updateGroupsOfUser("u-ff653112", userGroupIds);

        System.out.println(String.format("Update user group status: %s", updateStatus));
    }

    private static void updateUserDirectPolicies(SpotinstAccountAdminClient adminClient) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add("act-1ac5e5df");

        // Build policy 1
        UserDirectPolicies.Builder updatePolicyBuilder1 = UserDirectPolicies.Builder.get();
        UserDirectPolicies         policy1              = updatePolicyBuilder1.setAccountIds(accountIds).setPolicyId("7").build();

        //Build policy 2
        UserDirectPolicies.Builder updatePolicyBuilder2 = UserDirectPolicies.Builder.get();
        UserDirectPolicies         policy2              = updatePolicyBuilder2.setPolicyId("4").build();

        List<UserDirectPolicies> policies = new ArrayList<>();
        policies.add(policy1);
        policies.add(policy2);

        UpdateUserDirectPoliciesRequest.Builder requestBuilder                  = UpdateUserDirectPoliciesRequest.Builder.get();
        UpdateUserDirectPoliciesRequest         updateUserDirectPoliciesRequest = requestBuilder.setPolicies(policies).build();

        Boolean updateStatus = adminClient.updateUserDirectPolicies("u-ff653112", updateUserDirectPoliciesRequest);

        System.out.println(String.format("Update user group status: %s", updateStatus));
    }

    private static String createPolicy(SpotinstAccountAdminClient adminClient){
        List<String> actions = new ArrayList<>();
        actions.add("*");

        List<String> resources = new ArrayList<>();
        resources.add("*");

        PolicyStatements.Builder statementBuilder = PolicyStatements.Builder.get();
        PolicyStatements statements = statementBuilder.setEffect(PolicyEffectEnum.ALLOW)
                                                      .setActions(actions)
                                                      .setResources(resources)
                                                      .build();

        PolicyContent.Builder contentBuilder = PolicyContent.Builder.get();
        PolicyContent policyContent = contentBuilder.setStatements(Collections.singletonList(statements)).build();

        Policy.Builder policyBuilder = Policy.Builder.get();
        Policy policy = policyBuilder.setName("Test Policy")
                                     .setDescription("My test policy")
                                     .setType(PolicyTypeEnum.ORGANIZATION)
                                     .setPolicyContent(policyContent)
                                     .build();

        Policy createPolicyResponse = adminClient.createPolicy(policy);

        System.out.println(String.format("Created policy Id: %s",createPolicyResponse.getId()));
        return createPolicyResponse.getId();
    }

    private static void updatePolicy(String policyId, SpotinstAccountAdminClient adminClient){
        List<String> actions = new ArrayList<>();
        actions.add("*");

        List<String> resources = new ArrayList<>();
        resources.add("*");

        PolicyStatements.Builder statementBuilder = PolicyStatements.Builder.get();
        PolicyStatements statements = statementBuilder.setEffect(PolicyEffectEnum.ALLOW)
                                                      .setActions(actions)
                                                      .setResources(resources)
                                                      .build();

        PolicyContent.Builder contentBuilder = PolicyContent.Builder.get();
        PolicyContent policyContent = contentBuilder.setStatements(Collections.singletonList(statements)).build();

        Policy.Builder policyBuilder = Policy.Builder.get();
        Policy policy = policyBuilder.setName("Test Policy")
                                     .setPolicyContent(policyContent)
                                     .build();

        Boolean status = adminClient.updatePolicy(policyId,policy);
        System.out.println(String.format("Update policy status: %s",status));
    }

    private static void getAllPolicies(SpotinstAccountAdminClient adminClient){
        List<Policy> policies = adminClient.getAllPolicies();

        for ( Policy policy: policies) {
            System.out.println(String.format("Policy Id: %s", policy.getId()));
            System.out.println(String.format("Policy Name: %s", policy.getName()));
            System.out.println(String.format("Policy Description: %s", policy.getDescription()));
            System.out.println(String.format("Policy Type: %s", policy.getType()));
            System.out.println(String.format("Created At: %s", policy.getCreatedAt()));
            System.out.println(String.format("Updated At: %s", policy.getUpdatedAt()));
            System.out.println();
        }
    }

    private static void deletePolicy(String policyId, SpotinstAccountAdminClient adminClient){
        Boolean deletionStatus= adminClient.deletePolicy(policyId);
        System.out.println(String.format("Policy deletion status: %s",deletionStatus));
    }
}
