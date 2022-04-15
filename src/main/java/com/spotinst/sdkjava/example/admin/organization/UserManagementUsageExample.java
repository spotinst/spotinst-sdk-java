package com.spotinst.sdkjava.example.admin.organization;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.SpotinstAdminOrganizationClient;
import com.spotinst.sdkjava.model.bl.admin.organization.*;

import java.util.ArrayList;
import java.util.List;

public class UserManagementUsageExample {
    private final static String authToken = "auth_token";

    public static void main(String[] args) {
        SpotinstAdminOrganizationClient adminClient = SpotinstClient.getAdminOrganizationClient(authToken);

        // User APIs
        String userId = createUser(adminClient);
        getOrganizationUsers(adminClient);
        getUserDetails(adminClient, userId);
        updateUserGroupMapping(adminClient, userId);
        deleteUser(adminClient, userId);
        updatePolicyMappingOfUser(adminClient, userId);

        //User Group APIs
        String groupId = createUserGroup(adminClient);
        getOrganizationUserGroups(adminClient);
        getUserGroupDetails(groupId, adminClient);
        updateUserGroupDetails(groupId, adminClient);
        deleteUserGroup(groupId, adminClient);
        userGroupUpdateUserMapping(groupId, adminClient);
        userGroupUpdatePolicyMapping(groupId, adminClient);
    }

    private static String createUser(SpotinstAdminOrganizationClient adminClient) {
        // Build user
        User.Builder userBuilder = User.Builder.get();
        User userRequest =
                userBuilder.setFirstName("test").setLastName("123").setEmail("test@gmail.com").setPassword("Netapp123!")
                        .build();
        User userResponse = adminClient.createUser(userRequest);
        return userResponse.getUserId();
    }

    private static void getOrganizationUsers(SpotinstAdminOrganizationClient adminClient) {
        // Build user
        List<OrganizationUsers> orgUsers = adminClient.getOrganizationUsers();

        for (OrganizationUsers user : orgUsers) {
            System.out.println(String.format("User Id: %s", user.getUserId()));
            System.out.println(String.format("User Name: %s", user.getUsername()));
            System.out.println(String.format("Type: %s", user.getType()));
            System.out.println(String.format("email: %s", user.getEmail()));
            System.out.println(String.format("mfa: %s", user.getMfa()));
            System.out.println(String.format("Group Names: %s", user.getGroupNames()));
            System.out.println();
        }
    }

    private static void getUserDetails(SpotinstAdminOrganizationClient adminClient, String userId) {
        // Build user
        UserDetails userDetails = adminClient.getUserDetails(userId);
        System.out.println(String.format("userName: %s", userDetails.getUsername()));
        System.out.println(String.format("type: %s", userDetails.getType()));
        System.out.println(String.format("mfa: %s", userDetails.getMfa()));
    }

    private static void updateUserGroupMapping(SpotinstAdminOrganizationClient adminClient, String userId) {
        // Build user
        List<String> userGroupIds = new ArrayList<>();
        userGroupIds.add("ugr-bc9e828f");

        Boolean updateStatus = adminClient.updateUserGroupMapping(userId, userGroupIds);

        System.out.println(String.format("Update user group status: %s", updateStatus));
    }

    private static void updatePolicyMappingOfUser(SpotinstAdminOrganizationClient adminClient, String userId) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add("act-1ac5e5df");

        // Build policy 1
        PolicyMapping.Builder updatePolicyBuilder1 = PolicyMapping.Builder.get();
        PolicyMapping         policy1              = updatePolicyBuilder1.setAccountIds(accountIds).setPolicyId("7").build();

        //Build policy 2
        PolicyMapping.Builder updatePolicyBuilder2 = PolicyMapping.Builder.get();
        PolicyMapping         policy2              = updatePolicyBuilder2.setPolicyId("4").build();

        List<PolicyMapping> policies = new ArrayList<>();
        policies.add(policy1);
        policies.add(policy2);

        UpdatePoliciesRequest.Builder requestBuilder        = UpdatePoliciesRequest.Builder.get();
        UpdatePoliciesRequest         updatePoliciesRequest = requestBuilder.setPolicies(policies).build();

        Boolean updateStatus = adminClient.updatePolicyMappingOfUser(userId, updatePoliciesRequest);

