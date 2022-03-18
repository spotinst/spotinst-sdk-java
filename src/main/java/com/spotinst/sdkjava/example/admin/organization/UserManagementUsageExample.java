package com.spotinst.sdkjava.example.admin.organization;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.admin.account.PolicyEffectEnum;
import com.spotinst.sdkjava.enums.admin.account.PolicyTypeEnum;
import com.spotinst.sdkjava.model.SpotinstAdminOrganizationClient;
import com.spotinst.sdkjava.model.bl.admin.organization.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserManagementUsageExample {
    private final static String authToken = "auth_token";

    public static void main(String[] args) {
        SpotinstAdminOrganizationClient adminClient = SpotinstClient.getAdminOrganizationClient(authToken);

        // User APIs
        String userId = createUser(adminClient);
        getUserDetails(adminClient, userId);
        String programmaticUser = createProgammaticUser(adminClient);
        getUserDetails(adminClient, programmaticUser);
        getOrganizationUsers(adminClient);
        updateGroupsofUsers(adminClient, userId);
        updateUserDirectPolicies(adminClient, userId);

        // Policy APIs
        String policyId = createPolicy(adminClient);
        updatePolicy(policyId, adminClient);
        deletePolicy(policyId, adminClient);
        getAllPolicies(adminClient);

        // Group APIs
        String groupId = createUserGroup(adminClient);
        updateUserGroupMappedPolicies(groupId, adminClient);
        updateUserGroupMappedUsers(groupId, adminClient);
        updateUserGroupDetails(groupId, adminClient);
        getUserGroup(groupId, adminClient);
        getOrganizationUserGroups(adminClient);
        deleteUserGroup(groupId, adminClient);
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

    private static void getUserDetails(SpotinstAdminOrganizationClient adminClient, String userId) {
        // Build user
        UserDetails userDetails = adminClient.getUserDetails(userId);
        System.out.println(String.format("userName: %s", userDetails.getUsername()));
        System.out.println(String.format("type: %s", userDetails.getType()));
        System.out.println(String.format("mfa: %s", userDetails.getMfa()));
    }

    private static String createProgammaticUser(SpotinstAdminOrganizationClient adminClient) {
        UserDetailsPolicy.Builder policiesBuilder = UserDetailsPolicy.Builder.get();
        UserDetailsPolicy         userPolicy      = policiesBuilder.setPolicyId("4").build();
        List<UserDetailsPolicy>   userPolicyList  = Collections.singletonList(userPolicy);

        ProgrammaticUser.Builder userBuilder = ProgrammaticUser.Builder.get();
        ProgrammaticUser userRequest = userBuilder.setName("testProgram").setDescription("my programmatic user")
                                                  .setPolicies(userPolicyList).build();
        ProgrammaticUserResponse createResponse = adminClient.createProgrammaticUser(userRequest);
        System.out.println(String.format("User Id: %s", createResponse.getId()));
        System.out.println(String.format("Token: %s", createResponse.getToken()));
        System.out.println(String.format("name: %s", createResponse.getName()));

        return createResponse.getId();
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

    private static void updateGroupsofUsers(SpotinstAdminOrganizationClient adminClient, String userId) {
        // Build user
        List<String> userGroupIds = new ArrayList<>();
        userGroupIds.add("ugr-bc9e828f");

        Boolean updateStatus = adminClient.updateGroupsOfUser(userId, userGroupIds);

        System.out.println(String.format("Update user group status: %s", updateStatus));
    }

    private static void updateUserDirectPolicies(SpotinstAdminOrganizationClient adminClient, String userId) {

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

        Boolean updateStatus = adminClient.updateUserDirectPolicies(userId, updatePoliciesRequest);

        System.out.println(String.format("Update user group status: %s", updateStatus));
    }

    private static String createPolicy(SpotinstAdminOrganizationClient adminClient) {
        List<String> actions = new ArrayList<>();
        actions.add("*");

        List<String> resources = new ArrayList<>();
        resources.add("*");

        PolicyStatement.Builder statementBuilder = PolicyStatement.Builder.get();
        PolicyStatement statements =
                statementBuilder.setEffect(PolicyEffectEnum.ALLOW).setActions(actions).setResources(resources).build();

        PolicyContent.Builder contentBuilder = PolicyContent.Builder.get();
        PolicyContent         policyContent  = contentBuilder.setStatements(Collections.singletonList(statements)).build();

        Policy.Builder policyBuilder = Policy.Builder.get();
        Policy policy = policyBuilder.setName("Test Policy").setDescription("My test policy")
                                     .setType(PolicyTypeEnum.ORGANIZATION).setPolicyContent(policyContent).build();

        Policy createPolicyResponse = adminClient.createPolicy(policy);

        System.out.println(String.format("Created policy Id: %s", createPolicyResponse.getId()));
        return createPolicyResponse.getId();
    }

    private static void updatePolicy(String policyId, SpotinstAdminOrganizationClient adminClient) {
        List<String> actions = new ArrayList<>();
        actions.add("*");

        List<String> resources = new ArrayList<>();
        resources.add("*");

        PolicyStatement.Builder statementBuilder = PolicyStatement.Builder.get();
        PolicyStatement statements =
                statementBuilder.setEffect(PolicyEffectEnum.ALLOW).setActions(actions).setResources(resources).build();

        PolicyContent.Builder contentBuilder = PolicyContent.Builder.get();
        PolicyContent policyContent = contentBuilder.setStatements(Collections.singletonList(statements)).build();

        Policy.Builder policyBuilder = Policy.Builder.get();
        Policy         policy        = policyBuilder.setName("Test Policy").setPolicyContent(policyContent).build();

        Boolean status = adminClient.updatePolicy(policyId, policy);
        System.out.println(String.format("Update policy status: %s", status));
    }

    private static void getAllPolicies(SpotinstAdminOrganizationClient adminClient) {
        List<Policy> policies = adminClient.getAllPolicies();

        for (Policy policy : policies) {
            System.out.println(String.format("Policy Id: %s", policy.getId()));
            System.out.println(String.format("Policy Name: %s", policy.getName()));
            System.out.println(String.format("Policy Description: %s", policy.getDescription()));
            System.out.println(String.format("Policy Type: %s", policy.getType()));
            System.out.println(String.format("Created At: %s", policy.getCreatedAt()));
            System.out.println(String.format("Updated At: %s", policy.getUpdatedAt()));
            System.out.println();
        }
    }

    private static void deletePolicy(String policyId, SpotinstAdminOrganizationClient adminClient) {
        Boolean deletionStatus = adminClient.deletePolicy(policyId);
        System.out.println(String.format("Policy deletion status: %s", deletionStatus));
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

    private static void updateUserGroupMappedPolicies(String groupId, SpotinstAdminOrganizationClient adminClient) {

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

        Boolean status = adminClient.updateUserGroupMappedPolicies(groupId, updatePoliciesRequest);
        System.out.println(String.format("Update status: %s", status));
    }

    private static void updateUserGroupMappedUsers(String groupId, SpotinstAdminOrganizationClient adminClient) {

        List<String> userIds = new ArrayList<>();
        userIds.add("u-afadb82c");
        userIds.add("u-ff653112");

        Boolean status = adminClient.updateUserGroupMappedUsers(groupId, userIds);
        System.out.println(String.format("Update status: %s", status));
    }

    private static void updateUserGroupDetails(String groupId, SpotinstAdminOrganizationClient adminClient) {

        Boolean status = adminClient.updateUserGroupDetails(groupId, "UpdatedName", "name updated");
        System.out.println(String.format("Update status: %s", status));
    }

    private static void deleteUserGroup(String groupId, SpotinstAdminOrganizationClient adminClient) {

        Boolean status = adminClient.deleteUserGroup(groupId);
        System.out.println(String.format("Deletion status: %s", status));
    }

    private static void getUserGroup(String groupId, SpotinstAdminOrganizationClient adminClient) {

        UserGroupDetails details = adminClient.getUserGroup(groupId);
        System.out.println(String.format("Name: %s", details.getName()));
        System.out.println(String.format("Description: %s", details.getDescription()));
        System.out.println(String.format("Created At: %s", details.getCreatedAt()));

        for (UserGroupDetailsPolicies policies : details.getPolicies()) {
            System.out.println(String.format("Policy Id: %s", policies.getPolicyId()));
            System.out.println(String.format("Policy Name: %s", policies.getPolicyName()));
            System.out.println(String.format("Policy Type: %s", policies.getPolicyType()));
        }

        for (UserGroupDetailsUsers user : details.getUsers()) {
            System.out.println(String.format("User Id: %s", user.getUserId()));
            System.out.println(String.format("User Name: %s", user.getUsername()));
            System.out.println(String.format("User Type: %s", user.getType()));
        }
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
}
