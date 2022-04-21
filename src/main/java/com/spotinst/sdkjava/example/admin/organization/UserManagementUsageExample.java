package com.spotinst.sdkjava.example.admin.organization;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.SpotinstAdminOrganizationClient;
import com.spotinst.sdkjava.model.bl.admin.organization.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserManagementUsageExample {
    private final static String authToken = "auth_token";
    private final static String account_Id = "your-account-id";
    private final static String user_Id   = "user-id";
    private final static String user_Id1   = "user-id1";
    private final static String userEmail   = "userEmail@test.com";

    public static void main(String[] args) {
        SpotinstAdminOrganizationClient adminClient = SpotinstClient.getAdminOrganizationClient(authToken);

        // User APIs
        String userId = createUser(adminClient);
        getUsers(adminClient);
        getUserDetails(adminClient, userId);
        updateUserGroupMappingOfUser(adminClient, userId);
        deleteUser(adminClient, userId);
        updatePolicyMappingOfUser(adminClient, userId);
        getAccountUserMapping(adminClient, userEmail);

        // Programmatic User APIs
        String programmaticUserId = createProgammaticUser(adminClient);
        updateProgammaticUser(adminClient, programmaticUserId);
        getProgammaticUser(adminClient, programmaticUserId);
        getAllProgammaticUsers(adminClient);
        Boolean status = deleteProgammaticUser(adminClient, programmaticUserId);

        //User Group APIs
        String groupId = createUserGroup(adminClient);
        getUserGroups(adminClient);
        getUserGroupDetails(groupId, adminClient);
        updateUserGroupDetails(groupId, adminClient);
        deleteUserGroup(groupId, adminClient);
        updateUserMappingOfUserGroup(groupId, adminClient);
        updatePolicyMappingOfUserGroup(groupId, adminClient);

        //Organization APIs
        String organizationId = createOrganization(adminClient);
        Boolean deleteStatus = deleteOrganization(adminClient, organizationId);
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

    private static void getUsers(SpotinstAdminOrganizationClient adminClient) {
        // Build user
        List<Users> orgUsers = adminClient.getUsers();

        for (Users user : orgUsers) {
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

    private static void updateUserGroupMappingOfUser(SpotinstAdminOrganizationClient adminClient, String userId) {
        // Build user
        List<String> userGroupIds = new ArrayList<>();
        userGroupIds.add(user_Id);

        Boolean updateStatus = adminClient.updateUserGroupMappingOfUser(userId, userGroupIds);

        System.out.println(String.format("Update user group status: %s", updateStatus));
    }

    private static void updatePolicyMappingOfUser(SpotinstAdminOrganizationClient adminClient, String userId) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add(account_Id);

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
        accountIds.add(account_Id);

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
        userIds.add(user_Id);
        UserGroup createGroupRequest =
                groupBuilder.setName("TestUserGroup").setDescription("create group").setUserIds(userIds)
                        .setPolicies(policies).build();

        UserGroup createResponse = adminClient.createUserGroup(createGroupRequest);
        System.out.println(String.format("New group id: %s", createResponse.getId()));
        return createResponse.getId();
    }

    private static void getUserGroups(SpotinstAdminOrganizationClient adminClient) {

        List<UserGroups> groups = adminClient.getUserGroups();

        for (UserGroups group : groups) {
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

    private static void updatePolicyMappingOfUserGroup(String groupId, SpotinstAdminOrganizationClient adminClient) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add(account_Id);

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

        Boolean status = adminClient.updatePolicyMappingOfUserGroup(groupId, updatePoliciesRequest);
        System.out.println(String.format("Update status: %s", status));
    }

    private static void updateUserMappingOfUserGroup(String groupId, SpotinstAdminOrganizationClient adminClient) {

        List<String> userIds = new ArrayList<>();
        userIds.add(user_Id);
        userIds.add(user_Id1);

        Boolean status = adminClient.updateUserMappingOfUserGroup(groupId, userIds);
        System.out.println(String.format("Update status: %s", status));
    }

    private static void getAccountUserMapping(SpotinstAdminOrganizationClient adminClient, String userEmail) {

        List<GetAccountUserMapping> getAccountUserMapping = adminClient.getAccountUserMapping(userEmail);

        for (GetAccountUserMapping account : getAccountUserMapping) {
            System.out.println(String.format("Account Id: %s", account.getAccountId()));
            System.out.println(String.format("Role: %s", account.getRole()));
            System.out.println(String.format("Permission Strategy: %s", account.getPermissionStrategy()));
        }
    }

    private static String createProgammaticUser(SpotinstAdminOrganizationClient adminClient) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add(account_Id);

        PolicyMapping.Builder policiesBuilder = PolicyMapping.Builder.get();
        PolicyMapping         userPolicy      = policiesBuilder.setPolicyId("4").setAccountIds(accountIds).build();
        List<PolicyMapping>   userPolicyList  = Collections.singletonList(userPolicy);

        ProgrammaticUser.Builder userBuilder = ProgrammaticUser.Builder.get();
        ProgrammaticUser userRequest = userBuilder.setName("testProgram").setDescription("my programmatic user")
                .setPolicies(userPolicyList).build();
        CreateProgrammaticUserResponse createResponse = adminClient.createProgrammaticUser(userRequest);
        System.out.println(String.format("User Id: %s", createResponse.getId()));
        System.out.println(String.format("Token: %s", createResponse.getToken()));
        System.out.println(String.format("name: %s", createResponse.getName()));

        return createResponse.getId();
    }

    private static void updateProgammaticUser(SpotinstAdminOrganizationClient adminClient, String programmaticUserId) {

        List<String> accountIds = new ArrayList<>();
        accountIds.add(account_Id);

        ProgrammaticUserAccounts.Builder accountsBuilder = ProgrammaticUserAccounts.Builder.get();
        ProgrammaticUserAccounts account = accountsBuilder.setId(account_Id).setRole("viewer").build();
        List<ProgrammaticUserAccounts> accountsList = Collections.singletonList(account);

        ProgrammaticUser.Builder userBuilder = ProgrammaticUser.Builder.get();
        ProgrammaticUser userRequest = userBuilder.setDescription("my programmatic user").setAccounts(accountsList).build();
        ProgrammaticUserResponse updateResponse = adminClient.updateProgrammaticUser(userRequest, programmaticUserId);
        System.out.println(String.format("User Id: %s", updateResponse.getId()));
        System.out.println(String.format("UserName: %s", updateResponse.getUserName()));
        System.out.println(String.format("Description: %s", updateResponse.getDescription()));

        for (ProgrammaticUserAccounts accountDetails : updateResponse.getAccounts()) {
            System.out.println(String.format("Account Id: %s", accountDetails.getId()));
            System.out.println(String.format("Role: %s", accountDetails.getRole()));
        }
    }

    private static void getProgammaticUser(SpotinstAdminOrganizationClient adminClient, String programmaticUserId) {

        ProgrammaticUserResponse userResponse = adminClient.getProgrammaticUser(programmaticUserId);
        System.out.println(String.format("User Id: %s", userResponse.getId()));
        System.out.println(String.format("UserName: %s", userResponse.getUserName()));
        System.out.println(String.format("Description: %s", userResponse.getDescription()));

        for (ProgrammaticUserAccounts accountDetails : userResponse.getAccounts()) {
            System.out.println(String.format("Account Id: %s", accountDetails.getId()));
            System.out.println(String.format("Role: %s", accountDetails.getRole()));
        }
    }

    private static void getAllProgammaticUsers(SpotinstAdminOrganizationClient adminClient) {

        List<ProgrammaticUserResponse> userResponses = adminClient.getAllProgrammaticUsers();

        for (ProgrammaticUserResponse userResponse : userResponses) {
            System.out.println(String.format("User Id: %s", userResponse.getId()));
            System.out.println(String.format("UserName: %s", userResponse.getUserName()));
            System.out.println(String.format("Description: %s", userResponse.getDescription()));

            for (ProgrammaticUserAccounts accountDetails : userResponse.getAccounts()) {
                System.out.println(String.format("Account Id: %s", accountDetails.getId()));
                System.out.println(String.format("Role: %s", accountDetails.getRole()));
            }
        }
    }

    private static Boolean deleteProgammaticUser(SpotinstAdminOrganizationClient adminClient, String programmaticUserId) {
        Boolean status = adminClient.deleteProgrammaticUser(programmaticUserId);
        System.out.println(String.format("Programmatic User deletion status: %s\n" ,status));

        return status;
    }

    private static String createOrganization(SpotinstAdminOrganizationClient adminClient) {

        Organization.Builder organizationBuilder = Organization.Builder.get();
        Organization organization = organizationBuilder.setName("Test Organization").build();

        CreateOrganization.Builder createOrganizationBuilder = CreateOrganization.Builder.get();
        CreateOrganization createOrganizationRequest = createOrganizationBuilder.setOrganization(organization).build();

        CreateOrganizationResponse organizationResponse = adminClient.createOrganization(createOrganizationRequest);

        return organizationResponse.getOrganizationId();
    }

    private static Boolean deleteOrganization(SpotinstAdminOrganizationClient adminClient, String OrganizationId) {
        Boolean status = adminClient.deleteOrganization(OrganizationId);
        System.out.println(String.format("Organization deletion status: %s\n" ,status));

        return status;
    }
}