        System.out.println(String.format("Update user group status: %s", updateStatus));
    }

    private static Boolean deleteUser(SpotinstAdminOrganizationClient adminClient, String userId) {
        Boolean status = adminClient.deleteUser(userId);
        System.out.println(String.format("User deletion status: %s\n" ,status));

        return status;
    }

    private static String createUserGroup(SpotinstAdminOrganizationClient adminClient) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add("act-1ac5e5df");

        // Build policy 1
        PolicyMapping.Builder updatePolicyBuilder1 = PolicyMapping.Builder.get();
        PolicyMapping         policy1              = updatePolicyBuilder1.setAccountIds(accountIds).setPolicyId("7").build();

        //Build policy 2
        PolicyMapping.Builder updatePolicyBuilder2 = PolicyMapping.Builder.get();
        PolicyMapping         policy2              = updatePolicyBuilder2.setPolicyId("4").build();

        List<PolicyMapping> policies = new ArrayList<>();
        policies.add(policy1);
        policies.add(policy2);

        UserGroup.Builder groupBuilder = UserGroup.Builder.get();
        List<String>      userIds      = new ArrayList<>();
        userIds.add("u-ff653112");
        UserGroup createGroupRequest =
                groupBuilder.setName("SuganyaGroup").setDescription("create group").setUserIds(userIds)
                        .setPolicies(policies).build();

        UserGroup createResponse = adminClient.createUserGroup(createGroupRequest);
        System.out.println(String.format("New group id: %s", createResponse.getId()));
        return createResponse.getId();
    }

    private static void getOrganizationUserGroups(SpotinstAdminOrganizationClient adminClient) {

        List<OrganizationUserGroups> groups = adminClient.getOrganizationUserGroups();

        for (OrganizationUserGroups group : groups) {
            System.out.println(String.format("Id: %s", group.getId()));
            System.out.println(String.format("Name: %s", group.getName()));
            System.out.println(String.format("Description: %s", group.getDescription()));
            System.out.println(String.format("Created At: %s", group.getCreatedAt()));
            System.out.println(String.format("Users count: %s", group.getUsersCount()));
            System.out.println(String.format("Policy Names: %s", group.getPolicyNames()));
            System.out.println();
        }
    }

    private static void getUserGroupDetails(String groupId, SpotinstAdminOrganizationClient adminClient) {

        UserGroupDetails details = adminClient.getUserGroupDetails(groupId);
        System.out.println(String.format("Name: %s", details.getName()));
        System.out.println(String.format("Description: %s", details.getDescription()));
        System.out.println(String.format("Created At: %s", details.getCreatedAt()));

        for (UserGroupDetailsPolicies policies : details.getPolicies()) {
            System.out.println(String.format("Policy Id: %s", policies.getPolicyId()));
            System.out.println(String.format("Policy Name: %s", policies.getPolicyName()));
            System.out.println(String.format("Policy Type: %s", policies.getPolicyType()));
            System.out.println(String.format("Policy Type: %s", policies.getAccountIds()));
        }

        for (UserGroupDetailsUsers user : details.getUsers()) {
            System.out.println(String.format("User Id: %s", user.getUserId()));
            System.out.println(String.format("User Name: %s", user.getUsername()));
            System.out.println(String.format("User Type: %s", user.getType()));
        }
    }

    private static void updateUserGroupDetails(String groupId, SpotinstAdminOrganizationClient adminClient) {

        Boolean status = adminClient.updateUserGroupDetails(groupId, "UpdatedName", "name updated");
        System.out.println(String.format("Update status: %s", status));
    }

    private static void deleteUserGroup(String groupId, SpotinstAdminOrganizationClient adminClient) {

        Boolean status = adminClient.deleteUserGroup(groupId);
        System.out.println(String.format("Deletion status: %s", status));
    }

    private static void userGroupUpdatePolicyMapping(String groupId, SpotinstAdminOrganizationClient adminClient) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add("act-1ac5e5df");

        // Build policy 1
        PolicyMapping.Builder updatePolicyBuilder1 = PolicyMapping.Builder.get();
        PolicyMapping         policy1              = updatePolicyBuilder1.setAccountIds(accountIds).setPolicyId("7").build();

        //Build policy 2
        PolicyMapping.Builder updatePolicyBuilder2 = PolicyMapping.Builder.get();
        PolicyMapping         policy2              = updatePolicyBuilder2.setPolicyId("4").build();

        List<PolicyMapping> policies = new ArrayList<>();
        policies.add(policy1);
        policies.add(policy2);

        UpdatePoliciesRequest.Builder requestBuilder        = UpdatePoliciesRequest.Builder.get();
        UpdatePoliciesRequest         updatePoliciesRequest = requestBuilder.setPolicies(policies).build();

        Boolean status = adminClient.userGroupUpdatePolicyMapping(groupId, updatePoliciesRequest);
        System.out.println(String.format("Update status: %s", status));
    }

    private static void userGroupUpdateUserMapping(String groupId, SpotinstAdminOrganizationClient adminClient) {

        List<String> userIds = new ArrayList<>();
        userIds.add("u-afadb82c");
        userIds.add("u-ff653112");

        Boolean status = adminClient.userGroupUpdateUserMapping(groupId, userIds);
        System.out.println(String.format("Update status: %s", status));
    }
}